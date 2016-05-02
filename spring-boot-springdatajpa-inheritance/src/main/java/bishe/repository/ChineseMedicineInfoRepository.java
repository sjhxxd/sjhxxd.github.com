package bishe.repository;

import bishe.entity.ChineseMedicineInfoEntity;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sjh on 16/3/23.
 */

@Transactional
public interface ChineseMedicineInfoRepository extends BaseRepository<ChineseMedicineInfoEntity>{
    public List<ChineseMedicineInfoEntity> findByMedicineName(String medicineName);
}
