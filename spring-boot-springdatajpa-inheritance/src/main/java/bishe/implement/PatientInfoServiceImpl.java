package bishe.implement;

import bishe.entity.PatientInfoEntity;
import bishe.repository.PatientInfoRepository;
import bishe.service.PatientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjh on 16/3/9.
 */
@Service("PatientInfoServiceImpl")
public class PatientInfoServiceImpl implements PatientInfoService {
    @Autowired
    private PatientInfoRepository patientInfoRepository;
    @Override
    public List<PatientInfoEntity> getAllPatient() {

        return (List<PatientInfoEntity>) patientInfoRepository.findAll();
    }

    @Override
    public PatientInfoEntity findByPatientId(Long patientId) {
        return patientInfoRepository.findOne(patientId);
    }

    @Override
    public PatientInfoEntity saveOrUpdatePatient(PatientInfoEntity patientInfoEntity) {
        try {
            System.out.println(patientInfoEntity.getPatientId());
            patientInfoRepository.save(patientInfoEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return patientInfoEntity;
    }



    @Override
    public PatientInfoEntity deletePatient(Long patientId) {
        patientInfoRepository.delete(patientId);
        //return patientId;
        return null;
    }
}
