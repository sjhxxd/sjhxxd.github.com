package bishe.repository;

import bishe.entity.DoctorInfoEntity;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sjh on 16/3/9.
 */
@Transactional
public interface DoctorInfoRepository extends BaseRepository<DoctorInfoEntity>{
    public List<DoctorInfoEntity> findByDoctorName(String doctorName);
}
