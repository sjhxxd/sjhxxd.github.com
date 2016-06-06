package bishe.controllers;

import bishe.entity.PictureListEntity;
import bishe.repository.PictureListRepository;
import bishe.service.PictureListService;
import bishe.utils.FilePathSet;
import bishe.utils.FileUploadOrDownload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

/**
 * Created by sjh on 16/4/20.
 */
@RestController
public class PictureListController {
    @Autowired
    private PictureListRepository pictureListRepository;
    @Autowired
    private PictureListService pictureListService;
    @Autowired
    private Environment env;

    @RequestMapping(value = "/picturelist/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<PictureListEntity> getPictureListAll() {
        return pictureListService.getAllPicture();
    }

    @RequestMapping(value = "/picturelist/findbyname", params = "pictureName", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PictureListEntity getPictureByone(@RequestParam(value = "pictureName", required = true) String pictureName) {
        return pictureListRepository.findByPictureName(pictureName);
    }

    @RequestMapping(value = "/picturelist/findbyname", params = "pictureClass", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<PictureListEntity> getPictureByPictureClass(@RequestParam(value = "pictureClass", required = true) String pictureClass) {
        return pictureListRepository.findByPictureClass(pictureClass);
    }

    @RequestMapping(value = "/picturelist/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String saveOrUpdate(PictureListEntity pictureListEntity,
                               HttpServletRequest request,
                               @PathVariable Long pictureLocationId) {
        String picturename = ((MultipartFile) (((MultipartHttpServletRequest) request)
                .getFile("uploadpicture"))).getOriginalFilename();
        try {
            String folderName = "tupian";
            if (picturename != null) {
                pictureListEntity.setPictureName(picturename);
                pictureListEntity.setOriginalPicturePath(env
                        .getProperty("yian.paths.downloadedPictures")
                        + folderName + "/" + picturename.toString());
                FileUploadOrDownload
                        .fileUpload(
                                (MultipartFile) (((MultipartHttpServletRequest) request)
                                        .getFile("uploadpicture")), env,
                                picturename,
                                FilePathSet.pictureabsolutePath,
                                folderName);

            }
            PictureListEntity oldPictureEntity = pictureListRepository.findOne(pictureLocationId);
            pictureListEntity.setPictureLocationId(pictureLocationId);
            pictureListEntity.setFolderName(oldPictureEntity.getFolderName());
            System.out.println("图片名--->" + picturename);

            if (!picturename.equals("")) {
                FileUploadOrDownload
                        .deleteFile(env, picturename,
                                FilePathSet.pictureabsolutePath, oldPictureEntity.getFolderName());
                pictureListEntity.setPictureName(picturename);
                pictureListEntity.setOriginalPicturePath(env
                        .getProperty("yian.paths.downloadedPictures")
                        + oldPictureEntity.getFolderName()
                        + "/"
                        + picturename);
            }
            if (picturename.equals("")) {
                pictureListEntity.setPictureName(oldPictureEntity.getPictureName());
                pictureListEntity.setOriginalPicturePath(env
                        .getProperty("yian.paths.downloadedPictures")
                        +oldPictureEntity.getFolderName()
                        + "/"
                        +oldPictureEntity.getPictureName());
            }
            pictureListService.saveOrUpdatePicture(pictureListEntity);
            return "Success";
        } catch (Exception e) {
            System.out.println("错误:" + e.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/picturelist/deletebyid/{pictureId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deletePictureList(@PathVariable Long pictureId) {
        pictureListService.deletePicture(pictureId);
        return pictureId;
    }

}
