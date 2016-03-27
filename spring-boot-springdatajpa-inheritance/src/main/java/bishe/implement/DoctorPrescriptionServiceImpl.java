package bishe.implement;

import bishe.entity.DoctorPrescriptionEntity;
import bishe.repository.DoctorPrescriptionRepository;
import bishe.service.DoctorPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjh on 16/3/27.
 */
@Service("DoctorPrescriptionServiceImpl")
public class DoctorPrescriptionServiceImpl implements DoctorPrescriptionService{

    @Autowired
    private DoctorPrescriptionRepository doctorPrescriptionRepository;

    @Override
    public List<DoctorPrescriptionEntity> getAllDoctorPrescription() {
        return (List<DoctorPrescriptionEntity>) doctorPrescriptionRepository.findAll();
    }

    @Override
    public DoctorPrescriptionEntity findByDoctorPrescriptionId(Long doctorPrescriptionId) {
        return doctorPrescriptionRepository.findOne(doctorPrescriptionId);
    }

    @Override
    public DoctorPrescriptionEntity saveOrUpdateDoctorPrescription(DoctorPrescriptionEntity doctorPrescriptionEntity) {
        try {
            doctorPrescriptionRepository.save(doctorPrescriptionEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return doctorPrescriptionEntity;
    }

    @Override
    public DoctorPrescriptionEntity deleteDoctorPrescription(Long doctorPrescriptionId) {
        doctorPrescriptionRepository.delete(doctorPrescriptionId);
        return null;
    }
}
