package com.util.vo;

public class InsuranceOrderApplyOkNovo {
    private  String   orderNo;//订单编号
    private  String   commentspre;// 审核意见,
    private  String   preliminary;//初审账户,
    private  String   commentsree;// 审核意见,
    private  String   reexamine;// 复审账户,

    public InsuranceOrderApplyOkNovo() {
    }

    public InsuranceOrderApplyOkNovo(String orderNo, String commentspre, String preliminary, String commentsree, String reexamine) {
        this.orderNo = orderNo;
        this.commentspre = commentspre;
        this.preliminary = preliminary;
        this.commentsree = commentsree;
        this.reexamine = reexamine;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCommentspre() {
        return commentspre;
    }

    public void setCommentspre(String commentspre) {
        this.commentspre = commentspre;
    }

    public String getPreliminary() {
        return preliminary;
    }

    public void setPreliminary(String preliminary) {
        this.preliminary = preliminary;
    }

    public String getCommentsree() {
        return commentsree;
    }

    public void setCommentsree(String commentsree) {
        this.commentsree = commentsree;
    }

    public String getReexamine() {
        return reexamine;
    }

    public void setReexamine(String reexamine) {
        this.reexamine = reexamine;
    }

    @Override
    public String toString() {
        return "InsuranceOrderApplyOkNovo{" +
                "orderNo='" + orderNo + '\'' +
                ", commentspre='" + commentspre + '\'' +
                ", preliminary='" + preliminary + '\'' +
                ", commentsree='" + commentsree + '\'' +
                ", reexamine='" + reexamine + '\'' +
                '}';
    }
}
