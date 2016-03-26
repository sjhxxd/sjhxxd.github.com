package bishe.controllers;

import bishe.entity.PatientInfoEntity;
import bishe.repository.PatientInfoRepository;
import bishe.service.PatientInfoService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sjh on 16/3/9.
 */
@RestController
public class PatientController {
    @Autowired
    private PatientInfoRepository patientInfoRepository;
    @Autowired
    private PatientInfoService patientInfoService;

    @RequestMapping(value = "/patientinfo/getbyname", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single hotel.", notes = "You have to provide a valid hotel ID.")
    @ResponseBody
    public List<PatientInfoEntity> getPatientInfoByName() {
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

    @RequestMapping(value = "/patientinfo/findbyname/{patientname}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single hotel.", notes = "You have to provide a valid hotel ID.")
    @ResponseBody
    public PatientInfoEntity getPatientByOne(@PathVariable String patientname) {
        System.out.println(patientInfoRepository.findByPatientName(patientname).getPatientName());
        return patientInfoRepository.findByPatientName(patientname);
    }

    @RequestMapping(value = "/patientinfo/findbyid/{patientId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PatientInfoEntity getPatientById(@PathVariable Long patientId){
        return patientInfoService.findByPatientId(patientId);

    }


    @RequestMapping(value = "/patientinfo/saveorupdate", method = {RequestMethod.POST, RequestMethod.GET}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a hotel resource.", notes = "Returns the URL of the new resource in the Location header.")
    @ResponseBody
    public void saveOrUpdatePatient(PatientInfoEntity patientInfoEntity) {
//        try {
//            System.out.println(patientInfoEntity.getPatientId());
//            patientInfoRepository.save(patientInfoEntity);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//
//        }
         patientInfoService.saveOrUpdatePatient(patientInfoEntity);

    }

    @RequestMapping(value = "/patientinfo/deletebyid/{patientId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a hotel resource.", notes = "Returns the URL of the new resource in the Location header.")
    @ResponseBody
    public Long deletePatientInfo(@PathVariable Long patientId) {
        patientInfoService.deletePatient(patientId);
        return patientId;
    }
}
