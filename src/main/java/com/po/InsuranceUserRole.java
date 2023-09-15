package com.po;

import java.io.Serializable;

public class InsuranceUserRole implements Serializable {
    private Integer userid;//用户主键
    private Integer roleid;//角色主键

    public InsuranceUserRole(Integer userid, Integer roleid) {
        this.userid = userid;
        this.roleid = roleid;
    }

    public InsuranceUserRole() {
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "InsuranceUserRole{" +
                "userid=" + userid +
                ", roleid=" + roleid +
                '}';
    }
}
