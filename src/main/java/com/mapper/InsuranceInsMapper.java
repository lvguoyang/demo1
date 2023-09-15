package com.mapper;

import com.po.InsuranceIns;
import com.po.InsuranceMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InsuranceInsMapper {
    //分页查询保险产品对象
    public List<InsuranceIns> getInsPageAll(@Param(value = "page") int page, @Param(value = "rows") int rows);
    //查询总记录数
    public int getMaxRows();
}
