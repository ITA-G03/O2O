package ita.o2o.entity.extra;

import ita.o2o.entity.base.BusinessTag;

import javax.persistence.*;
import java.util.List;

/**
 * 被废弃的Tag 好垃圾啊 设计错误啦 对不齐
 * @author Aquariuslt
 * @version 15-08-22
 */
@Entity
@Table(name="TAG")
public class Tag {

    @Id
    @SequenceGenerator(sequenceName="SEQ_TAG",name="tagSequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tagSequence")
    @Column(name="TAG_ID",nullable = false)
    private int tagId;

    @Basic
    @Column(name="TAG_NAME")
    private String tagName;

    @OneToMany
    private List<BusinessTag> businessTags;


    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<BusinessTag> getBusinessTags() {
        return businessTags;
    }

    public void setBusinessTags(List<BusinessTag> businessTags) {
        this.businessTags = businessTags;
    }
}
