package ita.o2o.entity.base;

import ita.o2o.entity.extra.Status;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */

@Entity
@Table(name="O2O_ORDER")
public class Order {

    @Id
    @SequenceGenerator(sequenceName="SEQ_ORDER",name="orderSequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="orderSequence")
    @Column(name="ORDER_ID",nullable = false)
    private int orderId;

    @OneToOne
    @JoinColumn(name="USER_ID")
    private User customer;


    @OneToOne
    @JoinColumn(name="BUSINESS_ID")
    private Business business;


    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="ORDER_ID",referencedColumnName ="ORDER_ID" )
    private List<OrderItem> orderItemList=new ArrayList<>();


    @OneToOne
    @JoinColumn(name="STATUS_ID")
    private Status status;



    @Basic
    @Column(name="COMMENTS")
    private String comments;


    @Basic
    @Column(name="ACCEPT_TIME")
    private String acceptTime;

    @Basic
    @Column(name="FINISH_TIME")
    private String finishTime;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }
}
