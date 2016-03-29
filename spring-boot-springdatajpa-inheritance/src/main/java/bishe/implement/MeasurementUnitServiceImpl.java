package bishe.implement;

import bishe.entity.MeasurementUnitEntity;
import bishe.repository.MeasurementUnitRepository;
import bishe.service.MeasurementUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjh on 16/3/28.
 */
@Service("MeasurementUnitServiceImpl")
public class MeasurementUnitServiceImpl implements MeasurementUnitService{
    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;

    @Override
    public List<MeasurementUnitEntity> getAllMeasurementUnit() {
        return (List<MeasurementUnitEntity>) measurementUnitRepository.findAll();
    }

    @Override
    public MeasurementUnitEntity findByUnitId(Long unitId) {
        return measurementUnitRepository.findOne(unitId);
    }

    @Override
    public MeasurementUnitEntity saveOrUpdateMeasurementUnit(MeasurementUnitEntity measurementUnitEntity) {
        try {
            System.out.println(measurementUnitEntity.getUnitId());
            measurementUnitRepository.save(measurementUnitEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return measurementUnitEntity;
    }

    @Override
    public MeasurementUnitEntity deleteMeasurementUnit(Long unitId) {
        measurementUnitRepository.delete(unitId);
        return null;
    }
}
