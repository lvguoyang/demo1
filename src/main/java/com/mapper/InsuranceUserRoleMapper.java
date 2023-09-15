package com.mapper;

import com.po.InsuranceUser;
import com.po.InsuranceUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InsuranceUserRoleMapper {
    /***通过用户Id查询用户角色对象****/
    public List<InsuranceUserRole> getByUserId(Integer userId);
}
