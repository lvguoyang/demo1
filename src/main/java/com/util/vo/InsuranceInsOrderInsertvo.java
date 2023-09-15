package com.util.vo;

import java.math.BigDecimal;
/***
 * 订单添加前端传递后端数据
 *
 * */
public class InsuranceInsOrderInsertvo {
    private  Integer  insId ;//保险编号
    private  String   insName;//保险名称
    private  String   insType ;//险种
    private  String   details ;//保险介绍（保存附文本）
    private  String   buycondition ;//购买条件
    private  BigDecimal payAmount ;//支付金额
    private  String   endDate ;//保险时间
    private  String   userCode ;//投保人编号
    private  String   userName ;//投保人真实姓名
    private  String   weChat ;//投保人微信号
    private  String   idnumber ;//投保人身份证号
    private  String   insBname ;//被保险人姓名
    private  String   insBidnumber ;//被保险人身份证
    private  String   insRname ;//受益人姓名
    private  String   insRidnumber;//受益人人身份证

    public InsuranceInsOrderInsertvo() {
    }

    public InsuranceInsOrderInsertvo(Integer insId, String insName, String insType, String details, String buycondition, BigDecimal payAmount, String endDate, String userCode, String userName, String weChat, String idnumber, String insBname, String insBidnumber, String insRname, String insRidnumber) {
        this.insId = insId;
        this.insName = insName;
        this.insType = insType;
        this.details = details;
        this.buycondition = buycondition;
        this.payAmount = payAmount;
        this.endDate = endDate;
        this.userCode = userCode;
        this.userName = userName;
        this.weChat = weChat;
        this.idnumber = idnumber;
        this.insBname = insBname;
        this.insBidnumber = insBidnumber;
        this.insRname = insRname;
        this.insRidnumber = insRidnumber;
    }

    public Integer getInsId() {
        return insId;
    }

    public void setInsId(Integer insId) {
        this.insId = insId;
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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
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

    public String getInsBname() {
        return insBname;
    }

    public void setInsBname(String insBname) {
        this.insBname = insBname;
    }

    public String getInsBidnumber() {
        return insBidnumber;
    }

    public void setInsBidnumber(String insBidnumber) {
        this.insBidnumber = insBidnumber;
    }

    public String getInsRname() {
        return insRname;
    }

    public void setInsRname(String insRname) {
        this.insRname = insRname;
    }

    public String getInsRidnumber() {
        return insRidnumber;
    }

    public void setInsRidnumber(String insRidnumber) {
        this.insRidnumber = insRidnumber;
    }

    @Override
    public String toString() {
        return "InsuranceInsOrderInsertvo{" +
                "insId=" + insId +
                ", insName='" + insName + '\'' +
                ", insType='" + insType + '\'' +
                ", details='" + details + '\'' +
                ", buycondition='" + buycondition + '\'' +
                ", payAmount=" + payAmount +
                ", endDate='" + endDate + '\'' +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", weChat='" + weChat + '\'' +
                ", idnumber='" + idnumber + '\'' +
                ", insBname='" + insBname + '\'' +
                ", insBidnumber='" + insBidnumber + '\'' +
                ", insRname='" + insRname + '\'' +
                ", insRidnumber='" + insRidnumber + '\'' +
                '}';
    }
}
