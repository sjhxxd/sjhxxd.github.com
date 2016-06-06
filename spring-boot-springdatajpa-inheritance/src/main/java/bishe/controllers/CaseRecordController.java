package bishe.controllers;

import bishe.entity.CaseRecordEntity;
import bishe.entity.DoctorInfoEntity;
import bishe.repository.CaseRecordRepository;
import bishe.service.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sjh on 16/3/29.
 */
@RestController
@RequestMapping(value = "/caserecord")
public class CaseRecordController {
    @Autowired
    private CaseRecordRepository caseRecordRepository;
    @Autowired
    private CaseRecordService caseRecordService;
    @Autowired
    private PatientInfoService patientInfoService;
    @Autowired
    private DoctorInfoService doctorInfoService;
    @Autowired
    private DoctorPrescriptionService doctorPrescriptionService;
    @Autowired
    private CommonDiseaseInfoService commonDiseaseInfoService;
    @Autowired
    private SyndromeTypesService syndromeTypesService;
    @Autowired
    private TbInquiryresultService tbInquiryresultService;
    Gson gson = new Gson();


    @RequestMapping(value = "getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<HashMap<String, String>> getCaseRecordAll() {

        List<CaseRecordEntity> caseRecordEntities;
        caseRecordEntities = caseRecordService.getAllCaseRecord();
        final List<HashMap<String, String>> caseNameMap = new ArrayList<>();
        for (final CaseRecordEntity caseRecordEntity : caseRecordEntities) {
            caseNameMap.add(new HashMap<String, String>() {{
                put("caseId", caseRecordEntity.getCaseId().toString());
                put("tempPatientId", patientInfoService.findByPatientId(caseRecordEntity.getTempPatientId()).getPatientName());
                put("tempDoctorId", doctorInfoService.findByDoctorId(caseRecordEntity.getTempDoctorId()).getDoctorName());
                put("tempDiseaseId", commonDiseaseInfoService.findByCommonDiseaseId(caseRecordEntity.getTempDiseaseId()).getCommonDiseaseName());
                put("clinicalTime", caseRecordEntity.getClinicalTime().toString());
                put("caseDate", caseRecordEntity.getCaseDate().toString());
                put("patientTalk", caseRecordEntity.getPatientTalk());
                put("medicalHistory", caseRecordEntity.getMedicalHistory());
                put("tempPictureLocationId", caseRecordEntity.getTempPictureLocationId());
                put("diagnosis", caseRecordEntity.getDiagnosis());
                put("tempDoctorPrescriptionId", doctorPrescriptionService.findByDoctorPrescriptionId(caseRecordEntity.getTempDoctorPrescriptionId()).getPrescriptionName());
                put("curativeEffect", caseRecordEntity.getCurativeEffect());
                put("caseRemark", caseRecordEntity.getCaseRemark());
                put("tipsContent", caseRecordEntity.getTipsContent());
                put("tempSyndromeId", syndromeTypesService.findBySyndromeId(caseRecordEntity.getTempSyndromeId()).getSyndromeName());
                put("tempInquiryResultId", tbInquiryresultService.findByInquiryResultId(caseRecordEntity.getTempInquiryResultId()).getInquiryResult());
            }});
        }
        return caseNameMap;
    }


    @RequestMapping(value = "findbycaseid/{caseId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<HashMap<String, String>> getCaseRecordByCaseId(@PathVariable Long caseId) {
        List<CaseRecordEntity> caseRecordEntities = new ArrayList<>();
        caseRecordEntities.add(caseRecordService.findByCaseId(caseId));
        final List<HashMap<String, String>> caseNameMap = new ArrayList<>();
        for (final CaseRecordEntity caseRecordEntity : caseRecordEntities) {
            caseNameMap.add(new HashMap<String, String>() {{
                put("caseId", caseRecordEntity.getCaseId().toString());
                put("tempPatientId", patientInfoService.findByPatientId(caseRecordEntity.getTempPatientId()).getPatientName());
                put("tempDoctorId", doctorInfoService.findByDoctorId(caseRecordEntity.getTempDoctorId()).getDoctorName());
                put("tempDiseaseId", commonDiseaseInfoService.findByCommonDiseaseId(caseRecordEntity.getTempDiseaseId()).getCommonDiseaseName());
                put("clinicalTime", caseRecordEntity.getClinicalTime().toString());
                put("caseDate", caseRecordEntity.getCaseDate().toString());
                put("patientTalk", caseRecordEntity.getPatientTalk());
                put("medicalHistory", caseRecordEntity.getMedicalHistory());
                put("tempPictureLocationId", caseRecordEntity.getTempPictureLocationId());
                put("diagnosis", caseRecordEntity.getDiagnosis());
                put("tempDoctorPrescriptionId", doctorPrescriptionService.findByDoctorPrescriptionId(caseRecordEntity.getTempDoctorPrescriptionId()).getPrescriptionName());
                put("curativeEffect", caseRecordEntity.getCurativeEffect());
                put("caseRemark", caseRecordEntity.getCaseRemark());
                put("tipsContent", caseRecordEntity.getTipsContent());
                put("tempSyndromeId", syndromeTypesService.findBySyndromeId(caseRecordEntity.getTempSyndromeId()).getSyndromeName());
                put("tempInquiryResultId", tbInquiryresultService.findByInquiryResultId(caseRecordEntity.getTempInquiryResultId()).getInquiryResult());
            }});
        }
        return caseNameMap;
    }

    //    通过病人Id查找还是病人名字?
    @RequestMapping(value = "findbytemppatientid/{tempPatientId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<HashMap<String, String>> getCaseRecordByTempPatientId(@PathVariable Long tempPatientId) {
        List<CaseRecordEntity> caseRecordEntities ;
        caseRecordEntities = caseRecordRepository.findByTempPatientId(tempPatientId);
        final List<HashMap<String, String>> caseNameMap = new ArrayList<>();
        for (final CaseRecordEntity caseRecordEntity : caseRecordEntities) {
            caseNameMap.add(new HashMap<String, String>() {{
                put("caseId", caseRecordEntity.getCaseId().toString());
                put("tempPatientId", patientInfoService.findByPatientId(caseRecordEntity.getTempPatientId()).getPatientName());
                put("tempDoctorId", doctorInfoService.findByDoctorId(caseRecordEntity.getTempDoctorId()).getDoctorName());
                put("tempDiseaseId", commonDiseaseInfoService.findByCommonDiseaseId(caseRecordEntity.getTempDiseaseId()).getCommonDiseaseName());
                put("clinicalTime", caseRecordEntity.getClinicalTime().toString());
                put("caseDate", caseRecordEntity.getCaseDate().toString());
                put("patientTalk", caseRecordEntity.getPatientTalk());
                put("medicalHistory", caseRecordEntity.getMedicalHistory());
                put("tempPictureLocationId", caseRecordEntity.getTempPictureLocationId());
                put("diagnosis", caseRecordEntity.getDiagnosis());
                put("tempDoctorPrescriptionId", doctorPrescriptionService.findByDoctorPrescriptionId(caseRecordEntity.getTempDoctorPrescriptionId()).getPrescriptionName());
                put("curativeEffect", caseRecordEntity.getCurativeEffect());
                put("caseRemark", caseRecordEntity.getCaseRemark());
                put("tipsContent", caseRecordEntity.getTipsContent());
                put("tempSyndromeId", syndromeTypesService.findBySyndromeId(caseRecordEntity.getTempSyndromeId()).getSyndromeName());
                put("tempInquiryResultId", tbInquiryresultService.findByInquiryResultId(caseRecordEntity.getTempInquiryResultId()).getInquiryResult());
            }});
        }
        return caseNameMap;
    }

    @RequestMapping(value = "findbytempdiseaseid/{tempDiseaseId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CaseRecordEntity> getCaseRecordByTempDiseaseId(@PathVariable Long tempDiseaseId) {
        return caseRecordRepository.findByTempDiseaseId(tempDiseaseId);
    }

    @RequestMapping(value = "findbytempSyndromeId/{tempSyndromeId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CaseRecordEntity> getCaseRecordByTempSyndromeId(@PathVariable Long tempSyndromeId) {
        return caseRecordRepository.findByTempSyndromeId(tempSyndromeId);
    }


    @RequestMapping(value = "saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String saveOrUpdateCaseRecord(CaseRecordEntity caseRecordEntity, @RequestBody String requestBody) {
        try {
            if (requestBody.substring(0, 1).equals("[")) {
                System.out.println("Android Input case");
                CaseRecordEntity caseRecordEntity1 = gson.fromJson(requestBody.substring(1, requestBody.length() - 1), CaseRecordEntity.class);
                caseRecordService.saveOrUpdateCaseRecord(caseRecordEntity1);
                System.out.println("Case_ID-->" + caseRecordEntity1.getCaseId());
                System.out.println("Case_patientName-->" + caseRecordEntity1.getTempPatientId());
                return "Success";
            }
            caseRecordService.saveOrUpdateCaseRecord(caseRecordEntity);
            return "Success";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "deletebyid/{caseId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteCaseRecord(@PathVariable Long caseId) {
        caseRecordService.deleteCaseRecord(caseId);
        return caseId;
    }


}
