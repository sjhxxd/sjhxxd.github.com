package bishe.controllers;

import bishe.entity.LocationInfoEntity;
import bishe.service.LocationInfoService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sjh on 16/3/30.
 */
@RestController
public class LocationInfoController {
    @Autowired
    private LocationInfoService locationInfoService;

    @RequestMapping(value = "/locationinfo/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<LocationInfoEntity> getLocationInfoAll(){
        return locationInfoService.getAllLocation();
    }


    @RequestMapping(value = "/locationinfo/findbyid/{locationInfoId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody

    public LocationInfoEntity getLocationById(@PathVariable Long locationInfoId){
        return locationInfoService.fingByLocationInfoId(locationInfoId);
    }

    @RequestMapping(value = "/locationinfo/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String saveOrUpdateLocation(LocationInfoEntity locationInfoEntity){
        try {
            locationInfoService.saveOrUpdateLocation(locationInfoEntity);
            return "Success";
        } catch (Exception e) {
            System.out.println("错误:" + e.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/locationinfo/deletebyid/{locationInfoId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteLocation(@PathVariable Long locationInfoId){
        locationInfoService.deleteLocation(locationInfoId);
            return locationInfoId;

    }
}
