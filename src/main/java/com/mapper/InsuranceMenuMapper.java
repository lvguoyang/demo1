package com.mapper;

import com.po.InsuranceMenu;
import com.po.InsuranceRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InsuranceMenuMapper {
    //通过menuId--->获取菜单信息--菜单表
    public List<InsuranceMenu> getByMenuId(Integer[] menuId);
}
