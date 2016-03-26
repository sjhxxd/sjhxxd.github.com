package bishe.service;

import bishe.entity.DoctorInfoEntity;

import java.util.List;

/**
 * Created by sjh on 16/3/10.
 */
public interface DoctorInfoService {
    public List<DoctorInfoEntity> getAllDoctor();
    public DoctorInfoEntity findByDoctorId(Long doctorId);
    public DoctorInfoEntity saveOrUpdateDoctor(DoctorInfoEntity doctorInfoEntity);
    public DoctorInfoEntity deleteDoctor(long doctorId);
}
