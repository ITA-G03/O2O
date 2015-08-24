package ita.o2o.entity.location;

import javax.persistence.*;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */

@Entity
@Table(name="CITY")
public class City {
    @Id
    @SequenceGenerator(sequenceName="SEQ_CITY",name="citySequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="citySequence")
    @Column(name="CITY_ID",nullable = false)
    private int cityId;

    @Basic
    @Column(name="CITY_NAME",nullable = false)
    private String cityName;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
