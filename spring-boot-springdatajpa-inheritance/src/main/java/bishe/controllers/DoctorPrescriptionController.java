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
public class DoctorPrescriptionController {
    @Autowired
    private DoctorPrescriptionRepository doctorPrescriptionRepository;
    @Autowired
    private DoctorPrescriptionService doctorPrescriptionService;

    @RequestMapping(value = "/doctorpresctiption/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<DoctorPrescriptionEntity> getDoctorPrescriptionAll(){
        return doctorPrescriptionService.getAllDoctorPrescription();
    }

    @RequestMapping(value = "/doctorpresctiption/findbyid/{doctorPrescriptionId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DoctorPrescriptionEntity getPatientById(@PathVariable Long doctorPrescriptionId){
        return doctorPrescriptionService.findByDoctorPrescriptionId(doctorPrescriptionId);

    }

    @RequestMapping(value = "/doctorpresctiption/saveorupdate", method = {RequestMethod.POST, RequestMethod.GET}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void saveOrUpdateDoctorPrescription(DoctorPrescriptionEntity doctorPrescriptionEntity){
        doctorPrescriptionService.saveOrUpdateDoctorPrescription(doctorPrescriptionEntity);
    }

    @RequestMapping(value = "/doctorpresctiption/deletebyid/{doctorPrescriptionId}", method = {RequestMethod.POST, RequestMethod.GET}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteDoctorPrescription(@PathVariable Long doctorPrescriptionId){
        doctorPrescriptionService.deleteDoctorPrescription(doctorPrescriptionId);
        return doctorPrescriptionId;
    }
}
