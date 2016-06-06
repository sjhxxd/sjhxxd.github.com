package bishe.admin.repository;

import bishe.entity.DoctorInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sjh on 16/5/25.
 */
public interface DoctorLoginRepository extends JpaRepository<DoctorInfoEntity, Long>{

}
