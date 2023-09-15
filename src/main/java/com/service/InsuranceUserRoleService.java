package com.service;


import com.po.InsuranceUserRole;

import java.util.List;

public interface InsuranceUserRoleService {
    /***通过用户Id查询用户角色对象****/
    public List<InsuranceUserRole> getByUserId(Integer userId);
}
