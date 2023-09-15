package com.service.impl;

import com.mapper.InsuranceInsOrderMapper;
import com.mapper.InsuranceOrderApplyMapper;
import com.po.InsuranceInsOrder;
import com.po.InsuranceOrderApply;
import com.service.InsuranceInsOrderService;
import com.service.InsuranceOrderApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InsuranceOrderApplyServiceImpl implements InsuranceOrderApplyService {
    @Autowired
    private InsuranceOrderApplyMapper orderApplyMapper;


    @Override
    public List<InsuranceOrderApply> getOrderPreliminaryPageAll(int page, int rows) {
        return orderApplyMapper.getOrderPreliminaryPageAll(page, rows);
    }

    @Override
    public int getMaxPreliminaryRows() {
        return orderApplyMapper.getMaxPreliminaryRows();
    }

    @Override
    public List<InsuranceOrderApply> getOrderReexaminePageAll(int page, int rows) {
        return orderApplyMapper.getOrderReexaminePageAll(page, rows);
    }

    @Override
    public int getMaxReexamineRows() {
        return orderApplyMapper.getMaxReexamineRows();
    }

    @Override
    public int insertOrderApply(InsuranceOrderApply orderApply) {
        return orderApplyMapper.insertOrderApply(orderApply);
    }

    @Override
    public int updateApplyIssart(InsuranceOrderApply orderApply) {
        return orderApplyMapper.updateApplyIssart(orderApply);
    }

    @Override
    public InsuranceOrderApply getOrderApplyOrderNo(InsuranceOrderApply orderApply) {
        return orderApplyMapper.getOrderApplyOrderNo(orderApply);
    }
}
