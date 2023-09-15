package com.controller;

import com.po.Dto;
import com.po.InsuranceIns;
import com.po.InsuranceUser;
import com.service.InsuranceInsService;
import com.service.InsuranceUserService;
import com.util.DtoUtil;
import com.util.EmptyUtils;
import com.util.ErrorCode;
import com.util.vo.InsurancePagevo;
import com.util.vo.InsuranceUpdateUservo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/ins")
/****************注册激活****************/
public class InsuranceInsController {
    @Autowired
    private InsuranceInsService insService;
    private Jedis jedis = new Jedis("127.0.0.1", 6379);

    /****获取保险产品分页信息***/
    @RequestMapping(value = "/getInsPageAll")
    public Dto getInsPageAll(HttpServletRequest request, HttpServletResponse response, @RequestBody InsurancePagevo pagevo) {
        System.out.println(pagevo.getUserCode());
        System.out.println("获取User页面信息....." +pagevo.toString());
        try {
            if (EmptyUtils.isNotEmpty(pagevo)) {
                //通过分页方法获取相关数据
                List<InsuranceIns> insList=insService.getInsPageAll(pagevo.getCurrentPage(),pagevo.getPageSize());
                int maxRows=insService.getMaxRows();
                System.out.println("成功");
                //封装返回到前端的分页信息
                Map<String,Object> map=new HashMap<>();
                map.put("insList",insList);
                map.put("maxRows",maxRows);
                System.out.println(insList);
                return DtoUtil.returnSuccess("分页信息获取成功",map);
            } else {
                return DtoUtil.returnFail("分页信息数据异常", ErrorCode.AUTH_USER_ALREADY_EXISTS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("错误", ErrorCode.AUTH_USER_ALREADY_EXISTS);
        }


    }
    /****获取保险产品详情信息***/
    @RequestMapping(value = "/getShowInsOne/{insId}")
    public Dto getShowInsOne(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer insId) {
        System.out.println("获取保险产品详情信息....." +insId);
        try {
            if (EmptyUtils.isNotEmpty(insId)) {
                //通过分页方法获取相关数据
                int maxRows=insService.getMaxRows();
                List<InsuranceIns> insList=insService.getInsPageAll(1,maxRows);
                System.out.println("成功");
                //封装返回到前端的分页信息
                for (InsuranceIns ins:insList){
                    if (ins.getId()==insId){
                        return DtoUtil.returnSuccess("获取保险产品详情",ins);
                    }
                }

            } else {
                return DtoUtil.returnFail("分页信息数据异常", ErrorCode.AUTH_USER_ALREADY_EXISTS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("错误", ErrorCode.AUTH_USER_ALREADY_EXISTS);
        }
        return DtoUtil.returnFail("失败", ErrorCode.AUTH_USER_ALREADY_EXISTS);

    }

}