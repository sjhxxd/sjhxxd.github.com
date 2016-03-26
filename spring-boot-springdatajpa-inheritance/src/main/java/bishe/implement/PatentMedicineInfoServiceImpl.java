package bishe.implement;

import bishe.entity.PatentMedicineInfoEntity;
import bishe.repository.PatentMedicineInfoRepository;
import bishe.service.PatentMedicineInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjh on 16/3/26.
 */
@Service("PatentMedicineInfoServiceImpl")
public class PatentMedicineInfoServiceImpl implements PatentMedicineInfoService{
    @Autowired
    private PatentMedicineInfoRepository patentMedicineInfoRepository;

    @Override
    public List<PatentMedicineInfoEntity> getAllPatentMedicine() {
        return (List<PatentMedicineInfoEntity>) patentMedicineInfoRepository.findAll();
    }

    @Override
    public PatentMedicineInfoEntity finByPatentMedicineId(Long patentMedicineId) {
        return patentMedicineInfoRepository.findOne(patentMedicineId);
    }

    @Override
    public PatentMedicineInfoEntity saveOrUpdatePatentMedicine(PatentMedicineInfoEntity patentMedicineInfoEntity) {
        try {
            System.out.println(patentMedicineInfoEntity.getPatentMedicineId());
            patentMedicineInfoRepository.save(patentMedicineInfoEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return patentMedicineInfoEntity;
    }

    @Override
    public PatentMedicineInfoEntity deletePatentMedicine(Long patentMedicineId) {
        patentMedicineInfoRepository.delete(patentMedicineId);
        return null;
    }
}
