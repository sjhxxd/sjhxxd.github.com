package bishe.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;
import java.lang.Long;


/**
 * Created by sjh on 16/3/28.
 */
@Entity
@Inheritance
@Table(name = "caserecord")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CaseRecordEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long caseId;
    private Long tempPatientId;
    private Long tempDoctorId;
    private Long tempDiseaseId;
    private Integer clinicalTime;
    private Date caseDate;
    private String patientTalk;
    private String medicalHistory;
    private String tempPictureLocationId;
    private String diagnosis;
    private Long tempDoctorPrescriptionId;
    private String curativeEffect;
    private String caseRemark;
    private String tipsContent;
    private Long tempSyndromeId;
    private Long tempInquiryResultId;

    public CaseRecordEntity(){
    }

    public CaseRecordEntity(Long tempPatientId, Long tempDoctorId, Long tempDiseaseId, Integer clinicalTime, Date caseDate, String patientTalk, String medicalHistory, String tempPictureLocationId, String diagnosis, Long tempDoctorPrescriptionId, String curativeEffect, String caseRemark, String tipsContent, Long tempSyndromeId, Long tempInquiryResultId) {
        this.tempPatientId = tempPatientId;
        this.tempDoctorId = tempDoctorId;
        this.tempDiseaseId = tempDiseaseId;
        this.clinicalTime = clinicalTime;
        this.caseDate = caseDate;
        this.patientTalk = patientTalk;
        this.medicalHistory = medicalHistory;
        this.tempPictureLocationId = tempPictureLocationId;
        this.diagnosis = diagnosis;
        this.tempDoctorPrescriptionId = tempDoctorPrescriptionId;
        this.curativeEffect = curativeEffect;
        this.caseRemark = caseRemark;
        this.tipsContent = tipsContent;
        this.tempSyndromeId = tempSyndromeId;
        this.tempInquiryResultId = tempInquiryResultId;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public Long getTempPatientId() {
        return tempPatientId;
    }

    public void setTempPatientId(Long tempPatientId) {
        this.tempPatientId = tempPatientId;
    }

    public Long getTempDoctorId() {
        return tempDoctorId;
    }

    public void setTempDoctorId(Long tempDoctorId) {
        this.tempDoctorId = tempDoctorId;
    }

    public Long getTempDiseaseId() {
        return tempDiseaseId;
    }

    public void setTempDiseaseId(Long tempDiseaseId) {
        this.tempDiseaseId = tempDiseaseId;
    }

    public Integer getClinicalTime() {
        return clinicalTime;
    }

    public void setClinicalTime(Integer clinicalTime) {
        this.clinicalTime = clinicalTime;
    }

    public Date getCaseDate() {
        return caseDate;
    }

    public void setCaseDate(Date caseDate) {
        this.caseDate = caseDate;
    }

    public String getPatientTalk() {
        return patientTalk;
    }

    public void setPatientTalk(String patientTalk) {
        this.patientTalk = patientTalk;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getTempPictureLocationId() {
        return tempPictureLocationId;
    }

    public void setTempPictureLocationId(String tempPictureLocationId) {
        this.tempPictureLocationId = tempPictureLocationId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Long getTempDoctorPrescriptionId() {
        return tempDoctorPrescriptionId;
    }

    public void setTempDoctorPrescriptionId(Long tempDoctorPrescriptionId) {
        this.tempDoctorPrescriptionId = tempDoctorPrescriptionId;
    }

    public String getCurativeEffect() {
        return curativeEffect;
    }

    public void setCurativeEffect(String curativeEffect) {
        this.curativeEffect = curativeEffect;
    }

    public String getCaseRemark() {
        return caseRemark;
    }

    public void setCaseRemark(String caseRemark) {
        this.caseRemark = caseRemark;
    }

    public String getTipsContent() {
        return tipsContent;
    }

    public void setTipsContent(String tipsContent) {
        this.tipsContent = tipsContent;
    }

    public Long getTempSyndromeId() {
        return tempSyndromeId;
    }

    public void setTempSyndromeId(Long tempSyndromeId) {
        this.tempSyndromeId = tempSyndromeId;
    }

    public Long getTempInquiryResultId() {
        return tempInquiryResultId;
    }

    public void setTempInquiryResultId(Long tempInquiryResultId) {
        this.tempInquiryResultId = tempInquiryResultId;
    }

}
