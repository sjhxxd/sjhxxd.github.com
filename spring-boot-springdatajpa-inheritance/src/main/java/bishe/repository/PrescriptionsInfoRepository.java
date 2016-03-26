package bishe.repository;

import bishe.entity.PrescriptionsInfoEntity;

/**
 * Created by sjh on 16/3/23.
 */
public interface PrescriptionsInfoRepository extends BaseRepository<PrescriptionsInfoEntity>{
    public PrescriptionsInfoEntity findByprescriptionName(String prescriptionName);
}
