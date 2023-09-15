package com.po;


import java.io.Serializable;
import java.util.Date;

public class InsuranceUser implements Serializable {
    private Integer id;// '主键',
    private String userCode;// 账号（自注册，管理）',
    private String userPassword;// '密码',
    private Integer userType;//'账户类型（0自注册。。。。。。）',
    private String userName;// '用户姓名',
    private String weChat;// '联系方式',
    private String idnumber;//'身份证',
    private Date createDate;//'创建时间',
    private String createBy;// '创建人',
    private Date modifyDate;//'修改时间',
    private String modifyBy;//'修改人',
    private Integer activated;//'是否激活（0未激活，1已激活）',

    public InsuranceUser() {
    }

    public InsuranceUser(String userCode) {
        this.userCode = userCode;
    }

    public InsuranceUser(Integer id, String userCode, String userPassword, Integer userType, String userName, String weChat, String idnumber, Date createDate, String createBy, Date modifyDate, String modifyBy, Integer activated) {
        this.id = id;
        this.userCode = userCode;
        this.userPassword = userPassword;
        this.userType = userType;
        this.userName = userName;
        this.weChat = weChat;
        this.idnumber = idnumber;
        this.createDate = createDate;
        this.createBy = createBy;
        this.modifyDate = modifyDate;
        this.modifyBy = modifyBy;
        this.activated = activated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Integer getActivated() {
        return activated;
    }

    public void setActivated(Integer activated) {
        this.activated = activated;
    }

    @Override
    public String toString() {
        return "InsuranceUser{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userType=" + userType +
                ", userName='" + userName + '\'' +
                ", weChat='" + weChat + '\'' +
                ", idnumber='" + idnumber + '\'' +
                ", createDate=" + createDate +
                ", createBy='" + createBy + '\'' +
                ", modifyDate=" + modifyDate +
                ", modifyBy='" + modifyBy + '\'' +
                ", activated=" + activated +
                '}';
    }
}
