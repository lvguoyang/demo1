package com.service;

import com.po.InsuranceInsOrder;
import com.po.InsuranceOrderApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InsuranceOrderApplyService {
    /***分页查询初审对象*****/
    public List<InsuranceOrderApply> getOrderPreliminaryPageAll(int page, int rows);
    /***查询初审总记录数*****/
    public int getMaxPreliminaryRows();
    /***分页查询复审对象*****/
    public List<InsuranceOrderApply> getOrderReexaminePageAll(int page, int rows);
    /***查询复审总记录数*****/
    public int getMaxReexamineRows();
    /*****添加审核*****/
    public int insertOrderApply(InsuranceOrderApply orderApply);
    /*****修改审核订单*****/
    public int updateApplyIssart(InsuranceOrderApply orderApply);
    /*****查询审核订单*****/
    public InsuranceOrderApply getOrderApplyOrderNo(InsuranceOrderApply orderApply);
}
