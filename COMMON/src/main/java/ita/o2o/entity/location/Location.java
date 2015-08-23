package ita.o2o.entity.location;

import javax.persistence.Entity;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */

public class Location {
    private int locationId;
    private City city;
    private Area area;
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
