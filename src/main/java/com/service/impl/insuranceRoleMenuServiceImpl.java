package com.service.impl;

import com.mapper.InsuranceRoleMenuMapper;

import com.po.InsuranceRoleMenu;

import com.service.InsuranceRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class insuranceRoleMenuServiceImpl implements InsuranceRoleMenuService {
    @Autowired
    private InsuranceRoleMenuMapper roleMenuMapper;

    @Override
    public List<InsuranceRoleMenu> getByRoleId(Integer[] roleId) {
        return roleMenuMapper.getByRoleId(roleId);
    }
}
