package bishe.implement;

import bishe.entity.ChineseMedPreMappEntity;
import bishe.repository.ChineseMedPreMappReopsitory;
import bishe.service.ChineseMedPreMappService;
import bishe.service.ChineseMedicineInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjh on 16/3/30.
 */
@Service("ChineseMedPreMappServiceImpl")
public class ChineseMedPreMappServiceImpl implements ChineseMedPreMappService{
    @Autowired
    private ChineseMedPreMappReopsitory chineseMedPreMappReopsitory;

    @Override
    public List<ChineseMedPreMappEntity> getAllChineseMedPreMapp() {
        return (List<ChineseMedPreMappEntity>) chineseMedPreMappReopsitory.findAll();
    }

    @Override
    public ChineseMedPreMappEntity findByChineseMedPrescriptMappId(Long chineseMedPrescriptMappId) {
        return chineseMedPreMappReopsitory.findOne(chineseMedPrescriptMappId);
    }

    @Override
    public ChineseMedPreMappEntity saveOrUpdateChineseMedPreMapp(ChineseMedPreMappEntity chineseMedPreMappEntity) {
        try {
            System.out.println(chineseMedPreMappEntity.getChineseMedPrescriptMappId());
            chineseMedPreMappReopsitory.save(chineseMedPreMappEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return chineseMedPreMappEntity;
    }

    @Override
    public ChineseMedPreMappEntity deleteChineseMedPreMapp(Long chineseMedPrescriptMappId) {
        chineseMedPreMappReopsitory.delete(chineseMedPrescriptMappId);
        return null;
    }
}
