package bishe.controllers;

import bishe.entity.SyndromeTypesEntity;
import bishe.repository.SyndromeTypesReopsitory;
import bishe.service.SyndromeTypesService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sjh on 16/3/31.
 */
@RestController
public class SyndromeTypesController {
    @Autowired
    private SyndromeTypesReopsitory syndromeTypesReopsitory;
    @Autowired
    private SyndromeTypesService syndromeTypesService;

    @RequestMapping(value = "/syndrometypes/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<SyndromeTypesEntity> getSyndromeTypesAll(){
        return syndromeTypesService.getAllSyndromeTypes();
    }

    @RequestMapping(value = "/syndrometypes/findbyname",params="syndromeName", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public SyndromeTypesEntity getSyndromeByName(@RequestParam(value = "syndromeName", required = true) String syndromeName){
        return syndromeTypesReopsitory.findBySyndromeName(syndromeName);
    }

    @RequestMapping(value = "/syndrometypes/findbyid/{syndromeId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public SyndromeTypesEntity getSyndromeById(@PathVariable Long syndromeId){
        return syndromeTypesService.findBySyndromeId(syndromeId);
    }

    @RequestMapping(value = "/syndrometypes/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void saveOrUpdateSyndrome(SyndromeTypesEntity syndromeTypesEntity){
        syndromeTypesService.saveOrUpdateSyndromeTypes(syndromeTypesEntity);

    }

    @RequestMapping(value = "/syndrometypes/deletebyid/{syndromeId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteSyndrome(@PathVariable Long syndromeId){
        syndromeTypesService.deleteSyndromeTypes(syndromeId);
        return syndromeId;
    }


}
