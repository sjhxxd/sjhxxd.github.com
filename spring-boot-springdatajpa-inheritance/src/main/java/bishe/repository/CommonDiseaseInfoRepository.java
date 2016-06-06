package bishe.repository;

import bishe.entity.CommonDiseaseInfoEntity;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface CommonDiseaseInfoRepository  extends BaseRepository<CommonDiseaseInfoEntity>{
    public CommonDiseaseInfoEntity findByCommonDiseaseName(String commonDiseaseName);
    public List<CommonDiseaseInfoEntity> findByTempCommonDiseaseTypeId(Long tempCommonDiseaseTypeId);

}
