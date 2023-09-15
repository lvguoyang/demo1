package com.po;

import java.math.BigDecimal;

public class InsuranceOrderApply {
    private  Integer  id;//审核编号
    private  String   orderNo;//订单编号
    private  int      isStart;//审核状态,
    private  String   commentspre;// 初审审核意见,
    private  String   commentsree;// 复审审核意见,
    private  String   preliminary;//初审账户,
    private  String   reexamine;// 复审账户,
    private  String   preliminaryDate;//初审时间,
    private  String   reexamineDate;// 复审时间,
    private  String   orderDate;//订单时间,

    public InsuranceOrderApply() {
    }

    public InsuranceOrderApply(String orderNo) {
        this.orderNo = orderNo;
    }

    public InsuranceOrderApply(Integer id, String orderNo, int isStart, String commentspre, String commentsree, String preliminary, String reexamine, String preliminaryDate, String reexamineDate, String orderDate) {
        this.id = id;
        this.orderNo = orderNo;
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
        return "InsuranceOrderApply{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
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
