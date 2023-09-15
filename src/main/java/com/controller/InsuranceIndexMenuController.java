package com.controller;

import com.po.*;
import com.service.InsuranceMenuService;
import com.service.InsuranceRoleMenuService;
import com.service.InsuranceUserRoleService;
import com.service.InsuranceUserService;
import com.util.*;
import com.util.vo.InsuranceMenuItemlistvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/index")
/****************注册激活****************/
public class InsuranceIndexMenuController {
    @Autowired
    private InsuranceUserService userService;
    @Autowired
    private InsuranceUserRoleService userRoleService;
    @Autowired
    private InsuranceRoleMenuService roleMenuService;
    @Autowired
    private InsuranceMenuService MenuService;
    Jedis jedis = new Jedis("127.0.0.1", 6379);

    /****获取主页面菜单信息***/
    @RequestMapping(value = "/getindexUserMenu/{userCode}")
    public Dto getindexUserMenu(HttpServletRequest request, HttpServletResponse response, @PathVariable String userCode) {
        System.out.println("获取主页面菜单信息方法....." + userCode);
        try {
            if (EmptyUtils.isNotEmpty(userCode)) {
                //通过userCode(账号)---->获取userID
                InsuranceUser olduser=userService.getByUser(new InsuranceUser(userCode));
                System.out.println("indexmenu---olduser:"+olduser.toString());
                Integer userId=olduser.getId();
                System.out.println("indexmenu---userid:"+userId);
                //通过userID-->获取多个roleId--->用户角色中间表
                List<InsuranceUserRole> userRoleList=userRoleService.getByUserId(userId);
                System.out.println("indexmenu---userRolelist:"+userRoleList.size());
                Integer[] roleId=new Integer[userRoleList.size()];
                for (int i=0;i<userRoleList.size();i++){
                    roleId[i]=userRoleList.get(i).getRoleid();
                }
                System.out.println("indexmenu---roleId:"+roleId.length);
                //通过roleId--->获取多个menuId--角色菜单中间表
                List<InsuranceRoleMenu> roleMenuList=roleMenuService.getByRoleId(roleId);
                System.out.println("indexmenu---roleMenuList:"+roleMenuList.size());
                Integer[] menuId=new Integer[roleMenuList.size()];
                for (int i=0;i<roleMenuList.size();i++){
                    menuId[i]=roleMenuList.get(i).getMenuId();
                }
                System.out.println("indexmenu---menuId:"+menuId.length);

                //通过menuId--->获取菜单信息--菜单表m
                List<InsuranceMenu> menuList=MenuService.getByMenuId(menuId);
                //封装前端返回
                //封装一级菜单
                List<InsuranceMenuItemlistvo> MenuItemlistvoList=new ArrayList<>();
                for (int i=0;i<menuList.size();i++){
                    InsuranceMenu menu=menuList.get(i);
                    if (menu.getPid().equals("0")){
                        InsuranceMenuItemlistvo vo=new InsuranceMenuItemlistvo();
                        vo.setIndex(menu.getId()+"");
                        vo.setMouduleurl(menu.getUrl());
                        vo.setText(menu.getTextcontet());
                        MenuItemlistvoList.add(vo);
                    }
                }
                //封装二级菜单
                    //遍历一级菜单获取
                for (int i=0;i<MenuItemlistvoList.size();i++){
                    //获取一级菜单id
                    int menuId1=Integer.parseInt(MenuItemlistvoList.get(i).getIndex());
                    //二级菜单返回
                    List<InsuranceMenuItemlistvo> MenuItemlistvoList2=new ArrayList<>();
                    //遍历菜单集合，获取pid等于menuId1的菜单作为二级菜单
                    for (int j=0;j<menuList.size();j++){
                        if(menuList.get(j).getPid().equals(menuId1+"")){
                            InsuranceMenuItemlistvo vo=new InsuranceMenuItemlistvo();
                            vo.setIndex(menuList.get(j).getId()+"");
                            vo.setMouduleurl(menuList.get(j).getUrl());
                            vo.setText(menuList.get(j).getTextcontet());
                            MenuItemlistvoList2.add(vo);
                        }
                    }
                    InsuranceMenuItemlistvo vvo= MenuItemlistvoList.get(i);
                    vvo.setNodes(MenuItemlistvoList2);
                    MenuItemlistvoList.set(i,vvo);
                }
                return DtoUtil.returnSuccess("菜单获取成功",MenuItemlistvoList);
            } else {
                return DtoUtil.returnFail("登陆传入数据异常", ErrorCode.AUTH_USER_ALREADY_EXISTS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("错误", ErrorCode.AUTH_USER_ALREADY_EXISTS);
        }

    }

}