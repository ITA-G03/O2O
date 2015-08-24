package ita.o2o.entity.base;

import ita.o2o.entity.extra.Status;
import ita.o2o.entity.extra.Tag;
import ita.o2o.entity.extra.WorkStatus;
import ita.o2o.entity.location.Location;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */
@Entity
@Table(name="BUSINESS")
public class Business {

    @Id
    @SequenceGenerator(sequenceName="SEQ_BUSINESS",name="businessSequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="businessSequence")
    @Column(name="BUSINESS_ID",nullable = false)
    private int businessId;

    @Basic
    @Column(name="REALNAME")
    private String realName;

    @OneToOne
    @JoinColumn(name = "STATUS_ID")
    private Status status;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User owner;

    @OneToMany
    private Set<BusinessTag> businessTags;

    @OneToOne
    @JoinColumn(name="WORK_STATUS_ID")
    private WorkStatus workStatus;


    @OneToOne
    @JoinColumn(name = "LOCATION_ID")
    private Location location;

    @Basic
    @Column(name="IDCARD_ID")
    private int idCardId;

    @Basic
    @Column(name = "LICENSE_ID")
    private int licenseId;

    @Basic
    @Column(name = "LOGO_ID")
    private int logoId;

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<BusinessTag> getBusinessTags() {
        return businessTags;
    }

    public void setBusinessTags(Set<BusinessTag> businessTags) {
        this.businessTags = businessTags;
    }

    public WorkStatus getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(WorkStatus workStatus) {
        this.workStatus = workStatus;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getIdCardId() {
        return idCardId;
    }

    public void setIdCardId(int idCardId) {
        this.idCardId = idCardId;
    }

    public int getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(int licenseId) {
        this.licenseId = licenseId;
    }

    public int getLogoId() {
        return logoId;
    }

    public void setLogoId(int logoId) {
        this.logoId = logoId;
    }
}
