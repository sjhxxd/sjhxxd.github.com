package bishe.controllers;

import bishe.entity.CommonDiseaseInfoEntity;
import bishe.repository.CommonDiseaseInfoRepository;
import bishe.service.CommonDiseaseInfoService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sjh on 16/4/5.
 */
@RestController
public class CommonDiseaseInfoController {
    @Autowired
    private CommonDiseaseInfoRepository commonDiseaseInfoRepository;
    @Autowired
    private CommonDiseaseInfoService commonDiseaseInfoService;

    @RequestMapping(value = "/commondiseaseinfo/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CommonDiseaseInfoEntity> getCommonDiseaseInfoAll(){
        return commonDiseaseInfoService.getAllCommonDiseaseInfo();
    }


    @RequestMapping(value = "/commondiseaseinfo/findbyname",params="commonDiseaseName", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CommonDiseaseInfoEntity getCommonDiseaseInfoByName(@RequestParam(value = "commonDiseaseName", required = true) String commonDiseaseName){
        return commonDiseaseInfoRepository.findByCommonDiseaseName(commonDiseaseName);
    }

    @RequestMapping(value = "/commondiseaseinfo/findbyname/{commonDiseaseId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CommonDiseaseInfoEntity getCommonDiseaseInfoById(@PathVariable Long commonDiseaseId){
        return commonDiseaseInfoService.findByCommonDiseaseId(commonDiseaseId);
    }

    @RequestMapping(value = "/commondiseaseinfo/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void saveOrUpdateCommonDiseaseInfo(CommonDiseaseInfoEntity commonDiseaseInfoEntity){
        commonDiseaseInfoService.saveOrUpdateCommonDiseaseInfo(commonDiseaseInfoEntity);
    }

    @RequestMapping(value = "/commondiseaseinfo/deletebyid/{commonDiseaseId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteCommonDisease(@PathVariable Long commonDiseaseId){
        commonDiseaseInfoService.deleteCommonDiseaseInfo(commonDiseaseId);
        return commonDiseaseId;
    }




}
