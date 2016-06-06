package bishe.controllers;

import bishe.entity.PrescriptionsInfoEntity;
import bishe.repository.PrescriptionsInfoRepository;
import bishe.service.PrescriptionsInfoService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by sjh on 16/3/24.
 */
@RestController
public class PrescriptionsController {
    @Autowired
    private PrescriptionsInfoRepository prescriptionsInfoRepository;
    @Autowired
    private PrescriptionsInfoService prescriptionsInfoService;

//    返回list数据
    @RequestMapping(value = "/presctiptionsinfo/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<PrescriptionsInfoEntity> getPrescriptionsInfoAll(){
        return prescriptionsInfoService.getAllPrescriptions();
    }

//    prescriptionsInfoRepository中findname方法
    @RequestMapping(value = "/presctiptionsinfo/findbyname", params="prescriptionName",method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<PrescriptionsInfoEntity> getPrescriptionsByOne(@RequestParam(value = "prescriptionName", required = true) String prescriptionName){
        return prescriptionsInfoRepository.findByprescriptionName(prescriptionName);
    }

    @RequestMapping(value = "/presctiptionsinfo/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String saveOrUpdatePrescriptions(PrescriptionsInfoEntity prescriptionsInfoEntity){
        try {
            prescriptionsInfoService.saveOrUpdatePrescriptions(prescriptionsInfoEntity);
            return "Success";
        } catch (Exception e) {
            System.out.println("错误:" + e.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/presctiptionsinfo/deletebyid/{prescriptionId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deletePatientInfo(@PathVariable Long prescriptionId) {
        prescriptionsInfoService.deletePresriptions(prescriptionId);
        return prescriptionId;
    }
}
