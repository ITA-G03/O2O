package ita.o2o.entity.extra;

import javax.persistence.*;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */
@Entity
@Table(name="STATUS")
public class Status {
    @Id
    @SequenceGenerator(sequenceName="SEQ_STATUS",name="statusSequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="statusSequence")
    @Column(name="STATUS_ID",nullable = false)
    private int statusId;


    @Basic
    @Column(name = "STATUS_NAME",nullable = false)
    private String statusName;


    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
