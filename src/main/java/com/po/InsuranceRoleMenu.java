package com.po;

import java.io.Serializable;

public class InsuranceRoleMenu implements Serializable {
    private Integer roleId;
    private Integer menuId;

    public InsuranceRoleMenu() {
    }

    public InsuranceRoleMenu(Integer roleId, Integer menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "InsuranceRoleMenu{" +
                "roleId=" + roleId +
                ", menuId=" + menuId +
                '}';
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}
