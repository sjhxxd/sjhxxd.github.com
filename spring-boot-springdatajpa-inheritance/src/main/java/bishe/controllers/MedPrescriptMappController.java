package bishe.controllers;

import bishe.entity.MedPrescriptMappEntity;
import bishe.entity.PatientInfoEntity;
import bishe.service.MedPrescriptMappService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sjh on 16/3/29.
 */
@RestController
public class MedPrescriptMappController {
    @Autowired
    private MedPrescriptMappService medPrescriptMappService;

    @RequestMapping(value = "/medprescriptmapp/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<MedPrescriptMappEntity> getMedPrescriptMappAll(){
        return medPrescriptMappService.getAllMedPrescriptMapp();
    }

    @RequestMapping(value = "/medprescriptmapp/findbyid/{chineseMedPrescriptMappId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public MedPrescriptMappEntity getMedPrescriptMappById(@PathVariable Long chineseMedPrescriptMappId){
        return medPrescriptMappService.fingByChineseMedPrescriptMappId(chineseMedPrescriptMappId);

    }

    @RequestMapping(value = "/medprescriptmapp/saveorupdate", method = {RequestMethod.POST, RequestMethod.GET}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void saveorUpdateMedPrescriptMapp(MedPrescriptMappEntity medPrescriptMappEntity){
        medPrescriptMappService.saveOrUpdateMedPrescriptMapp(medPrescriptMappEntity);
    }

    @RequestMapping(value = "/medprescriptmapp/deletebyid/{chineseMedPrescriptMappId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteMedPrescriptMapp(@PathVariable Long chineseMedPrescriptMappId){
        medPrescriptMappService.deleteMedPrescriptMapp(chineseMedPrescriptMappId);
        return chineseMedPrescriptMappId;
    }
}
