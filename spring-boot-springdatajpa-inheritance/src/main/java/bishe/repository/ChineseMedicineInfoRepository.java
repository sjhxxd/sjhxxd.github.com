package bishe.repository;

import bishe.entity.ChineseMedicineInfoEntity;

import javax.transaction.Transactional;

/**
 * Created by sjh on 16/3/23.
 */

@Transactional
public interface ChineseMedicineInfoRepository extends BaseRepository<ChineseMedicineInfoEntity>{
    public ChineseMedicineInfoEntity findByMedicineName(String medicineName);
}
