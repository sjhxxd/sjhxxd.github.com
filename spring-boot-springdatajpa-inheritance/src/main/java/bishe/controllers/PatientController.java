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

    @RequestMapping(value = "/patientinfo/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single hotel.", notes = "You have to provide a valid hotel ID.")
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

    @RequestMapping(value = "/patientinfo/findbyname", params = "patientName",method= RequestMethod.GET, produces = {"application/json"})
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

    @RequestMapping(value = "/patientinfo/findbyid/{patientId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PatientInfoEntity getPatientById(@PathVariable Long patientId) {
        return patientInfoService.findByPatientId(patientId);

    }


    @RequestMapping(value = "/patientinfo/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
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
        try {
            System.out.println(patientInfoEntity.getPatientName());
            patientInfoService.saveOrUpdatePatient(patientInfoEntity);
            System.out.println("看看--->"+patientInfoEntity.getPatientName());
        } catch (Exception e) {
            System.out.println("添加错误:"+e.getMessage());
        }
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
