package ita.o2o.entity.location;

import javax.persistence.*;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */
@Entity
@Table(name="LOCATION")
public class Location {

    @Id
    @SequenceGenerator(sequenceName="SEQ_LOCATION",name="locationSequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="locationSequence")
    @Column(name="LOCATION_ID",nullable = false)
    private int locationId;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="CITY_ID")
    private City city;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="AREA_ID")
    private Area area;


    @Basic
    @Column(name="DETAIL",nullable = false)
    private String detail;


    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
