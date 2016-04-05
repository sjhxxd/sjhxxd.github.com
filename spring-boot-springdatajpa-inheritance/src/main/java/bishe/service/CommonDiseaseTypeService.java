package bishe.service;

import bishe.entity.CommonDiseaseTypeEntity;

import java.util.List;

/**
 * Created by sjh on 16/4/5.
 */
public interface CommonDiseaseTypeService {
    public List<CommonDiseaseTypeEntity> getAllCommonDiseaseType();
    public CommonDiseaseTypeEntity findByCommonDiseaseTypeId(Long commonDiseaseTypeId);
    public CommonDiseaseTypeEntity saveOrUpdateCommonDiseaseType(CommonDiseaseTypeEntity commonDiseaseTypeEntity);
    public CommonDiseaseTypeEntity deleteCommonDiseaseType(Long commonDiseaseTypeId);
}
