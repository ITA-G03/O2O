package ita.o2o.entity.extra;

import javax.persistence.*;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */

@Entity
@Table(name = "FOOD_TYPE")
public class FoodType {

    @Id
    @SequenceGenerator(sequenceName="SEQ_FOOD_TYPE",name="foodTypeSequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="foodTypeSequence")
    @Column(name="FOOD_TYPE_ID",nullable = false)
    private int foodTypeId;


    @Basic
    @Column(name="FOOD_TYPE_NAME",nullable = false)
    private String foodTypeName;

    public int getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodTypeId(int foodTypeId) {
        this.foodTypeId = foodTypeId;
    }

    public String getFoodTypeName() {
        return foodTypeName;
    }

    public void setFoodTypeName(String foodTypeName) {
        this.foodTypeName = foodTypeName;
    }
}
