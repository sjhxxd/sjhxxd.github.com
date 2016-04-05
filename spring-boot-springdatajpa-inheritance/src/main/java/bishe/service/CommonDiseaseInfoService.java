package bishe.service;

import bishe.entity.CommonDiseaseInfoEntity;

import java.util.List;

/**
 * Created by sjh on 16/4/5.
 */
public interface CommonDiseaseInfoService {
    public List<CommonDiseaseInfoEntity> getAllCommonDiseaseInfo();
    public CommonDiseaseInfoEntity findByCommonDiseaseId(Long commonDiseaseId);
    public CommonDiseaseInfoEntity saveOrUpdateCommonDiseaseInfo(CommonDiseaseInfoEntity commonDiseaseInfoEntity);
    public CommonDiseaseInfoEntity deleteCommonDiseaseInfo(Long commonDiseaseId);
}
