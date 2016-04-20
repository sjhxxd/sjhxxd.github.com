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

    @RequestMapping(value = "/picturelist/findbyname/{pictureName}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PictureListEntity getPictureByone(@PathVariable String pictureName){
        return pictureListRepository.findByPictureName(pictureName);
    }

    @RequestMapping(value = "/picturelist/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void saveOrUpdate(PictureListEntity pictureListEntity){
        pictureListService.saveOrUpdatePicture(pictureListEntity);
    }

    @RequestMapping(value = "/picturelist/deletebyid/{pictureId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deletePictureList(@PathVariable Long pictureId){
        pictureListService.deletePicture(pictureId);
        return pictureId;
    }

}
