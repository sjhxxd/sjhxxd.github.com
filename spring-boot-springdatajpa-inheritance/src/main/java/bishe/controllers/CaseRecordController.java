package bishe.controllers;

import bishe.entity.CaseRecordEntity;
import bishe.repository.CaseRecordRepository;
import bishe.service.CaseRecordService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sjh on 16/3/29.
 */
@RestController
public class CaseRecordController {
    @Autowired
    private CaseRecordRepository caseRecordRepository;
    @Autowired
    private CaseRecordService caseRecordService;

    @RequestMapping(value = "/caserecord/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CaseRecordEntity> getCaseRecordAll(){
        return caseRecordService.getAllCaseRecord();
    }

//    通过病人Id查找还是病人名字?
    @RequestMapping(value = "/caserecord/findbytemppatientid/{tempPatientId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CaseRecordEntity> getCaseRecordByTempPatientId(@PathVariable Long tempPatientId){
        return caseRecordRepository.findByTempPatientId(tempPatientId);
    }

    @RequestMapping(value = "/caserecord/findbytempdiseaseid/{tempDiseaseId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CaseRecordEntity> getCaseRecordByTempDiseaseId(@PathVariable Long tempDiseaseId){
        return caseRecordRepository.findByTempDiseaseId(tempDiseaseId);
    }

    @RequestMapping(value = "/caserecord/findbytempSyndromeId/{tempSyndromeId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CaseRecordEntity> getCaseRecordByTempSyndromeId(@PathVariable Long tempSyndromeId){
        return caseRecordRepository.findByTempSyndromeId(tempSyndromeId);
    }


    @RequestMapping(value = "/caserecord/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void saveOrUpdateCaseRecord(CaseRecordEntity caseRecordEntity){
        caseRecordService.saveOrUpdateCaseRecord(caseRecordEntity);
    }

    @RequestMapping(value = "/caserecord/deletebyid/{caseId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteCaseRecord(@PathVariable Long caseId){
        caseRecordService.deleteCaseRecord(caseId);
        return caseId;
    }


}
