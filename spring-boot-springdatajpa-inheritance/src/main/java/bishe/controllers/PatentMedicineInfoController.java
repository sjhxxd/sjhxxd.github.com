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

    @RequestMapping(value = "/patentmedicineinfo/findbyname",params="patentmedicineName", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PatentMedicineInfoEntity getPatentMedicineByOne(@RequestParam(value = "patentmedicineName", required = true) String patentmedicineName) {
        return patentMedicineInfoRepository.findByPatentMedicineName(patentmedicineName);
    }


    @RequestMapping(value = "/patentmedicineinfo/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String saveOrUpdatePatentMedicine(PatentMedicineInfoEntity patentMedicineInfoEntity) {
        try {
            patentMedicineInfoService.saveOrUpdatePatentMedicine(patentMedicineInfoEntity);
            return "Success";
        } catch (Exception e) {
            System.out.println("错误:" + e.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/patentmedicineinfo/deletebyid/{patentMedicineId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody

    public Long deletePatentMedicine(@PathVariable Long patentMedicineId){
        patentMedicineInfoService.deletePatentMedicine(patentMedicineId);
        return patentMedicineId;
    }
}
