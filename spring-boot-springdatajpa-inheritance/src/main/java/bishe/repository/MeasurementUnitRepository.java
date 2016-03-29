package bishe.repository;

import bishe.entity.MeasurementUnitEntity;

import javax.transaction.Transactional;

/**
 * Created by sjh on 16/3/23.
 */
@Transactional
public interface MeasurementUnitRepository extends BaseRepository<MeasurementUnitEntity>{
    public MeasurementUnitEntity findByUnitName(String unitName);
}
