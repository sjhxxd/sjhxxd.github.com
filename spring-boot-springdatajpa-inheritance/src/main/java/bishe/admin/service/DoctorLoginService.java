package bishe.admin.service;

/**
 * Created by sjh on 16/6/6.
 */
public interface DoctorLoginService {
    public  String getUserPassWord(String userName);

    public  int getUserId(String userName);

    public  String checkPassWord(int userId);

    public void updateByUserId(int userId,String userName, String newPassWord);
}
