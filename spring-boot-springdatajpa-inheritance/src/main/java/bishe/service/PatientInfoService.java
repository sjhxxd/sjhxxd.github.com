package bishe.service;

import bishe.entity.PatientInfoEntity;

import java.util.List;

/**
 * Created by sjh on 16/3/9.
 */

public interface PatientInfoService {

    public List<PatientInfoEntity> getAllPatient();
    public PatientInfoEntity findByPatientId(Long patientId);
    public PatientInfoEntity saveOrUpdatePatient(PatientInfoEntity patientInfoEntity);
    public PatientInfoEntity deletePatient(Long patientId);
}
