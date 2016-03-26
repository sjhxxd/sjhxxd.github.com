package bishe.repository;

import bishe.entity.DoctorInfoEntity;

import javax.transaction.Transactional;

/**
 * Created by sjh on 16/3/9.
 */
@Transactional
public interface DoctorInfoRepository extends BaseRepository<DoctorInfoEntity>{
    public DoctorInfoEntity findByDoctorName(String doctorName);
}
