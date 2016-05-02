package bishe.controllers;

import bishe.entity.CommonDiseaseTypeEntity;
import bishe.repository.CommonDiseaseTypeRepository;
import bishe.service.CommonDiseaseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sjh on 16/4/5.
 */
@RestController
public class CommonDiseaseTypeController {
    @Autowired
    private CommonDiseaseTypeRepository commonDiseaseTypeRepository;
    @Autowired
    private CommonDiseaseTypeService commonDiseaseTypeService;


    @RequestMapping(value = "/commondiseasetype/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CommonDiseaseTypeEntity> getCommonDiseaseTypeAll(){
        return commonDiseaseTypeService.getAllCommonDiseaseType();
    }

    @RequestMapping(value = "/commondiseasetype/findbyname",params="commonDiseaseTypeName", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CommonDiseaseTypeEntity getCommonDiseaseTypeByName(@RequestParam(value = "commonDiseaseTypeName", required = true) String commonDiseaseTypeName){
        return commonDiseaseTypeRepository.findByCommonDiseaseTypeName(commonDiseaseTypeName);
    }

    @RequestMapping(value = "/commondiseasetype/findbyname/{commonDiseaseTypeid}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CommonDiseaseTypeEntity getCommonDiseaseTypeById(@PathVariable Long commonDiseaseTypeid){
        return commonDiseaseTypeService.findByCommonDiseaseTypeId(commonDiseaseTypeid);
    }

    @RequestMapping(value = "/commondiseasetype/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void saveOrUpdateCommonDiseaseType(CommonDiseaseTypeEntity commonDiseaseTypeEntity){
        commonDiseaseTypeService.saveOrUpdateCommonDiseaseType(commonDiseaseTypeEntity);
    }

    @RequestMapping(value = "/commondiseasetype/deletebyid/{commonDiseaseTypeid}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteCommonDiseaseType(@PathVariable Long commonDiseaseTypeid){
        commonDiseaseTypeService.deleteCommonDiseaseType(commonDiseaseTypeid);
        return commonDiseaseTypeid;
    }



}
