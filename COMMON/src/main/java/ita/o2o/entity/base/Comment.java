package ita.o2o.entity.base;

import javax.persistence.*;

/**
 * @author Jason Cui
 * @version 2015-08-24
 */

@Entity
@Table(name="BUSINESS_COMMENT")//这里的更名是因为COMMENT也是关键字,囧
public class Comment {

    @Id
    @SequenceGenerator(sequenceName="SEQ_COMMENT",name="commentSequence",allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="commentSequence")
    @Column(name="COMMENT_ID",nullable = false)
    private int commentId;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User customer;

    @OneToOne
    @JoinColumn(name="BUSINESS_ID")
    private Business business;

    @Basic
    @Column(name="COMMENT_TIME")
    private String commentTime;

    @Basic
    @Column(name = "COMMENT_CONTENT")
    private String commentContent;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
