package bishe.repository;

import bishe.entity.DoctorPrescriptionEntity;

import javax.transaction.Transactional;

/**
 * Created by sjh on 16/3/23.
 */
@Transactional
public interface DoctorPrescriptionRepository extends BaseRepository<DoctorPrescriptionEntity>{
    public DoctorPrescriptionEntity findByPrescriptionName(String prescriptionName);
}
