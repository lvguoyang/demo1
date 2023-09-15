package com.controller;

import com.po.*;
import com.service.InsuranceInsOrderService;
import com.service.InsuranceInsService;
import com.service.InsuranceOrderApplyService;
import com.service.InsuranceUserService;
import com.util.*;

import com.util.vo.InsuranceInsOrderInsertvo;
import com.util.vo.InsurancePagevo;
import com.util.vo.InsuranceUserInsAddOrdervo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/order")
public class InsuranceInsOrderController {
    @Autowired
    private InsuranceInsService insService;
    @Autowired
    private InsuranceUserService userService;
    @Autowired
    private InsuranceInsOrderService insOrderService;
    @Autowired
    private InsuranceOrderApplyService  orderApplyService;
    private Jedis jedis=new Jedis("127.0.0.1",6379);
    /**添加保险订单前信息准备***/
    @RequestMapping(value ="/getAddInsOrder")
    public Dto getAddInsOrder(HttpServletRequest request, HttpServletResponse response, @RequestBody InsuranceUserInsAddOrdervo insAddOrdervo){
        System.out.println("添加保险订单前信息方法............"+insAddOrdervo.toString());
        try {
            if(EmptyUtils.isNotEmpty(insAddOrdervo)){
                //通过账号查询用户信息
                InsuranceUser user=userService.getByUser(new InsuranceUser(insAddOrdervo.getUserCode()));
                //通过保险编号查询保险信息
                InsuranceIns ins=null;
                int maxRows=insService.getMaxRows();
                List<InsuranceIns> insList=insService.getInsPageAll(1,maxRows);
                for (InsuranceIns inss:insList){
                    if(inss.getId()==Integer.parseInt(insAddOrdervo.getInsId())){
                       ins=inss;
                    }
                }
                //封住返回信息
                InsuranceInsOrderInsertvo insertvo=new InsuranceInsOrderInsertvo();
                BeanUtils.copyProperties(user,insertvo);
                BeanUtils.copyProperties(ins,insertvo);
                insertvo.setInsId(ins.getId());
                System.out.println(insertvo.toString());
                return DtoUtil.returnSuccess("订单前数据准备",insertvo);
            }else{
                return DtoUtil.returnFail("添加保险订单信息传入数据异常", ErrorCode.AUTH_USER_ALREADY_EXISTS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail(e.getMessage(), ErrorCode.AUTH_USER_ALREADY_EXISTS);
        }
    }
    /**添加保险订单信息***/
    @RequestMapping(value ="/insertInsOrder")
    public Dto insertInsOrder(HttpServletRequest request, HttpServletResponse response, @RequestBody InsuranceInsOrderInsertvo orderInsertvo){
        System.out.println("添加保险订单信息方法............"+orderInsertvo.toString());
        try {
            if(EmptyUtils.isNotEmpty(orderInsertvo)){
                InsuranceInsOrder insOrder=new InsuranceInsOrder();
                //复制前端数据到后端
                BeanUtils.copyProperties(orderInsertvo,insOrder);

                //处理订单编号
                //生成订单号：机器码 +日期+（MD5）（商品IDs+用户id+毫秒数+1000000的(6位)随机数）
                StringBuilder md5String = new StringBuilder();
                md5String.append(orderInsertvo.getInsId());
                md5String.append(orderInsertvo.getUserCode());
                md5String.append(System.currentTimeMillis());
                md5String.append(Math.random() * 1000000);
                String md5 = MD5Util.getMd5(md5String.toString(), 6);
                //生成订单编号
                StringBuilder orderNo = new StringBuilder();
                orderNo.append("D1000001");
                orderNo.append(DateUtil.format(new Date(), "yyyyMMddHHmmss"));
                orderNo.append(md5);
                insOrder.setOrderNo(orderNo.toString());
                //申请时间
                insOrder.setApplyDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                //订单状态 0 申请中  1初审合格 2初审不合格 3 复审通过(待支付) 4 复审不同过  5支付成功(待生效) 6 支付失败 7.生效  8申请理赔  9理赔成功  10理赔失败  11保险失效
                insOrder.setIsType("0");
                int code=insOrderService.insertInsOrder(insOrder);
                if(code>0){
                    //将订单加入审核表
                    InsuranceOrderApply orderApply=new InsuranceOrderApply();
                    //订单编号
                    orderApply.setOrderNo(insOrder.getOrderNo());
                     //审核状态,
                    orderApply.setIsStart(0);
                    //订单时间,
                    orderApply.setOrderDate(insOrder.getApplyDate());
                    orderApplyService.insertOrderApply(orderApply);
                    return DtoUtil.returnSuccess("生成订单成功");
                }else{
                    return DtoUtil.returnFail("生成订单失败",ErrorCode.AUTH_USER_ALREADY_EXISTS);
                }
            }else{
                return DtoUtil.returnFail("添加保险订单信息传入数据异常", ErrorCode.AUTH_USER_ALREADY_EXISTS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail(e.getMessage(), ErrorCode.AUTH_USER_ALREADY_EXISTS);
        }
    }
    /**获取保险订单分页信息***/
    @RequestMapping(value ="/getInsOrderPageAll")
    public Dto getInsOrderPageAll(HttpServletRequest request, HttpServletResponse response, @RequestBody InsurancePagevo pagevo){
        System.out.println("获取保险订单分页信息方法............"+pagevo.toString());
        try {
          if(EmptyUtils.isNotEmpty(pagevo)){
              //通过分页方法获取相关数据
              List<InsuranceInsOrder> insOrderList=insOrderService.getInsOrderPageAll(pagevo.getUserCode(),pagevo.getCurrentPage(),pagevo.getPageSize());
              int maxRows=insOrderService.getMaxRows(pagevo.getUserCode());
              //封装返回到前端的分页信息
              Map<String,Object> map=new HashMap<>();
              map.put("insOrderList",insOrderList);
              map.put("maxRows",maxRows);
              return DtoUtil.returnSuccess("保险订单分页成功",map);
          }else{
              return DtoUtil.returnFail("获取保险产品分页信息传入数据异常", ErrorCode.AUTH_USER_ALREADY_EXISTS);
          }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail(e.getMessage(), ErrorCode.AUTH_USER_ALREADY_EXISTS);
        }
    }
    /**获取保险订单详情信息***/
    @RequestMapping(value ="/getShowInsOrderOne/{orderId}")
    public Dto getShowInsOne(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer orderId){
        System.out.println("获取保险订单详情信息方法............"+orderId);
        try {
            if(EmptyUtils.isNotEmpty(orderId)){
                InsuranceInsOrder insOrder=insOrderService.getInsOrderOne(new InsuranceInsOrder(orderId));
                return DtoUtil.returnSuccess("获取保险订单详情",insOrder);
            }else{
                return DtoUtil.returnFail("获取保险订单详情信息传入数据异常", ErrorCode.AUTH_USER_ALREADY_EXISTS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail(e.getMessage(), ErrorCode.AUTH_USER_ALREADY_EXISTS);
        }
    }

}
