package bishe.controllers;

import bishe.entity.PatentMedicineInfoEntity;
import bishe.repository.PatentMedicineInfoRepository;
import bishe.service.PatentMedicineInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sjh on 16/3/26.
 */
@RestController
public class PatentMedicineInfoController {
    @Autowired
    private PatentMedicineInfoRepository patentMedicineInfoRepository;
    @Autowired
    private PatentMedicineInfoService patentMedicineInfoService;

    @RequestMapping(value = "/patentmedicineinfo/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<PatentMedicineInfoEntity> getPatentMedicineInfoAll() {
        return patentMedicineInfoService.getAllPatentMedicine();
    }

    @RequestMapping(value = "/patentmedicineinfo/findbyname/{patentmedicinename}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PatentMedicineInfoEntity getPatentMedicineByOne(@PathVariable String patentmedicinename) {
        return patentMedicineInfoRepository.findByPatentMedicineName(patentmedicinename);
    }


    @RequestMapping(value = "/patentmedicineinfo/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void saveOrUpdatePatentMedicine(PatentMedicineInfoEntity patentMedicineInfoEntity) {
        patentMedicineInfoService.saveOrUpdatePatentMedicine(patentMedicineInfoEntity);
    }

    @RequestMapping(value = "/patentmedicineinfo/deletebyid/{patentMedicineId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody

    public Long deletePatentMedicine(@PathVariable Long patentMedicineId){
        patentMedicineInfoService.deletePatentMedicine(patentMedicineId);
        return patentMedicineId;
    }
}
