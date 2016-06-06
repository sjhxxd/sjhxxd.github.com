package bishe.admin.repository;

import bishe.entity.DoctorInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by sjh on 16/5/25.
 */
public interface DoctorLoginRepository extends JpaRepository<DoctorInfoEntity, Long>{
    @Query(value = "select doctor_password from doctorinfo where doctor_name=?1", nativeQuery = true)
    public String getPasswordByUserName(String userName);

    @Query(value = "select doctor_id from doctorinfo where doctor_name=?1", nativeQuery = true)
    public int getUserId(String doctorinfo);

    @Query(value = "select * from doctorinfo where doctor_id=?1", nativeQuery = true)
    public DoctorInfoEntity findByUserId(int userId);

}
