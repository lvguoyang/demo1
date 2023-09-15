package com.controller;

import com.po.*;

import com.service.InsuranceUserService;
import com.util.DtoUtil;
import com.util.EmptyUtils;
import com.util.ErrorCode;

import com.util.vo.InsuranceUpdateUservo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.SimpleBeanInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;


@RestController
@RequestMapping(value = "/user")
/****************注册激活****************/
public class InsuranceUserController {
    @Autowired
    private InsuranceUserService userService;
    private Jedis jedis = new Jedis("127.0.0.1", 6379);

    /****获取User页面信息***/
    @RequestMapping(value = "/getindexUser/{userCode}")
    public Dto getindexUser(HttpServletRequest request, HttpServletResponse response, @PathVariable String userCode) {
        //userCode=1+userCode;
        System.out.println("获取User页面信息....." +userCode);

        try {
            if (EmptyUtils.isNotEmpty(userCode)) {
                //通过userCode(账号)---->获取userID
                InsuranceUser olduser=userService.getByUser(new InsuranceUser(userCode));
                System.out.println(olduser.getCreateDate());
                System.out.println(olduser.getWeChat());
                InsuranceUpdateUservo uservo=new InsuranceUpdateUservo();
                BeanUtils.copyProperties(olduser,uservo);
                //用户类型
                if (olduser.getUserType()==0){
                    uservo.setUserType("自注册");
                }else if(olduser.getUserType()==1){
                    //未定义
                }
                //创建时间
                uservo.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(olduser.getCreateDate()));
                //修改时间
                if (olduser.getModifyDate()!=null){
                    uservo.setModifyDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(olduser.getModifyDate()));
                }
                return DtoUtil.returnSuccess("user获取信息成功",uservo);

            } else {
                return DtoUtil.returnFail("user信息数据异常", ErrorCode.AUTH_USER_ALREADY_EXISTS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("错误", ErrorCode.AUTH_USER_ALREADY_EXISTS);
        }

    }
    /****获取User修改页面信息***/
    @RequestMapping(value = "/getindexUpdateUser")
    public Dto getindexUpdateUser(HttpServletRequest request, HttpServletResponse response, @RequestBody InsuranceUpdateUservo user) {
        System.out.println("获取User页面信息....." +user.toString());
        try {
            if (EmptyUtils.isNotEmpty(user)) {
                //对象修改（调方法）

                return DtoUtil.returnSuccess("user修改信息成功");

            } else {
                return DtoUtil.returnFail("user信息数据异常", ErrorCode.AUTH_USER_ALREADY_EXISTS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("错误", ErrorCode.AUTH_USER_ALREADY_EXISTS);
        }

    }
}