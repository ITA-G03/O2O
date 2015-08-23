package ita.o2o.entity.base;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */
public class OrderItem {
    private int orderItemId;
    private Food food;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
