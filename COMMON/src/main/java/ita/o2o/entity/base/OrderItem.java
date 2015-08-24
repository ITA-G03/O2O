package ita.o2o.entity.base;

import javax.persistence.*;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */
@Entity
@Table(name="ORDER_ITEM")
public class OrderItem {

    @Id
    @SequenceGenerator(sequenceName="SEQ_ORDER_ITEM",name="orderItemSequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="orderItemSequence")
    @Column(name="ORDER_ITEM_ID",nullable = false)
    private int orderItemId;


    @OneToOne
    @JoinColumn(name="FOOD_ID",nullable = false)
    private Food food;


    @Basic
    @Column(name="PRICE_SNAPSHOT")
    private double priceSnapshot;//交易快照价格

    @ManyToOne
    @JoinColumn(name="ORDER_ID",nullable = false)
    private Order order;


    @Basic
    @Column(name="FOOD_COUNT")
    private int count;


    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public double getPriceSnapshot() {
        return priceSnapshot;
    }

    public void setPriceSnapshot(double priceSnapshot) {
        this.priceSnapshot = priceSnapshot;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
