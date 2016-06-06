package bishe.controllers;

import bishe.entity.PatientInfoEntity;
import bishe.repository.PatientInfoRepository;
import bishe.service.PatientInfoService;
import com.google.gson.Gson;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by sjh on 16/3/9.
 */
@RestController
@RequestMapping(value = "/patientinfo")
public class PatientController {
    @Autowired
    private PatientInfoRepository patientInfoRepository;
    @Autowired
    private PatientInfoService patientInfoService;
    Gson gson = new Gson();

    @RequestMapping(value = "getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<PatientInfoEntity> getPatientInfoAll() {
        return patientInfoService.getAllPatient();
//        try {
//
//            List<PatientInfoEntity> patientInfoEntities = (List<PatientInfoEntity>) patientInfoRepository.findAll();
//            for (PatientInfoEntity patientEntity : patientInfoEntities
//                    ) {
//                System.out.println(patientEntity.getPatientName());
//            }
//            return patientInfoEntities;
//        } catch (Exception e) {
//            return null;
//        }
    }

    @RequestMapping(value = "findbyname", params = "patientName", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<PatientInfoEntity> getPatientByNames(@RequestParam(value = "patientName", required = true) String patientName) {
        //if(patientInfoRepository.findByPatientName(patientName))
        try {
            return patientInfoRepository.findByPatientName(patientName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return patientInfoRepository.findByPatientName(patientName);
        }
    }

    @RequestMapping(value = "findbyid/{patientId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PatientInfoEntity getPatientById(@PathVariable Long patientId) {
        return patientInfoService.findByPatientId(patientId);

    }


    @RequestMapping(value = "saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a hotel resource.", notes = "Returns the URL of the new resource in the Location header.")
    @ResponseBody
    public String saveOrUpdatePatient(PatientInfoEntity patientInfoEntity, @RequestBody String requestBody) {
        try {
            if (requestBody.substring(0, 1).equals("[")) {
                System.out.println("Android input");
                PatientInfoEntity patientInfoEntity1 = gson.fromJson(requestBody.substring(1, requestBody.length() - 1), PatientInfoEntity.class);
                patientInfoService.saveOrUpdatePatient(patientInfoEntity1);
                System.out.println("A_ID--->"+patientInfoEntity1.getPatientId());
                System.out.println("A_Name--->"+patientInfoEntity1.getPatientName());
                return "Success";
            }
            patientInfoService.saveOrUpdatePatient(patientInfoEntity);
            System.out.println("ID--->"+patientInfoEntity.getPatientId());
            System.out.println("Name--->"+patientInfoEntity.getPatientName());
            return "Success";
        } catch (Exception e) {
            System.out.println("错误:" + e.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "deletebyid/{patientId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a hotel resource.", notes = "Returns the URL of the new resource in the Location header.")
    @ResponseBody
    public Long deletePatientInfo(@PathVariable Long patientId) {
        patientInfoService.deletePatient(patientId);
        return patientId;
    }
}
