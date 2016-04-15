package bishe.controllers;

import bishe.entity.DoctorInfoEntity;
import bishe.repository.DoctorInfoRepository;
import bishe.service.DoctorInfoService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by sjh on 16/3/10.
 */
@RestController
public class DoctorController {
    @Autowired
    private DoctorInfoRepository doctorInfoRepository;
    @Autowired
    private DoctorInfoService doctorInfoService;

    @RequestMapping(value = "/doctorinfo/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single hotel.", notes = "You have to provide a valid hotel ID.")
    @ResponseBody
    public List<DoctorInfoEntity> getDoctorInfoAll() {
        return doctorInfoService.getAllDoctor();

    }

    @RequestMapping(value = "/doctorinfo/findbyname/{doctorname}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single hotel.", notes = "You have to provide a valid hotel ID.")
    @ResponseBody
    public DoctorInfoEntity getDoctorByOne(@PathVariable String doctorname) {
        System.out.println(doctorInfoRepository.findByDoctorName(doctorname).getDoctorName());
        return doctorInfoRepository.findByDoctorName(doctorname);
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
