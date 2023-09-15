package com.util.vo;

import java.math.BigDecimal;

public class InsuranceOrderApplyvo {
    private  Integer  id;//审核编号
    private  String   orderNo;//订单编号
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
    private  String   applyDate ;//申请时间
    private  String   approverDate ;//批准时间
    private  String   effectDate ;//生效时间
    private  String   isType ;//订单状态
    private  int      isStart;//审核状态,
    private  String   commentspre;// 审核意见,
    private  String   commentsree;// 审核意见,
    private  String   preliminary;//初审账户,
    private  String   reexamine;// 复审账户,
    private  String   preliminaryDate;//初审时间,
    private  String   reexamineDate;// 复审时间,
    private  String   orderDate;//订单时间,
    public InsuranceOrderApplyvo() {
    }

    public InsuranceOrderApplyvo(Integer id, String orderNo, Integer insId, String insName, String insType, String details, String buycondition, BigDecimal payAmount, String endDate, String userCode, String userName, String weChat, String idnumber, String insBname, String insBidnumber, String insRname, String insRidnumber, String applyDate, String approverDate, String effectDate, String isType, int isStart, String commentspre, String commentsree, String preliminary, String reexamine, String preliminaryDate, String reexamineDate, String orderDate) {        this.id = id;
        this.orderNo = orderNo;
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
        this.applyDate = applyDate;
        this.approverDate = approverDate;
        this.effectDate = effectDate;
        this.isType = isType;
        this.isStart = isStart;
        this.commentspre = commentspre;
        this.commentsree = commentsree;
        this.preliminary = preliminary;
        this.reexamine = reexamine;
        this.preliminaryDate = preliminaryDate;
        this.reexamineDate = reexamineDate;
        this.orderDate = orderDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getApproverDate() {
        return approverDate;
    }

    public void setApproverDate(String approverDate) {
        this.approverDate = approverDate;
    }

    public String getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(String effectDate) {
        this.effectDate = effectDate;
    }

    public String getIsType() {
        return isType;
    }

    public void setIsType(String isType) {
        this.isType = isType;
    }

    public int getIsStart() {
        return isStart;
    }

    public void setIsStart(int isStart) {
        this.isStart = isStart;
    }

    public String getCommentspre() {
        return commentspre;
    }

    public void setCommentspre(String commentspre) {
        this.commentspre = commentspre;
    }

    public String getCommentsree() {
        return commentsree;
    }

    public void setCommentsree(String commentsree) {
        this.commentsree = commentsree;
    }

    public String getPreliminary() {
        return preliminary;
    }

    public void setPreliminary(String preliminary) {
        this.preliminary = preliminary;
    }

    public String getReexamine() {
        return reexamine;
    }

    public void setReexamine(String reexamine) {
        this.reexamine = reexamine;
    }

    public String getPreliminaryDate() {
        return preliminaryDate;
    }

    public void setPreliminaryDate(String preliminaryDate) {
        this.preliminaryDate = preliminaryDate;
    }

    public String getReexamineDate() {
        return reexamineDate;
    }

    public void setReexamineDate(String reexamineDate) {
        this.reexamineDate = reexamineDate;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "InsuranceOrderApplyvo{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", insId=" + insId +
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
                ", applyDate='" + applyDate + '\'' +
                ", approverDate='" + approverDate + '\'' +
                ", effectDate='" + effectDate + '\'' +
                ", isType='" + isType + '\'' +
                ", isStart=" + isStart +
                ", commentspre='" + commentspre + '\'' +
                ", commentsree='" + commentsree + '\'' +
                ", preliminary='" + preliminary + '\'' +
                ", reexamine='" + reexamine + '\'' +
                ", preliminaryDate='" + preliminaryDate + '\'' +
                ", reexamineDate='" + reexamineDate + '\'' +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }
}
