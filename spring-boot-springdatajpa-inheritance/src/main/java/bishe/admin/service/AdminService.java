package bishe.admin.service;

/**
 * Created by sjh on 16/5/23.
 */
public interface AdminService {
    public  String getUserPassWord(String userName);

    public  int getUserId(String userName);

    public  String checkPassWord(int userId);

    public void updateByUserId(int userId,String userName, String newPassWord);

}
