package bishe.implement;

import bishe.entity.CommonDiseaseInfoEntity;
import bishe.repository.CommonDiseaseInfoRepository;
import bishe.service.CommonDiseaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjh on 16/4/5.
 */
@Service("CommonDiseaseInfoServiceImpl")
public class CommonDiseaseInfoServiceImpl implements CommonDiseaseInfoService{
    @Autowired
    private CommonDiseaseInfoRepository commonDiseaseInfoRepository;

    @Override
    public List<CommonDiseaseInfoEntity> getAllCommonDiseaseInfo() {
        return (List<CommonDiseaseInfoEntity>) commonDiseaseInfoRepository.findAll();
    }

    @Override
    public CommonDiseaseInfoEntity findByCommonDiseaseId(Long commonDiseaseId) {
        return commonDiseaseInfoRepository.findOne(commonDiseaseId);

    }

    @Override
    public CommonDiseaseInfoEntity saveOrUpdateCommonDiseaseInfo(CommonDiseaseInfoEntity commonDiseaseInfoEntity) {
        try {
            System.out.println(commonDiseaseInfoEntity.getCommonDiseaseId());
            commonDiseaseInfoRepository.save(commonDiseaseInfoEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return commonDiseaseInfoEntity;
    }

    @Override
    public CommonDiseaseInfoEntity deleteCommonDiseaseInfo(Long commonDiseaseId) {
        commonDiseaseInfoRepository.delete(commonDiseaseId);
        return null;
    }
}
