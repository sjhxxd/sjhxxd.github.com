package bishe.controllers;

import bishe.entity.DoctorInfoEntity;
import bishe.repository.DoctorInfoRepository;
import bishe.service.DoctorInfoService;
import bishe.utils.ExtReturn;
import com.google.gson.Gson;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;


/**
 * Created by sjh on 16/3/10.
 */
@RestController
public class DoctorController {
    @Autowired
    private DoctorInfoRepository doctorInfoRepository;
    @Autowired
    private DoctorInfoService doctorInfoService;
    Gson gson = new Gson();

    //private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);

//    @RequestMapping(value="/doctor/login",method=RequestMethod.POST)
//    public ReturnModel DoctorLogin(@RequestParam("doctorName") String doctorName, @RequestParam("doctorPassword") String password){
//        try{
//            if(service.getUserPassWord(doctorName).equals(MD5Util.MD5Encode(password, "UTF-8"))) {
//                Map map = new HashMap();
//                map.put("userId", service.getUserId(userName));
//                map.put("userName", userName);
//                return new ReturnModel(1,map);
//            }else{
//                return new ReturnModel(0,"用户名密码错误");
//            }
//        }catch (Exception e){
//            return new ReturnModel(0,"用户名密码错误");
//        }
//    }

    @RequestMapping(value = "/doctorinfo/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single hotel.", notes = "You have to provide a valid hotel ID.")
    @ResponseBody
    public List<DoctorInfoEntity> getDoctorInfoAll() {
        return doctorInfoService.getAllDoctor();

    }

    @RequestMapping(value = "/doctorinfo/findbyname", params = "doctorName", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single hotel.", notes = "You have to provide a valid hotel ID.")
    @ResponseBody
    public List<DoctorInfoEntity> getDoctorByOne(@RequestParam(value = "doctorName", required = true) String doctorName) {
        return doctorInfoRepository.findByDoctorName(doctorName);
    }

    @RequestMapping(value = "/doctorinfo/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a hotel resource.", notes = "Returns the URL of the new resource in the Location header.")
    @ResponseBody
    public String saveOrUpdateDoctor(DoctorInfoEntity doctorInfoEntity, @RequestBody String requestBody) {
        try {
            if (requestBody.substring(0, 1).equals("[")) {
                DoctorInfoEntity doctorInfoEntity1 = gson.fromJson(requestBody.substring(1, requestBody.length() - 1), DoctorInfoEntity.class);
                doctorInfoService.saveOrUpdateDoctor(doctorInfoEntity1);
                return "Android_Success";
            }
            doctorInfoService.saveOrUpdateDoctor(doctorInfoEntity);
            return "Success";
        } catch (Exception e) {
            return "Error";
        }

    }



//    手机号登录
//    @RequestMapping(value="/doctor/login" ,method = RequestMethod.POST)
//    public ExtReturn MobileLogin(@RequestParam(value="mobile") String mobile , @RequestParam(value="userPwd") String userPwd , HttpSession session) throws Exception {
//        logger.info("phoneNumber:"+mobile);
//        logger.info("passWord:"+userPwd);
//        if(service.checkPhoneNumber(mobile)!=null) {
//            if (service.getPassWordByMobile(mobile).equals(MD5Util.MD5Encode(userPwd,"UTF-8"))) {
//                session.setAttribute("sessionId",service.getUserIdByMobile(mobile));
//                logger.info("登陆成功");
//
//                return new ExtReturn("success","登陆成功",service.getUserIfoByMobile(mobile));
//            } else {
//                return new ExtReturn("fail","账号或密码错误",1);
//            }
//        }else{
//            return new ExtReturn("fail","账号或密码错误",1);
//        }
//
//    }



    @RequestMapping(value = "/doctorinfo/deletebyid/{doctorId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteDoctorInfo(@PathVariable Long doctorId) {
        doctorInfoService.deleteDoctor(doctorId);
        return doctorId;

    }
}
