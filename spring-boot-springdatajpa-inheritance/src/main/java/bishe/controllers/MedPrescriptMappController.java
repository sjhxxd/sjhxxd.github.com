package bishe.controllers;

import bishe.entity.MedPrescriptMappEntity;
import bishe.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sjh on 16/3/29.
 */
@RestController
public class MedPrescriptMappController {
    @Autowired
    private MedPrescriptMappService medPrescriptMappService;
    @Autowired
    private ChineseMedicineInfoService chineseMedicineInfoService;
    @Autowired
    private PrescriptionsInfoService prescriptionsInfoService;
    @Autowired
    private MeasurementUnitService measurementUnitService;

    @RequestMapping(value = "/medprescriptmapp/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<HashMap<String,String>> getMedPrescriptMappAll(){
        List<MedPrescriptMappEntity> medPrescriptMappEntities;
        medPrescriptMappEntities= medPrescriptMappService.getAllMedPrescriptMapp();
        final List<HashMap<String,String>> medPrescriptMap=new ArrayList<>();
        for(final MedPrescriptMappEntity medPrescriptMappEntity:medPrescriptMappEntities){
            medPrescriptMap.add(new HashMap<String, String>(){{
                put("chineseMedPrescriptMappId",medPrescriptMappEntity.getChineseMedPrescriptMappId().toString());
                put("tempChineseMedicineId",chineseMedicineInfoService.findByChineseMedicineId(medPrescriptMappEntity.getTempChineseMedicineId()).getMedicineName());
                put("tempPrescriptionId",prescriptionsInfoService.findByPrescriptionId(medPrescriptMappEntity.getTempPrescriptionId()).getPrescriptionName());
                put("medicineAmount",medPrescriptMappEntity.getMedicineAmount());
                put("tempUnitId",measurementUnitService.findByUnitId(medPrescriptMappEntity.getTempUnitId()).getUnitName());
                put("decoctionMethod",medPrescriptMappEntity.getDecoctionMethod());
                put("medPrescriptMappRemarks",medPrescriptMappEntity.getMedPrescriptMappRemarks());
            }});
        }
        return medPrescriptMap;
    }

    @RequestMapping(value = "/medprescriptmapp/findbyid/{chineseMedPrescriptMappId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public MedPrescriptMappEntity getMedPrescriptMappById(@PathVariable Long chineseMedPrescriptMappId){
        return medPrescriptMappService.fingByChineseMedPrescriptMappId(chineseMedPrescriptMappId);

    }

    @RequestMapping(value = "/medprescriptmapp/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String saveorUpdateMedPrescriptMapp(MedPrescriptMappEntity medPrescriptMappEntity){
        try {
            medPrescriptMappService.saveOrUpdateMedPrescriptMapp(medPrescriptMappEntity);
            return "Success";
        } catch (Exception e) {
            System.out.println("错误:" + e.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/medprescriptmapp/deletebyid/{chineseMedPrescriptMappId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteMedPrescriptMapp(@PathVariable Long chineseMedPrescriptMappId){
        medPrescriptMappService.deleteMedPrescriptMapp(chineseMedPrescriptMappId);
        return chineseMedPrescriptMappId;
    }
}
