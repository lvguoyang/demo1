package com.service.impl;

import com.mapper.InsuranceMenuMapper;
import com.mapper.InsuranceRoleMenuMapper;
import com.po.InsuranceMenu;
import com.po.InsuranceRoleMenu;
import com.service.InsuranceMenuService;
import com.service.InsuranceRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class insuranceMenuServiceImpl implements InsuranceMenuService {
    @Autowired
    private InsuranceMenuMapper MenuMapper;


    @Override
    public List<InsuranceMenu> getByMenuId(Integer[] menuId) {
        return MenuMapper.getByMenuId(menuId);
    }
}
