package ita.o2o.controller.view;

import ita.o2o.controller.BaseController;
import ita.o2o.entity.base.Image;
import ita.o2o.service.impl.ImageServiceImpl;
import ita.o2o.util.mapper.JSONMapper;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Aquariuslt
 * @version 2015-08-26
 */
@Controller
@RequestMapping("/image")
public class ImageUploadViewController extends BaseController {
    public static final int DEFAULT_IMAGE_ID = 301;

    @Autowired
    ImageServiceImpl imageService;

    @Autowired
    JSONMapper jsonMapper;


    DiskFileItemFactory diskFileItemFactory;
    ServletFileUpload servletFileUpload;

    public ImageUploadViewController() {
        diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setSizeThreshold(1000 * 1024);
        servletFileUpload = new ServletFileUpload(diskFileItemFactory);
    }

    @RequestMapping("/test")
    public String imageUploadTestView() {
        return "image-upload-test";
    }

    @RequestMapping("/view/{imageId}")
    public void printImage(HttpServletResponse response, @PathVariable("imageId") String imageId) throws IOException {
        Image image;
        image = imageService.getById(Integer.valueOf(imageId));
        if (image == null) image = imageService.getById(DEFAULT_IMAGE_ID);
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(image.getImageBody());
        outputStream.flush();
        outputStream.close();
    }


}
