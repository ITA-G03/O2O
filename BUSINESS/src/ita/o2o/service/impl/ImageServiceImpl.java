package ita.o2o.service.impl;

import ita.o2o.dao.impl.ImageDaoImpl;
import ita.o2o.entity.base.Image;
import ita.o2o.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Aquariuslt
 * @version 2015-08-26
 */
@Service("imageService")
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageDaoImpl imageDao;

    @Override
    public Image getById(int id) {
        return imageDao.getById(id);
    }

    @Override
    @Transactional
    public int createImage(Image image) {
        System.out.println("Image Service~~Create Image~~Size:"+image.getImageBody().length);
        return imageDao.create(image);
    }
}
