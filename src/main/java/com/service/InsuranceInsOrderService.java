package com.service;

import com.po.InsuranceIns;
import com.po.InsuranceInsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InsuranceInsOrderService {
    /***分页查询订单对象*****/
    public List<InsuranceInsOrder> getInsOrderPageAll(String userCode, int page, int rows);
    /***查询订单总记录数*****/
    public int getMaxRows(String userCode);
    /*****添加订单*****/
    public int insertInsOrder(InsuranceInsOrder insOrder);
    /*****查询单个订单*****/
    public InsuranceInsOrder getInsOrderOne(InsuranceInsOrder insOrder);
    /*****订单状态修改*****/
    public int updateInsOrderIstype(InsuranceInsOrder insOrder);
}
