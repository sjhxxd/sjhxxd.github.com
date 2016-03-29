package bishe.repository;

import bishe.entity.MedPrescriptMappEntity;

import javax.transaction.Transactional;

/**
 * Created by sjh on 16/3/29.
 */
@Transactional
public interface MedPrescriptMappRepository extends BaseRepository<MedPrescriptMappEntity>{
}
