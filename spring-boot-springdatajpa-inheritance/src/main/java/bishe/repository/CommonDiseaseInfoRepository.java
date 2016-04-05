package bishe.repository;

import bishe.entity.CommonDiseaseInfoEntity;

import javax.transaction.Transactional;

/**
 * Created by sjh on 16/4/5.
 */
@Transactional
public interface CommonDiseaseInfoRepository  extends BaseRepository<CommonDiseaseInfoEntity>{
    public CommonDiseaseInfoEntity findByCommonDiseaseName(String commonDiseaseName);
}
