package bishe.controllers;

import bishe.entity.PictureListEntity;
import bishe.repository.PictureListRepository;
import bishe.service.PictureListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/picturelist/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<PictureListEntity> getPictureListAll(){
        return pictureListService.getAllPicture();
    }

    @RequestMapping(value = "/picturelist/findbyname",params="pictureName", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PictureListEntity getPictureByone(@RequestParam(value = "pictureName", required = true) String pictureName){
        return pictureListRepository.findByPictureName(pictureName);
    }

    @RequestMapping(value = "/picturelist/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String saveOrUpdate(PictureListEntity pictureListEntity){
        try {
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
    public Long deletePictureList(@PathVariable Long pictureId){
        pictureListService.deletePicture(pictureId);
        return pictureId;
    }

}
