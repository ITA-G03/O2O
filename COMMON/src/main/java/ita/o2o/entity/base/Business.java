package ita.o2o.entity.base;

import ita.o2o.entity.extra.Status;
import ita.o2o.entity.extra.Tag;
import ita.o2o.entity.location.Location;

import java.util.Set;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */
public class Business {
    private int businessId;
    private String realName;
    private Status status;
    private User owner;
    private Set<Tag> tags;
    private Location location;
    private int idCardId;
    private int licenseId;
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

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
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
