package bishe.repository;

import bishe.entity.PatentMedicineInfoEntity;

import javax.transaction.Transactional;

/**
 * Created by sjh on 16/3/23.
 */
@Transactional
public interface PatentMedicineInfoRepository extends BaseRepository<PatentMedicineInfoEntity>{
    public PatentMedicineInfoEntity findByPatentMedicineName(String patentMedicineName);
}
