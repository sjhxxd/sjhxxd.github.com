package bishe.controllers;

import bishe.entity.DoctorPrescriptionEntity;
import bishe.repository.DoctorPrescriptionRepository;
import bishe.service.DoctorPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by sjh on 16/3/27.
 */
@RestController
@RequestMapping(value="/doctorprescription")
public class DoctorPrescriptionController {
    @Autowired
    private DoctorPrescriptionRepository doctorPrescriptionRepository;
    @Autowired
    private DoctorPrescriptionService doctorPrescriptionService;

    @RequestMapping(value = "getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<DoctorPrescriptionEntity> getDoctorPrescriptionAll() {
        return doctorPrescriptionService.getAllDoctorPrescription();
    }

    @RequestMapping(value = "findbyid/{doctorPrescriptionId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DoctorPrescriptionEntity getPatientById(@PathVariable Long doctorPrescriptionId) {
        return doctorPrescriptionService.findByDoctorPrescriptionId(doctorPrescriptionId);
    }

    @RequestMapping(value = "findbyname", params = "prescriptionName", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<DoctorPrescriptionEntity> getPatientByName(@RequestParam(value = "prescriptionName", required = true) String prescriptionName) {
        try {
            return doctorPrescriptionRepository.findByPrescriptionName(prescriptionName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return doctorPrescriptionRepository.findByPrescriptionName(prescriptionName);
        }
    }

    @RequestMapping(value = "saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String saveOrUpdateDoctorPrescription(DoctorPrescriptionEntity doctorPrescriptionEntity) {
        try {
            doctorPrescriptionService.saveOrUpdateDoctorPrescription(doctorPrescriptionEntity);
            return "Success";
        } catch (Exception e) {
            System.out.println("错误:" + e.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "deletebyid/{doctorPrescriptionId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteDoctorPrescription(@PathVariable Long doctorPrescriptionId) {
        doctorPrescriptionService.deleteDoctorPrescription(doctorPrescriptionId);
        return doctorPrescriptionId;
    }
}
