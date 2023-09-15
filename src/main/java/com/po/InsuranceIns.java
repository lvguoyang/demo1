package com.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

//保险产品实体类
public class InsuranceIns implements Serializable {
    private Integer id; //'主键',
    private String insName;//` 保险名称',
    private String  insType;//  '保险险种',
    private String details; // '保险介绍',
    private String buycondition;//'购买条件',
    private BigDecimal payAmount;// '购买金额',
    private String endDate; //'保险时间',
    private Date createtionDate;// '保险发布时间',
    private String  url;// '介绍文档',

    public InsuranceIns() {
    }

    public InsuranceIns(Integer id, String insName, String insType, String details, String buycondition, BigDecimal payAmount, String endDate, Date createtionDate, String url) {
        this.id = id;
        this.insName = insName;
        this.insType = insType;
        this.details = details;
        this.buycondition = buycondition;
        this.payAmount = payAmount;
        this.endDate = endDate;
        this.createtionDate = createtionDate;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInsName() {
        return insName;
    }

    public void setInsName(String insName) {
        this.insName = insName;
    }

    public String getInsType() {
        return insType;
    }

    public void setInsType(String insType) {
        this.insType = insType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getBuycondition() {
        return buycondition;
    }

    public void setBuycondition(String buycondition) {
        this.buycondition = buycondition;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Date getCreatetionDate() {
        return createtionDate;
    }

    public void setCreatetionDate(Date createtionDate) {
        this.createtionDate = createtionDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "InsuranceIns{" +
                "id=" + id +
                ", insName='" + insName + '\'' +
                ", insType='" + insType + '\'' +
                ", details='" + details + '\'' +
                ", buycondition='" + buycondition + '\'' +
                ", payAmount=" + payAmount +
                ", endDate='" + endDate + '\'' +
                ", createtionDate=" + createtionDate +
                ", url='" + url + '\'' +
                '}';
    }
}
