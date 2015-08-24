package ita.o2o.entity.extra;

import javax.persistence.*;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */
@Entity
@Table(name="WORK_STATUS")
public class WorkStatus {
    @Id
    @SequenceGenerator(sequenceName="SEQ_CITY",name="workStatusSequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="workStatusSequence")
    @Column(name="WORK_STATUS_ID",nullable = false)
    private int workStatusId;

    @Basic
    @Column(name="WORK_STATUS_NAME",nullable = false)
    private String workStatusName;

    public int getWorkStatusId() {
        return workStatusId;
    }

    public void setWorkStatusId(int workStatusId) {
        this.workStatusId = workStatusId;
    }

    public String getWorkStatusName() {
        return workStatusName;
    }

    public void setWorkStatusName(String workStatusName) {
        this.workStatusName = workStatusName;
    }
}
