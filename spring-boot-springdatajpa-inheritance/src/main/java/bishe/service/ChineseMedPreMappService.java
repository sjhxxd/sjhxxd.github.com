package bishe.service;

import bishe.entity.ChineseMedPreMappEntity;

import java.util.List;

/**
 * Created by sjh on 16/3/30.
 */
public interface ChineseMedPreMappService {
    public List<ChineseMedPreMappEntity> getAllChineseMedPreMapp();
    public ChineseMedPreMappEntity findByChineseMedPrescriptMappId(Long chineseMedPrescriptMappId);
    public ChineseMedPreMappEntity saveOrUpdateChineseMedPreMapp(ChineseMedPreMappEntity chineseMedPreMappEntity);
    public ChineseMedPreMappEntity deleteChineseMedPreMapp(Long chineseMedPrescriptMappId);
}
