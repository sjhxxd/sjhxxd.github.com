package bishe.admin.serviceImpl;

import bishe.admin.repository.DoctorLoginRepository;
import bishe.admin.service.DoctorLoginService;
import bishe.entity.DoctorInfoEntity;
import bishe.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sjh on 16/6/6.
 */
@Service("DoctorLoginServiceImpl")
public class DoctorLoginServiceImpl implements DoctorLoginService{
    private static final Logger logger = LoggerFactory.getLogger(DoctorLoginService.class);
    @Autowired
    private DoctorLoginRepository repo;

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
        DoctorInfoEntity doctorInfoEntity=repo.findByUserId(userId);
        return doctorInfoEntity.getDoctorPassword();
    }

    @Override
    public void updateByUserId(int userId, String userName, String newPassWord) {
        DoctorInfoEntity doctorInfoEntity=repo.findByUserId(userId);
        doctorInfoEntity.setDoctorPassword(MD5Util.MD5Encode(newPassWord,"utf-8"));
        doctorInfoEntity.setDoctorName(userName);
        repo.save(doctorInfoEntity);

    }
}
