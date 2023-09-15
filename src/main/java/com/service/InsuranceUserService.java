package com.service;

import com.po.InsuranceUser;

public interface InsuranceUserService {
    /***注册****/
    public int insert(InsuranceUser user);
    /***查询单个对象****/
    public InsuranceUser getByUser(InsuranceUser user);
    /***修改激活状态码****/
    public int updateValidate(InsuranceUser user);
}
