package bishe.service;

import bishe.entity.PatentMedicineInfoEntity;

import java.util.List;

/**
 * Created by sjh on 16/3/26.
 */
public interface PatentMedicineInfoService {

    public List<PatentMedicineInfoEntity> getAllPatentMedicine();
    public PatentMedicineInfoEntity finByPatentMedicineId(Long patentMedicineId);
    public PatentMedicineInfoEntity saveOrUpdatePatentMedicine(PatentMedicineInfoEntity patentMedicineInfoEntity);
    public PatentMedicineInfoEntity deletePatentMedicine(Long patentMedicineId);
}
