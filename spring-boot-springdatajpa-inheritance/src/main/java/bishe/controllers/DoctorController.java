package bishe.controllers;

import bishe.entity.DoctorInfoEntity;
import bishe.frontentity.ReturnModel;
import bishe.repository.DoctorInfoRepository;
import bishe.service.DoctorInfoService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sjh on 16/3/10.
 */
@RestController
public class DoctorController {
    @Autowired
    private DoctorInfoRepository doctorInfoRepository;
    @Autowired
    private DoctorInfoService doctorInfoService;

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

    @RequestMapping(value = "/doctorinfo/findbyname", params="doctorName",method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single hotel.", notes = "You have to provide a valid hotel ID.")
    @ResponseBody
    public DoctorInfoEntity getDoctorByOne(@RequestParam(value = "doctorName", required = true) String doctorName) {
        System.out.println(doctorInfoRepository.findByDoctorName(doctorName).getDoctorName());
        return doctorInfoRepository.findByDoctorName(doctorName);
    }

    @RequestMapping(value = "/doctorinfo/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a hotel resource.", notes = "Returns the URL of the new resource in the Location header.")
    @ResponseBody
    public void saveOrUpdateDoctor(DoctorInfoEntity doctorInfoEntity) {
        doctorInfoService.saveOrUpdateDoctor(doctorInfoEntity);

    }


    @RequestMapping(value = "/doctorinfo/deletebyid/{doctorId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "delete a hotel resource.", notes = "Returns the URL of the new resource in the Location header.")
    @ResponseBody
    public Long deleteDoctorInfo(@PathVariable Long doctorId) {
        doctorInfoService.deleteDoctor(doctorId);
        return doctorId;

    }
}
