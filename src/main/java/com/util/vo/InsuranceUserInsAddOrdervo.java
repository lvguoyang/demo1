package com.util.vo;

import java.io.Serializable;
import java.util.Date;

public class InsuranceUserInsAddOrdervo implements Serializable {

    private String userCode;//'账号(自注册，管理员分配)',
    private String insId;// '保险编号',

    public InsuranceUserInsAddOrdervo() {
    }

    public InsuranceUserInsAddOrdervo(String userCode, String insId) {
        this.userCode = userCode;
        this.insId = insId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getInsId() {
        return insId;
    }

    @Override
    public String toString() {
        return "InsuranceUserInsAddOrdervo{" +
                "userCode='" + userCode + '\'' +
                ", insId='" + insId + '\'' +
                '}';
    }

    public void setInsId(String insId) {
        this.insId = insId;
    }
}
