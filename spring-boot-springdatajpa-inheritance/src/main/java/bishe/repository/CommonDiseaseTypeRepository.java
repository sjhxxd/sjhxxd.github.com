package bishe.repository;

import bishe.entity.CommonDiseaseTypeEntity;

import javax.transaction.Transactional;

/**
 * Created by sjh on 16/4/5.
 */
@Transactional
public interface CommonDiseaseTypeRepository extends BaseRepository<CommonDiseaseTypeEntity>{
    public CommonDiseaseTypeEntity findByCommonDiseaseTypeName(String commonDiseaseTypeName);

}
