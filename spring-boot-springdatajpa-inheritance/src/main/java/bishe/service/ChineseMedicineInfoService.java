package bishe.service;

import bishe.entity.ChineseMedicineInfoEntity;

import java.util.List;

/**
 * Created by sjh on 16/3/23.
 */
public interface ChineseMedicineInfoService {
    public List<ChineseMedicineInfoEntity> getAllChineseMedicine();
    public ChineseMedicineInfoEntity findByChineseMedicineId(Long chineseMedicineId);
    public ChineseMedicineInfoEntity saveOrUpdateChineseMedicine(ChineseMedicineInfoEntity chineseMedicineInfoEntity);
    public ChineseMedicineInfoEntity deleteChineseMedicine(Long chineseMedicineId);
}
