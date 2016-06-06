package bishe.controllers;

import bishe.entity.CommonDiseaseInfoEntity;
import bishe.repository.CommonDiseaseInfoRepository;
import bishe.service.CommonDiseaseInfoService;
import bishe.service.CommonDiseaseTypeService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
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
    @Autowired
    private CommonDiseaseTypeService commonDiseaseTypeService;

    List<CommonDiseaseInfoEntity> commonDiseaseInfoEntities;

    @RequestMapping(value = "/commondiseaseinfo/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<HashMap<String, String>> getCommonDiseaseInfoAll() {
        commonDiseaseInfoEntities = commonDiseaseInfoService.getAllCommonDiseaseInfo();
        final List<HashMap<String, String>> commonNameMap = new ArrayList<>();
        for (final CommonDiseaseInfoEntity commonDiseaseInfoEntity : commonDiseaseInfoEntities) {
            commonNameMap.add(new HashMap<String, String>() {{
                put("commonDiseaseId",commonDiseaseInfoEntity.getCommonDiseaseId().toString());
                put("tempCommonDiseaseTypeId",commonDiseaseTypeService.findByCommonDiseaseTypeId(commonDiseaseInfoEntity.getTempCommonDiseaseTypeId()).getCommonDiseaseTypeName());
                put("commonDiseaseName",commonDiseaseInfoEntity.getCommonDiseaseName());
                put("commonDiseaseCode",commonDiseaseInfoEntity.getCommonDiseaseCode());
                put("commonDiseaseExplain",commonDiseaseInfoEntity.getCommonDiseaseExplain());
                put("patientNumber",commonDiseaseInfoEntity.getPatientNumber());
            }});
        }
        return commonNameMap;
    }


    @RequestMapping(value = "/commondiseaseinfo/findbyname", params = "commonDiseaseName", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CommonDiseaseInfoEntity getCommonDiseaseInfoByName(@RequestParam(value = "commonDiseaseName", required = true) String commonDiseaseName) {
        return commonDiseaseInfoRepository.findByCommonDiseaseName(commonDiseaseName);
    }

    @RequestMapping(value = "/commondiseaseinfo/findbyid/{commonDiseaseId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CommonDiseaseInfoEntity getCommonDiseaseInfoById(@PathVariable Long commonDiseaseId) {
        return commonDiseaseInfoService.findByCommonDiseaseId(commonDiseaseId);
    }

    @RequestMapping(value = "/commondiseaseinfo/findbytypeid/{tempCommonDiseaseTypeId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CommonDiseaseInfoEntity> getCommonDiseaseInfoByCommonDiseaseTypeId(@PathVariable Long tempCommonDiseaseTypeId) {
        return commonDiseaseInfoRepository.findByTempCommonDiseaseTypeId(tempCommonDiseaseTypeId);
    }

    @RequestMapping(value = "/commondiseaseinfo/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String saveOrUpdateCommonDiseaseInfo(CommonDiseaseInfoEntity commonDiseaseInfoEntity) {
        try {
            commonDiseaseInfoService.saveOrUpdateCommonDiseaseInfo(commonDiseaseInfoEntity);
            return "Success";
        } catch (Exception e) {
            System.out.println("错误:" + e.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/commondiseaseinfo/deletebyid/{commonDiseaseId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteCommonDisease(@PathVariable Long commonDiseaseId) {
        commonDiseaseInfoService.deleteCommonDiseaseInfo(commonDiseaseId);
        return commonDiseaseId;
    }


}
