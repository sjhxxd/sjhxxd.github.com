package bishe.controllers;

import bishe.entity.MeasurementUnitEntity;
import bishe.repository.MeasurementUnitRepository;
import bishe.service.MeasurementUnitService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sjh on 16/3/28.
 */
@RestController
public class MeasurementUnitController {
    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;
    @Autowired
    private MeasurementUnitService measurementUnitService;

    @RequestMapping(value = "/measurementunit/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<MeasurementUnitEntity> getMeasurementUnitAll() {
        return measurementUnitService.getAllMeasurementUnit();
    }

    @RequestMapping(value = "/measurementunit/findbyname",params="unitName", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public MeasurementUnitEntity getUnitByName(@RequestParam(value = "unitName", required = true) String unitName) {
        return measurementUnitRepository.findByUnitName(unitName);
    }

    @RequestMapping(value = "/measurementunit/findbyid/{unitId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public MeasurementUnitEntity getUnitById(@PathVariable Long unitId) {
        return measurementUnitService.findByUnitId(unitId);
    }

    @RequestMapping(value = "/measurementunit/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String saveOrUpdateUnit(MeasurementUnitEntity measurementUnitEntity) {
        try {
            measurementUnitService.saveOrUpdateMeasurementUnit(measurementUnitEntity);
            return "Success";
        } catch (Exception e) {
            System.out.println("错误:" + e.getMessage());
            return "Error";
        }

    }

    @RequestMapping(value = "/measurementunit/deletebyid/{unitId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteUnit(@PathVariable Long unitId) {
        measurementUnitService.deleteMeasurementUnit(unitId);
        return unitId;
    }

}
