package ita.o2o.entity.base;

import javax.persistence.*;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */
@Entity
@Table(name="IMAGE")
public class Image {

    @Id
    @SequenceGenerator(sequenceName="SEQ_IMAGE",name="imageSequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="imageSequence")
    @Column(name="IMAGE_ID",nullable = false)
    private int imageId;


    @Lob
    @Basic
    @Column(name="IMAGE_BODY",columnDefinition = "BLOB")
    private byte[] imageBody;


    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public byte[] getImageBody() {
        return imageBody;
    }

    public void setImageBody(byte[] imageBody) {
        this.imageBody = imageBody;
    }
}
