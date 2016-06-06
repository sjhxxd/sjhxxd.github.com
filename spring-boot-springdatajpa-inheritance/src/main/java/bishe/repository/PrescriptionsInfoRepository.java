package bishe.repository;

import bishe.entity.PrescriptionsInfoEntity;

import java.util.List;

/**
 * Created by sjh on 16/3/23.
 */
public interface PrescriptionsInfoRepository extends BaseRepository<PrescriptionsInfoEntity>{
    public List<PrescriptionsInfoEntity> findByprescriptionName(String prescriptionName);
}
