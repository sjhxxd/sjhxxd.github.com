package bishe.admin.serviceImpl;

import bishe.entity.AdminEntity;
import bishe.admin.repository.AdminRepository;
import bishe.admin.service.AdminService;
import bishe.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by sjh on 16/5/23.
 */
@Service("AdminImpl")
public class AdminServiceImpl implements AdminService {
    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);
    @Autowired
    private AdminRepository repo;

    @Override
    public String getUserPassWord(String userName) {
        return repo.getPasswordByUserName(userName);
    }

    @Override
    public int getUserId(String userName) {
        return repo.getUserId(userName);
    }

    @Override
    public String checkPassWord(int userId) {
        AdminEntity adminEntity = repo.findByUserId(userId);
        return adminEntity.getAdminPassword();
    }

    @Override
    public void updateByUserId(int userId, String userName, String newPassWord) {
        AdminEntity adminEntity = repo.findByUserId(userId);
        adminEntity.setAdminPassword(MD5Util.MD5Encode(newPassWord, "utf-8"));
        adminEntity.setAdminName(userName);
        repo.save(adminEntity);
    }
}
