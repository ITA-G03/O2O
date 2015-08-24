package ita.o2o.entity.location;

import javax.persistence.*;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */
@Entity
@Table(name="AREA")
public class Area {

    @Id
    @SequenceGenerator(sequenceName="SEQ_AREA",name="areaSequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="areaSequence")
    @Column(name="AREA_ID",nullable = false)
    private int areaId;

    @Basic
    @Column(name="AREA_NAME",nullable = false)
    private String areaName;

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
