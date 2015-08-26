package ita.o2o.dao.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.entity.base.Image;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Aquariuslt
 * @version 2015-08-26
 */
@Repository("imageDao")
public class ImageDaoImpl extends BaseDaoImpl<Image>{


    public ImageDaoImpl() {
        super(Image.class);
    }

    @Override
    public List<Image> getAll() {
        return null;
    }

    @Override
    public int create(Image image) {
        try{
            this.getManager().persist(image);
            return image.getImageId();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return O2OConstants.DEFAULT_FAILURE_CODE;
    }
}
