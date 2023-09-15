package com.service.impl;

import com.mapper.*;
import com.po.InsuranceIns;
import com.po.InsuranceMenu;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class insuranceInsServiceImpl implements InsuranceInsService {
    @Autowired
    private InsuranceInsMapper insMapper;

    @Override
    public List<InsuranceIns> getInsPageAll(int page, int rows) {
        return insMapper.getInsPageAll(page,rows);
    }

    @Override
    public int getMaxRows() {
        return insMapper.getMaxRows();
    }
}
