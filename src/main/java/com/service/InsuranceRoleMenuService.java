package com.service;


import com.po.InsuranceRoleMenu;


import java.util.List;

public interface InsuranceRoleMenuService {
    /***通过角色Id查询用户角色菜单对象****/
    public List<InsuranceRoleMenu> getByRoleId(Integer[] roleId);
}
