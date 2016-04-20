package bishe.implement;

import bishe.entity.DoctorInfoEntity;
import bishe.repository.DoctorInfoRepository;
import bishe.service.DoctorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjh on 16/3/10.
 */
@Service("DoctorInfoServiceImpl")
public class DoctorInfoServiceImpl implements DoctorInfoService {
    @Autowired
    private DoctorInfoRepository doctorInfoRepository;

    @Override
    public List<DoctorInfoEntity> getAllDoctor() {


        return (List<DoctorInfoEntity>) doctorInfoRepository.findAll();
    }

    @Override
    public DoctorInfoEntity findByDoctorId(Long doctorId) {
        return doctorInfoRepository.findOne(doctorId);
    }

    @Override
    public DoctorInfoEntity saveOrUpdateDoctor(DoctorInfoEntity doctorInfoEntity) {
        try {
            System.out.println(doctorInfoEntity.getDoctorId());
            doctorInfoRepository.save(doctorInfoEntity);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return doctorInfoEntity;
    }


    @Override
    public DoctorInfoEntity deleteDoctor(Long doctorId) {
        doctorInfoRepository.delete(doctorId);
        return null;
    }
}
