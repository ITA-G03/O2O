package ita.o2o.entity.extra;

import javax.persistence.*;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */
@Entity
@Table(name="TAG")
public class Tag {

    @Id
    @SequenceGenerator(sequenceName="SEQ_TAG",name="tagSequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tagSequence")
    @Column(name="CITY_ID",nullable = false)
    private int tagId;

    @Basic
    @Column(name="")
    private String tagName;

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
}
