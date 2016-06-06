package bishe.controllers;

import bishe.entity.ChineseMedicineInfoEntity;
import bishe.repository.ChineseMedicineInfoRepository;
import bishe.service.ChineseMedicineInfoService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by sjh on 16/3/23.
 */
@RestController
@RequestMapping(value="/chinesemedicineinfo")
public class ChineseMedicineController {
    @Autowired
    private ChineseMedicineInfoRepository chineseMedicineInfoRepository;

    @Autowired
    private ChineseMedicineInfoService chineseMedicineInfoService;


    @RequestMapping(value = "getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<ChineseMedicineInfoEntity> getChineseMedicineAll() {
        return chineseMedicineInfoService.getAllChineseMedicine();
    }

    @RequestMapping(value = "findbyid/{chineseMedicineId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ChineseMedicineInfoEntity getChineseMedicineById(@PathVariable Long chineseMedicineId){
        return chineseMedicineInfoService.findByChineseMedicineId(chineseMedicineId);
    }

    @RequestMapping(value = "findbyname",params="medicineName", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<ChineseMedicineInfoEntity> getChineseMedicineByOne(@RequestParam(value = "medicineName", required = true) String medicineName) {
            return chineseMedicineInfoRepository.findByMedicineName(medicineName);
    }

    @RequestMapping(value = "findbymedicineproperty",params="medicineProperty", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<ChineseMedicineInfoEntity> getChineseMedicineByMedicineProperty(@RequestParam(value = "medicineProperty", required = true) String medicineProperty) {
        return chineseMedicineInfoRepository.findByMedicineProperty(medicineProperty);
    }

    @RequestMapping(value = "findbymedicinetaste",params="medicineTaste", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<ChineseMedicineInfoEntity> getChineseMedicineByMedicineTaste(@RequestParam(value = "medicineTaste", required = true) String medicineTaste) {
        return chineseMedicineInfoRepository.findByMedicineTaste(medicineTaste);
    }

    @RequestMapping(value = "findbyeffecttype",params="effectType", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<ChineseMedicineInfoEntity> getChineseMedicineByEffectType(@RequestParam(value = "effectType", required = true) String effectType) {
        return chineseMedicineInfoRepository.findByEffectType(effectType);
    }

    @RequestMapping(value = "findbymedicinegrade",params="medicineGrade", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<ChineseMedicineInfoEntity> getChineseMedicineByMedicineGrade(@RequestParam(value = "medicineGrade", required = true) String medicineGrade) {
        return chineseMedicineInfoRepository.findByMedicineGrade(medicineGrade);
    }



    @RequestMapping(value = "saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a hotel resource.", notes = "Returns the URL of the new resource in the Location header.")
    @ResponseBody
    public String saveOrUpdateChineseMedicine(ChineseMedicineInfoEntity chineseMedicineInfoEntity) {
        try {
            chineseMedicineInfoService.saveOrUpdateChineseMedicine(chineseMedicineInfoEntity);
            return "Success";
        } catch (Exception e) {
            System.out.println("错误:" + e.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "deletebyid/{chineseMedicineId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Get a single hotel.", notes = "You have to provide a valid hotel ID.")
    @ResponseBody
    public Long deleteChineseMedicineInfo(@PathVariable Long chineseMedicineId) {
        chineseMedicineInfoService.deleteChineseMedicine(chineseMedicineId);
        return chineseMedicineId;
    }
}
