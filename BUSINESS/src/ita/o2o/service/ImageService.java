package ita.o2o.service;

import ita.o2o.entity.base.Image;
import org.springframework.stereotype.Service;

/**
 * @author Aquariuslt
 * @version 2015-08-26
 */
public interface ImageService {

    Image getById(int id);

    int createImage(Image image);
}
