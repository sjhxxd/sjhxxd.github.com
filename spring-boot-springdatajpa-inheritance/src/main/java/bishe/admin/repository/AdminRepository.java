package bishe.admin.repository;

import bishe.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by sjh on 16/5/23.
 */
public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {

    @Query(value = "select admin_password from tb_admin where admin_name=?1", nativeQuery = true)
    public String getPasswordByUserName(String userName);

    @Query(value = "select admin_id from tb_admin where admin_name=?1", nativeQuery = true)
    public int getUserId(String userName);

    @Query(value = "select * from tb_admin where admin_id=?1", nativeQuery = true)
    public AdminEntity findByUserId(int userId);
}
