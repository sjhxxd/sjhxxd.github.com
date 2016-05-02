package bishe.repository;

import bishe.entity.PatientInfoEntity;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sjh on 16/3/9.
 */
@Transactional
public interface PatientInfoRepository extends BaseRepository<PatientInfoEntity> {

    public List<PatientInfoEntity> findByPatientName(String patientName);
}
