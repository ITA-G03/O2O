package ita.o2o.controller.view;

import ita.o2o.constants.O2OConstants;
import ita.o2o.controller.BaseController;
import ita.o2o.entity.base.Image;
import ita.o2o.service.impl.ImageServiceImpl;
import ita.o2o.util.bean.ResponseMessage;
import ita.o2o.util.mapper.JSONMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.rmi.server.ExportException;
import java.util.List;

/**
 * @author Aquariuslt
 * @version 2015-08-26
 */
@Controller
@RequestMapping("/image")
public class ImageUploadViewController extends BaseController {


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
        Image image = imageService.getById(Integer.valueOf(imageId));
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(image.getImageBody());
        outputStream.flush();
        outputStream.close();
    }


    //处理图片上传
    @RequestMapping("/upload")
    @ResponseBody
    public String imageUploadAction(HttpServletRequest request)  {
        try{
            System.out.println("Uploading Image!");
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile imageFile = multipartRequest.getFileMap().values().iterator().next();
            Image image = new Image();
            image.setImageBody(imageFile.getBytes());
            System.out.println("卧槽 这个图片有" + imageFile.getSize() + "这么大");
            int newImageId = imageService.createImage(image);

            System.out.println("Upload complete,result:" + newImageId);
            ResponseMessage message = new ResponseMessage();
            if (newImageId != O2OConstants.DEFAULT_FAILURE_CODE) {
                message.setStatus(O2OConstants.SUCCESS);
                message.getBody().put("imageId", String.valueOf(newImageId));
            } else {
                message.setStatus(O2OConstants.FAILURE);
            }
            System.out.println("Return Message:" + jsonMapper.writeObjectAsString(message));
            return jsonMapper.writeObjectAsString(message);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return O2OConstants.EMPTY;
    }


}
