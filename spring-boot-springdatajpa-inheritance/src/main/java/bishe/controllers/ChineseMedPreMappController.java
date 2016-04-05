package bishe.controllers;

import bishe.entity.ChineseMedPreMappEntity;
import bishe.service.ChineseMedPreMappService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sjh on 16/3/30.
 */
@RestController
public class ChineseMedPreMappController {
    @Autowired
    private ChineseMedPreMappService chineseMedPreMappService;

    @RequestMapping(value = "/chinesemedpremapp/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<ChineseMedPreMappEntity> getChineseMedPreMappAll() {
        return chineseMedPreMappService.getAllChineseMedPreMapp();
    }

    @RequestMapping(value = "/chinesemedpremapp/findbyid/{chineseMedPrescriptMappId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ChineseMedPreMappEntity getChineseMedPreMappById(@PathVariable Long chineseMedPrescriptMappId) {
        return chineseMedPreMappService.findByChineseMedPrescriptMappId(chineseMedPrescriptMappId);
    }

    @RequestMapping(value = "/chinesemedpremapp/saveorupdate", method = {RequestMethod.POST, RequestMethod.GET}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void saveOrUpdateChineseMedPreMapp(ChineseMedPreMappEntity chineseMedPreMappEntity){
        chineseMedPreMappService.saveOrUpdateChineseMedPreMapp(chineseMedPreMappEntity);
    }

    @RequestMapping(value = "/chinesemedpremapp/deletebyid/{chineseMedPrescriptMappId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteChineseMedPreMapp(@PathVariable Long chineseMedPrescriptMappId){
        chineseMedPreMappService.deleteChineseMedPreMapp(chineseMedPrescriptMappId);
        return chineseMedPrescriptMappId;
    }
}
