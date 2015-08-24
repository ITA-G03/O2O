package ita.o2o.entity.base;

import ita.o2o.entity.extra.Tag;

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

    @ManyToOne
    @JoinColumn(name="BUSINESS_ID")
    private Business business;

    @ManyToOne
    @JoinColumn(name="TAG_ID")
    private Tag tag;


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

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
