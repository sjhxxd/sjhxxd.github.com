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

    @RequestMapping(value = "/measurementunit/findbyname/{unitname}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public MeasurementUnitEntity getUnitByName(@PathVariable String unitname) {
        return measurementUnitRepository.findByUnitName(unitname);
    }

    @RequestMapping(value = "/measurementunit/findbyid/{unitId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public MeasurementUnitEntity getUnitById(@PathVariable Long unitId) {
        return measurementUnitService.findByUnitId(unitId);
    }

    @RequestMapping(value = "/measurementunit/saveorupdate", method = {RequestMethod.POST, RequestMethod.GET}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void saveOrUpdateUnit(MeasurementUnitEntity measurementUnitEntity) {
        measurementUnitService.saveOrUpdateMeasurementUnit(measurementUnitEntity);

    }

    @RequestMapping(value = "/measurementunit/deletebyid/{unitId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteUnit(@PathVariable Long unitId) {
        measurementUnitService.deleteMeasurementUnit(unitId);
        return unitId;
    }

}
