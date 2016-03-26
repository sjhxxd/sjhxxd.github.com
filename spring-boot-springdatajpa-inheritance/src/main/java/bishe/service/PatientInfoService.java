package bishe.service;

import bishe.entity.PatientInfoEntity;
import bishe.repository.PatientInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
