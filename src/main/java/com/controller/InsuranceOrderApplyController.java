package com.controller;

import com.po.*;
import com.service.InsuranceInsOrderService;
import com.service.InsuranceInsService;
import com.service.InsuranceOrderApplyService;
import com.service.InsuranceUserService;
import com.util.*;
import com.util.vo.*;
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
@RequestMapping(value = "/apply")
public class InsuranceOrderApplyController {
    @Autowired
    private InsuranceOrderApplyService orderApplyService;
    @Autowired
    private InsuranceInsOrderService insOrderService;
    private Jedis jedis=new Jedis("127.0.0.1",6379);
    /**获取初审订单分页信息***/
    @RequestMapping(value ="/getOrderPreliminaryPageAll")
    public Dto getOrderPreliminaryPageAll(HttpServletRequest request, HttpServletResponse response, @RequestBody InsurancePagevo pagevo){
        System.out.println("获取初审订单分页信息方法............"+pagevo.toString());
        try {
          if(EmptyUtils.isNotEmpty(pagevo)){
              //通过分页方法获取相关数据
              List<InsuranceOrderApply> orderApplyList=orderApplyService.getOrderPreliminaryPageAll(pagevo.getCurrentPage(),pagevo.getPageSize());
              int maxRows=orderApplyService.getMaxPreliminaryRows();
              //封装返回到前端的分页信息
              Map<String,Object> map=new HashMap<>();
              map.put("orderApplyList",orderApplyList);
              map.put("maxRows",maxRows);
              return DtoUtil.returnSuccess("初审订单分页成功",map);
          }else{
              return DtoUtil.returnFail("获取初审订单分页信息传入数据异常", ErrorCode.AUTH_USER_ALREADY_EXISTS);
          }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail(e.getMessage(), ErrorCode.AUTH_USER_ALREADY_EXISTS);
        }
    }
    /**获取复审订单分页信息***/
    @RequestMapping(value ="/getOrderReexaminePageAll")
    public Dto getOrderReexaminePageAll(HttpServletRequest request, HttpServletResponse response, @RequestBody InsurancePagevo pagevo){
        System.out.println("获取初审订单分页信息方法............"+pagevo.toString());
        try {
            if(EmptyUtils.isNotEmpty(pagevo)){
                //通过分页方法获取相关数据
                List<InsuranceOrderApply> orderApplyList=orderApplyService.getOrderReexaminePageAll(pagevo.getCurrentPage(),pagevo.getPageSize());
                int maxRows=orderApplyService.getMaxReexamineRows();
                //封装返回到前端的分页信息
                Map<String,Object> map=new HashMap<>();
                map.put("orderApplyList",orderApplyList);
                map.put("maxRows",maxRows);
                return DtoUtil.returnSuccess("复审订单分页成功",map);
            }else{
                return DtoUtil.returnFail("获取复审订单分页信息传入数据异常", ErrorCode.AUTH_USER_ALREADY_EXISTS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail(e.getMessage(), ErrorCode.AUTH_USER_ALREADY_EXISTS);
        }
    }
    /**获取保险订单审核详情信息***/
    @RequestMapping(value ="/getShowOrderApplyOne/{orderNo}")
    public Dto getShowInsOne(HttpServletRequest request, HttpServletResponse response, @PathVariable String orderNo){
        System.out.println("获取保险订单审核详情信息方法............"+orderNo);
        try {
            if(EmptyUtils.isNotEmpty(orderNo)){
                //订单信息
                InsuranceInsOrder insOrder=insOrderService.getInsOrderOne(new InsuranceInsOrder(orderNo));
                //审核信息
                InsuranceOrderApply orderApply=orderApplyService.getOrderApplyOrderNo(new InsuranceOrderApply(orderNo));
                //封装返回
                InsuranceOrderApplyvo applyvo=new InsuranceOrderApplyvo();
                BeanUtils.copyProperties(insOrder,applyvo);
                BeanUtils.copyProperties(orderApply,applyvo);
                applyvo.setId(orderApply.getId());
                return DtoUtil.returnSuccess("获取保险订单审核详情信息成功",applyvo);
            }else{
                return DtoUtil.returnFail("获取保险订单审核信息传入数据异常", ErrorCode.AUTH_USER_ALREADY_EXISTS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail(e.getMessage(), ErrorCode.AUTH_USER_ALREADY_EXISTS);
        }
    }
    /**初审同意***/
    @RequestMapping(value ="/getPreliminaryOk")
    public Dto getPreliminaryOk(HttpServletRequest request, HttpServletResponse response, @RequestBody InsuranceOrderApplyOkNovo applyOkNovo){
        System.out.println("初审同意信息方法............"+applyOkNovo);
        try {
            if(EmptyUtils.isNotEmpty(applyOkNovo)){
                //订单信息（修改 0-1）
                InsuranceInsOrder insOrder=new InsuranceInsOrder();
                insOrder.setOrderNo(applyOkNovo.getOrderNo());
                insOrder.setIsType("1");
                int code= insOrderService.updateInsOrderIstype(insOrder);
                //审核信息（修改 0-1）
                InsuranceOrderApply orderApply=new InsuranceOrderApply();
                orderApply.setOrderNo(applyOkNovo.getOrderNo());
                //审核意见
                orderApply.setCommentspre(applyOkNovo.getCommentspre());
                //审核人
                orderApply.setPreliminary(applyOkNovo.getPreliminary());
                //审核时间
                orderApply.setPreliminaryDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                //修改状态
                orderApply.setIsStart(1);
                int code1=orderApplyService.updateApplyIssart(orderApply);
                if(code>0 && code1>0) {
                    return DtoUtil.returnSuccess("初审同意成功");
                }else{
                    return DtoUtil.returnFail("初审同意失败", ErrorCode.AUTH_USER_ALREADY_EXISTS);
                }
            }else{
                return DtoUtil.returnFail("初审同意传入数据异常", ErrorCode.AUTH_USER_ALREADY_EXISTS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail(e.getMessage(), ErrorCode.AUTH_USER_ALREADY_EXISTS);
        }
    }
    /**初审拒保***/
    @RequestMapping(value ="/getPreliminaryNo")
    public Dto getPreliminaryNo(HttpServletRequest request, HttpServletResponse response, @RequestBody InsuranceOrderApplyOkNovo applyOkNovo){
        System.out.println("初审拒保信息方法............"+applyOkNovo);
        try {
            if(EmptyUtils.isNotEmpty(applyOkNovo)){
                //订单信息（修改 0-1）
                InsuranceInsOrder insOrder=new InsuranceInsOrder();
                insOrder.setOrderNo(applyOkNovo.getOrderNo());
                insOrder.setIsType("2");
                int code= insOrderService.updateInsOrderIstype(insOrder);
                //审核信息（修改 0-1）
                InsuranceOrderApply orderApply=new InsuranceOrderApply();
                orderApply.setOrderNo(applyOkNovo.getOrderNo());
                //审核意见
                orderApply.setCommentspre(applyOkNovo.getCommentspre());
                //审核人
                orderApply.setPreliminary(applyOkNovo.getPreliminary());
                //审核时间
                orderApply.setPreliminaryDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                //修改状态
                orderApply.setIsStart(2);
                int code1=orderApplyService.updateApplyIssart(orderApply);
                if(code>0 && code1>0) {
                    return DtoUtil.returnSuccess("初审拒保成功");
                }else{
                    return DtoUtil.returnFail("初审拒保失败", ErrorCode.AUTH_USER_ALREADY_EXISTS);
                }
            }else{
                return DtoUtil.returnFail("初审拒保传入数据异常", ErrorCode.AUTH_USER_ALREADY_EXISTS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail(e.getMessage(), ErrorCode.AUTH_USER_ALREADY_EXISTS);
        }
    }
    /**复审同意***/
    @RequestMapping(value ="/getReexamineOk")
    public Dto getReexamineOk(HttpServletRequest request, HttpServletResponse response, @RequestBody InsuranceOrderApplyOkNovo applyOkNovo){
        System.out.println("复审同意信息方法............"+applyOkNovo);
        try {
            if(EmptyUtils.isNotEmpty(applyOkNovo)){
                //订单信息（修改 1-3）
                InsuranceInsOrder insOrder=new InsuranceInsOrder();
                insOrder.setOrderNo(applyOkNovo.getOrderNo());
                insOrder.setApproverDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                insOrder.setIsType("3");
                int code= insOrderService.updateInsOrderIstype(insOrder);
                //审核信息（修改 1-3）
                InsuranceOrderApply orderApply=new InsuranceOrderApply();
                orderApply.setOrderNo(applyOkNovo.getOrderNo());
                //审核意见
                orderApply.setCommentsree(applyOkNovo.getCommentsree());
                //审核人
                orderApply.setReexamine(applyOkNovo.getReexamine());
                //审核时间
                orderApply.setReexamineDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                //修改状态
                orderApply.setIsStart(3);
                int code1=orderApplyService.updateApplyIssart(orderApply);
                if(code>0 && code1>0) {
                    return DtoUtil.returnSuccess("复审同意成功");
                }else{
                    return DtoUtil.returnFail("复审同意失败", ErrorCode.AUTH_USER_ALREADY_EXISTS);
                }
            }else{
                return DtoUtil.returnFail("复审同意传入数据异常", ErrorCode.AUTH_USER_ALREADY_EXISTS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail(e.getMessage(), ErrorCode.AUTH_USER_ALREADY_EXISTS);
        }
    }
    /**复审拒保***/
    @RequestMapping(value ="/getReexamineNo")
    public Dto getReexamineNo(HttpServletRequest request, HttpServletResponse response, @RequestBody InsuranceOrderApplyOkNovo applyOkNovo){
        System.out.println("复审拒保信息方法............"+applyOkNovo);
        try {
            if(EmptyUtils.isNotEmpty(applyOkNovo)){
                //订单信息（修改 1-4）
                InsuranceInsOrder insOrder=new InsuranceInsOrder();
                insOrder.setOrderNo(applyOkNovo.getOrderNo());
                insOrder.setIsType("4");
                int code= insOrderService.updateInsOrderIstype(insOrder);
                //审核信息（修改 1-4）
                InsuranceOrderApply orderApply=new InsuranceOrderApply();
                orderApply.setOrderNo(applyOkNovo.getOrderNo());
                //审核意见
                orderApply.setCommentsree(applyOkNovo.getCommentsree());
                //审核人
                orderApply.setReexamine(applyOkNovo.getReexamine());
                //审核时间
                orderApply.setReexamineDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                //修改状态
                orderApply.setIsStart(4);
                int code1=orderApplyService.updateApplyIssart(orderApply);
                if(code>0 && code1>0) {
                    return DtoUtil.returnSuccess("复审拒保成功");
                }else{
                    return DtoUtil.returnFail("复审拒保失败", ErrorCode.AUTH_USER_ALREADY_EXISTS);
                }
            }else{
                return DtoUtil.returnFail("复审拒保传入数据异常", ErrorCode.AUTH_USER_ALREADY_EXISTS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail(e.getMessage(), ErrorCode.AUTH_USER_ALREADY_EXISTS);
        }
    }

}
