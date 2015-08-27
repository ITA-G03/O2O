package ita.o2o.controller.action;

import ita.o2o.constants.O2OConstants;
import ita.o2o.controller.BaseController;
import ita.o2o.entity.base.Image;
import ita.o2o.service.impl.ImageServiceImpl;
import ita.o2o.util.bean.ResponseMessage;
import ita.o2o.util.mapper.JSONMapper;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jason Cui
 * @version 2015-08-27
 */
@Controller
@RequestMapping("/action/image")
public class ImageUploadActionController extends BaseController{


    @Autowired
    ImageServiceImpl imageService;

    @Autowired
    JSONMapper jsonMapper;


    DiskFileItemFactory diskFileItemFactory;
    ServletFileUpload servletFileUpload;

    public ImageUploadActionController() {
        diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setSizeThreshold(1000 * 1024);
        servletFileUpload = new ServletFileUpload(diskFileItemFactory);
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String imageUploadAction(HttpServletRequest request)  {
        try{
            System.out.println("Uploading Image!");
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile imageFile = multipartRequest.getFileMap().values().iterator().next();
            Image image = new Image();
            image.setImageBody(imageFile.getBytes());
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
