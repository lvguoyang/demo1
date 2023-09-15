package com.service.impl;

import com.mapper.InsuranceUserMapper;
import com.po.InsuranceUser;
import com.service.InsuranceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class insuranceUserServiceImpl implements InsuranceUserService {
    @Autowired
    private InsuranceUserMapper userMapper;
    @Override
    public int insert(InsuranceUser user) {
        return userMapper.insert(user);
    }

    @Override
    public InsuranceUser getByUser(InsuranceUser user) {
        return userMapper.getByUser(user);
    }

    @Override
    public int updateValidate(InsuranceUser user) {
        return userMapper.updateValidate(user);
    }
}
