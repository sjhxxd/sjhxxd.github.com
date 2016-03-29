package bishe.service;

import bishe.entity.MedPrescriptMappEntity;

import java.util.List;

/**
 * Created by sjh on 16/3/29.
 */

public interface MedPrescriptMappService {
    public List<MedPrescriptMappEntity> getAllMedPrescriptMapp();
    public MedPrescriptMappEntity fingByChineseMedPrescriptMappId(Long chineseMedPrescriptMappId);
    public MedPrescriptMappEntity saveOrUpdateMedPrescriptMapp(MedPrescriptMappEntity medPrescriptMappEntity);
    public MedPrescriptMappEntity deleteMedPrescriptMapp(Long chineseMedPrescriptMappId);
}
