package ita.o2o.entity.base;

import javax.persistence.*;

/**
 * @author Jason Cui
 * @version 2015-08-24
 */
@Entity
@Table(name = "BUSINESS_TAG")
public class BusinessTag {

    @Id
    @SequenceGenerator(sequenceName="SEQ_BUSINESS_TAG",name="businessTagSequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="businessTagSequence")
    @Column(name="BUSINESS_TAG_ID",nullable = false)
    private int businessTagId;

    @Basic
    @Column(name="BUSINESS_TAG_NAME")
    private String businessTagName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BUSINESS_ID")
    private Business business;




    public int getBusinessTagId() {
        return businessTagId;
    }

    public void setBusinessTagId(int businessTagId) {
        this.businessTagId = businessTagId;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public String getBusinessTagName() {
        return businessTagName;
    }

    public void setBusinessTagName(String businessTagName) {
        this.businessTagName = businessTagName;
    }
}
