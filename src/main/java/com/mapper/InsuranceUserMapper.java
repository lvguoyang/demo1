package com.mapper;

import com.po.InsuranceUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InsuranceUserMapper {
    /***注册****/
    public int insert(InsuranceUser user);
    /***查询单个对象****/
    public InsuranceUser getByUser(InsuranceUser user);
    /***修改激活状态码****/
    public int updateValidate(InsuranceUser user);
}
