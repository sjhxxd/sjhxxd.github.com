package bishe.service;

import bishe.entity.DoctorPrescriptionEntity;

import java.util.List;

/**
 * Created by sjh on 16/3/25.
 */
public interface DoctorPrescriptionService {
    public List<DoctorPrescriptionEntity> getAllDoctorPrescription();
    public DoctorPrescriptionEntity findByDoctorPrescriptionId(Long doctorPrescriptionId);
    public DoctorPrescriptionEntity saveOrUpdateDoctorPrescription(DoctorPrescriptionEntity doctorPrescriptionEntity);
    public DoctorPrescriptionEntity deleteDoctorPrescription(Long doctorPrescriptionId);
}
