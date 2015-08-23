package ita.o2o.entity.base;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */
public class Image {
    private int imageId;
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
