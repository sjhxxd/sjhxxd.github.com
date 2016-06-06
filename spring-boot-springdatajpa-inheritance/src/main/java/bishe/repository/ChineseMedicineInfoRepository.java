package bishe.repository;

import bishe.entity.ChineseMedicineInfoEntity;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sjh on 16/3/23.
 */

@Transactional
public interface ChineseMedicineInfoRepository extends BaseRepository<ChineseMedicineInfoEntity>{
    //    按中药名查找
    public List<ChineseMedicineInfoEntity> findByMedicineName(String medicineName);
    //    按药性查找
    public List<ChineseMedicineInfoEntity> findByMedicineProperty(String medicineProperty);
    //    按药味查找
    public List<ChineseMedicineInfoEntity> findByMedicineTaste(String medicineTaste);
    //    按功效类别查找
    public List<ChineseMedicineInfoEntity> findByEffectType(String effectType);
    //    按品级查找
    public List<ChineseMedicineInfoEntity> findByMedicineGrade(String medicineGrade);
}
