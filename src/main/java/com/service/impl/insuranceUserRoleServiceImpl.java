package com.service.impl;

import com.mapper.InsuranceUserMapper;
import com.mapper.InsuranceUserRoleMapper;
import com.po.InsuranceUser;
import com.po.InsuranceUserRole;
import com.service.InsuranceUserRoleService;
import com.service.InsuranceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class insuranceUserRoleServiceImpl implements InsuranceUserRoleService {
    @Autowired
    private InsuranceUserRoleMapper userRoleMapper;
    @Override
    public List<InsuranceUserRole> getByUserId(Integer userId) {
        return userRoleMapper.getByUserId(userId);
    }
}
