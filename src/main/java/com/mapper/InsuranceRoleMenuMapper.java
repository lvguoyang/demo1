package com.mapper;

import com.po.InsuranceRoleMenu;
import com.po.InsuranceUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InsuranceRoleMenuMapper {
    /***通过角色Id查询用户角色菜单对象****/
    public List<InsuranceRoleMenu> getByRoleId(Integer[] roleId);
}
