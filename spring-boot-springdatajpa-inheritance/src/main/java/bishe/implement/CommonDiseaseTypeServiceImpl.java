package bishe.implement;

import bishe.entity.CommonDiseaseInfoEntity;
import bishe.entity.CommonDiseaseTypeEntity;
import bishe.repository.CommonDiseaseTypeRepository;
import bishe.service.CommonDiseaseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjh on 16/4/5.
 */
@Service("CommonDiseaseTypeServiceImpl")
public class CommonDiseaseTypeServiceImpl implements CommonDiseaseTypeService {
    @Autowired
    private CommonDiseaseTypeRepository commonDiseaseTypeRepository;

    @Override
    public List<CommonDiseaseTypeEntity> getAllCommonDiseaseType() {
        return (List<CommonDiseaseTypeEntity>) commonDiseaseTypeRepository.findAll();
    }

    @Override
    public CommonDiseaseTypeEntity findByCommonDiseaseTypeId(Long commonDiseaseTypeId) {
        return commonDiseaseTypeRepository.findOne(commonDiseaseTypeId);
    }

    @Override
    public CommonDiseaseTypeEntity saveOrUpdateCommonDiseaseType(CommonDiseaseTypeEntity commonDiseaseTypeEntity) {
        try {
            System.out.println(commonDiseaseTypeEntity.getCommonDiseaseTypeId());
            commonDiseaseTypeRepository.save(commonDiseaseTypeEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return commonDiseaseTypeEntity;
    }

    @Override
    public CommonDiseaseTypeEntity deleteCommonDiseaseType(Long commonDiseaseTypeId) {
        commonDiseaseTypeRepository.delete(commonDiseaseTypeId);
        return null;
    }
}
