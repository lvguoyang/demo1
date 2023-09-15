package com.service.impl;

import com.mapper.InsuranceInsMapper;
import com.mapper.InsuranceInsOrderMapper;
import com.po.InsuranceIns;
import com.po.InsuranceInsOrder;
import com.service.InsuranceInsOrderService;
import com.service.InsuranceInsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InsuranceInsOrderServiceImpl implements InsuranceInsOrderService {
    @Autowired
    private InsuranceInsOrderMapper insOrderMapper;


    @Override
    public List<InsuranceInsOrder> getInsOrderPageAll(String userCode,int page, int rows) {
        return insOrderMapper.getInsOrderPageAll(userCode,page, rows);
    }

    @Override
    public int getMaxRows(String userCode) {
        return insOrderMapper.getMaxRows(userCode);
    }

    @Override
    public int insertInsOrder(InsuranceInsOrder insOrder) {
        return insOrderMapper.insertInsOrder(insOrder);
    }

    @Override
    public InsuranceInsOrder getInsOrderOne(InsuranceInsOrder insOrder) {
        return insOrderMapper.getInsOrderOne(insOrder);
    }

    @Override
    public int updateInsOrderIstype(InsuranceInsOrder insOrder) {
        return insOrderMapper.updateInsOrderIstype(insOrder);
    }
}
