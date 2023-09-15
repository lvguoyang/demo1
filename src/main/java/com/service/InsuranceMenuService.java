package com.service;


import com.po.InsuranceMenu;
import com.po.InsuranceRoleMenu;

import java.util.List;

public interface InsuranceMenuService {
    //通过menuId--->获取菜单信息--菜单表
    public List<InsuranceMenu> getByMenuId(Integer[] menuId);
}
