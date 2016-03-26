package bishe.controllers;

import bishe.entity.FoodMaterialInfoEntity;
import bishe.repository.FoodMaterialInfoRepository;
import bishe.service.FoodMaterialInfoService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by sjh on 16/3/24.
 */
@RestController
public class FoodMaterialInfoController {
    @Autowired
    private FoodMaterialInfoRepository foodMaterialInfoRepository;
    @Autowired
    private FoodMaterialInfoService foodMaterialInfoService;


    @RequestMapping(value = "/foodmaterialinfo/getbyname", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<FoodMaterialInfoEntity> getFoodMaterialInfoByName() {
        return foodMaterialInfoService.getAllFood();
    }


    @RequestMapping(value = "/foodmaterialinfo/findbyname/{foodMaterialName}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public FoodMaterialInfoEntity getFoodMaterialByOne(@PathVariable String foodMaterialName) {
        return foodMaterialInfoRepository.findByFoodMaterialName(foodMaterialName);
    }

    @RequestMapping(value = "/foodmaterialinfo/saveorupdate", method = {RequestMethod.POST, RequestMethod.GET}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void saveOrUpdateFood(FoodMaterialInfoEntity foodMaterialInfoEntity) {
        foodMaterialInfoService.saveOrUpdateFood(foodMaterialInfoEntity);
    }

    @RequestMapping(value = "/foodmaterialinfo/deletebyid/{foodMaterialId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deletePatientInfo(@PathVariable Long foodMaterialId) {
        foodMaterialInfoService.delateFood(foodMaterialId);
        return foodMaterialId;
    }
}
