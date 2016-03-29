package bishe.service;

import bishe.entity.MeasurementUnitEntity;

import java.util.List;

/**
 * Created by sjh on 16/3/28.
 */
public interface MeasurementUnitService {
    public List<MeasurementUnitEntity> getAllMeasurementUnit();
    public MeasurementUnitEntity findByUnitId(Long unitId);
    public MeasurementUnitEntity saveOrUpdateMeasurementUnit(MeasurementUnitEntity measurementUnitEntity);
    public MeasurementUnitEntity deleteMeasurementUnit(Long unitId);
}
