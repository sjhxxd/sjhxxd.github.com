package bishe.implement;

import bishe.entity.ChineseMedicineInfoEntity;
import bishe.repository.ChineseMedicineInfoRepository;
import bishe.service.ChineseMedicineInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjh on 16/3/23.
 */
@Service("ChineseMedicineServiceImpl")
public class ChineseMedicineServiceImpl implements ChineseMedicineInfoService {
    @Autowired
    private ChineseMedicineInfoRepository chineseMedicineInfoRepository;

    @Override
    public List<ChineseMedicineInfoEntity> getAllChineseMedicine() {
        return (List<ChineseMedicineInfoEntity>) chineseMedicineInfoRepository.findAll();
    }

    @Override
    public ChineseMedicineInfoEntity findByChineseMedicineId(Long chineseMedicineId) {
        return chineseMedicineInfoRepository.findOne(chineseMedicineId);
    }

    @Override
    public ChineseMedicineInfoEntity saveOrUpdateChineseMedicine(ChineseMedicineInfoEntity chineseMedicineInfoEntity) {
        try {
            System.out.println(chineseMedicineInfoEntity.getChineseMedicineId());
            chineseMedicineInfoRepository.save(chineseMedicineInfoEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return chineseMedicineInfoEntity;
    }

    @Override
    public ChineseMedicineInfoEntity deleteChineseMedicine(long chineseMedicineId) {
        chineseMedicineInfoRepository.delete(chineseMedicineId);
        return null;
    }
}
