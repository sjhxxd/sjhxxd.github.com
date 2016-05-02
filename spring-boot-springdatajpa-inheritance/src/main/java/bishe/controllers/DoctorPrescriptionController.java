package bishe.controllers;

import bishe.entity.DoctorPrescriptionEntity;
import bishe.repository.DoctorPrescriptionRepository;
import bishe.service.DoctorPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by sjh on 16/3/27.
 */
@RestController
public class DoctorPrescriptionController {
    @Autowired
    private DoctorPrescriptionRepository doctorPrescriptionRepository;
    @Autowired
    private DoctorPrescriptionService doctorPrescriptionService;

    @RequestMapping(value = "/doctorprescription/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<DoctorPrescriptionEntity> getDoctorPrescriptionAll() {
        return doctorPrescriptionService.getAllDoctorPrescription();
    }

    @RequestMapping(value = "/doctorpresctiption/findbyid/{doctorPrescriptionId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DoctorPrescriptionEntity getPatientById(@PathVariable Long doctorPrescriptionId) {
        return doctorPrescriptionService.findByDoctorPrescriptionId(doctorPrescriptionId);
    }

    @RequestMapping(value = "/doctorpresctiption/findbyname", params = "prescriptionName", method = RequestMethod.GET, produces = {"application/json"})
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

    @RequestMapping(value = "/doctorpresctiption/saveorupdate", params = "timeFormat", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void saveOrUpdateDoctorPrescription(DoctorPrescriptionEntity doctorPrescriptionEntity,
                                               @RequestParam(value = "timeFormat", required = true)  String timeFormat) {
        try {
            Timestamp timeStamp = Timestamp.valueOf(timeFormat + ":00");
            doctorPrescriptionEntity.setPrescriptionDate(timeStamp);
            doctorPrescriptionService.saveOrUpdateDoctorPrescription(doctorPrescriptionEntity);
        } catch (Exception e) {
            System.out.println("time——error" + e.getMessage());
        }
    }

    @RequestMapping(value = "/doctorpresctiption/deletebyid/{doctorPrescriptionId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteDoctorPrescription(@PathVariable Long doctorPrescriptionId) {
        doctorPrescriptionService.deleteDoctorPrescription(doctorPrescriptionId);
        return doctorPrescriptionId;
    }
}
