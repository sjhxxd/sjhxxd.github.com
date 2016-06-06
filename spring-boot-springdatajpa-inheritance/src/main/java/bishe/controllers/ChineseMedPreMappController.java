package bishe.controllers;

import bishe.entity.ChineseMedPreMappEntity;
import bishe.service.ChineseMedPreMappService;
import bishe.service.ChineseMedicineInfoService;
import bishe.service.DoctorPrescriptionService;
import bishe.service.MeasurementUnitService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sjh on 16/3/30.
 */
@RestController
public class ChineseMedPreMappController {
    @Autowired
    private ChineseMedPreMappService chineseMedPreMappService;
    @Autowired
    private ChineseMedicineInfoService chineseMedicineInfoService;
    @Autowired
    private DoctorPrescriptionService doctorPrescriptionService;
    @Autowired
    private MeasurementUnitService measurementUnitService;


    @RequestMapping(value = "/chinesemedpremapp/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<HashMap<String, String>> getChineseMedPreMappAll() {
        List<ChineseMedPreMappEntity> chineseMedPreMappEntities;
        chineseMedPreMappEntities = chineseMedPreMappService.getAllChineseMedPreMapp();
        final List<HashMap<String,String>> chineseMedpreMap=new ArrayList<>();
        for(final ChineseMedPreMappEntity chineseMedPreMappEntity:chineseMedPreMappEntities){
            chineseMedpreMap.add(new HashMap<String, String>(){{
                put("chineseMedPrescriptMappId",chineseMedPreMappEntity.getChineseMedPrescriptMappId().toString());
                put("tempChineseMedicineId",chineseMedicineInfoService.findByChineseMedicineId(chineseMedPreMappEntity.getTempChineseMedicineId()).getMedicineName());
                put("tempDoctorPrescriptionId",doctorPrescriptionService.findByDoctorPrescriptionId(chineseMedPreMappEntity.getTempDoctorPrescriptionId()).getPrescriptionName());
                put("chineseMedicineDose",chineseMedPreMappEntity.getchineseMedicineDose());
                put("tempUnitId",measurementUnitService.findByUnitId(chineseMedPreMappEntity.getTempUnitId()).getUnitName());
                put("decoctionMethod",chineseMedPreMappEntity.getDecoctionMethod());
            }});
        }
        return chineseMedpreMap;
    }

    @RequestMapping(value = "/chinesemedpremapp/findbyid/{chineseMedPrescriptMappId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ChineseMedPreMappEntity getChineseMedPreMappById(@PathVariable Long chineseMedPrescriptMappId) {
        return chineseMedPreMappService.findByChineseMedPrescriptMappId(chineseMedPrescriptMappId);
    }

    @RequestMapping(value = "/chinesemedpremapp/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void saveOrUpdateChineseMedPreMapp(ChineseMedPreMappEntity chineseMedPreMappEntity) {
        chineseMedPreMappService.saveOrUpdateChineseMedPreMapp(chineseMedPreMappEntity);
    }

    @RequestMapping(value = "/chinesemedpremapp/deletebyid/{chineseMedPrescriptMappId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteChineseMedPreMapp(@PathVariable Long chineseMedPrescriptMappId) {
        chineseMedPreMappService.deleteChineseMedPreMapp(chineseMedPrescriptMappId);
        return chineseMedPrescriptMappId;
    }
}
