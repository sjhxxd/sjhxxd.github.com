package bishe.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.Long;


@Entity
@Inheritance
@Table(name = "patientinfo")
public class PatientInfoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long patientId;
    private String patientName;
    private String patientSex;
    private Integer patientAge;
    private String patientPhoneNumber;
    private String patientIdentityCard;
    private Integer patientHeight;
    private Double patientWeight;
    private String patientPosture;
    private String patientProfessional;
    private String patientAddress;
    private String patientRemark;

    public PatientInfoEntity() {
    }

    public PatientInfoEntity(String patientName, String patientSex, Integer patientAge, String patientPhoneNumber, String patientIdentityCard, Integer patientHeight, Double patientWeight, String patientPosture, String patientProfessional, String patientAddress, String patientRemark) {
        this.patientName = patientName;
        this.patientSex = patientSex;
        this.patientAge = patientAge;
        this.patientPhoneNumber = patientPhoneNumber;
        this.patientIdentityCard = patientIdentityCard;
        this.patientHeight = patientHeight;
        this.patientWeight = patientWeight;
        this.patientPosture = patientPosture;
        this.patientProfessional = patientProfessional;
        this.patientAddress = patientAddress;
        this.patientRemark = patientRemark;
    }

    public PatientInfoEntity(String patientName, String patientSex, Integer patientAge, String patientPhoneNumber, Integer patientHeight, Double patientWeight, String patientProfessional, String patientAddress, String patientRemark) {
        this.patientName = patientName;
        this.patientSex = patientSex;
        this.patientAge = patientAge;
        this.patientPhoneNumber = patientPhoneNumber;
        this.patientHeight = patientHeight;
        this.patientWeight = patientWeight;
        this.patientProfessional = patientProfessional;
        this.patientAddress = patientAddress;
        this.patientRemark = patientRemark;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }


    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }


    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }


    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }

    public String getPatientIdentityCard() {
        return patientIdentityCard;
    }

    public void setPatientIdentityCard(String patientIdentityCard) {
        this.patientIdentityCard = patientIdentityCard;
    }

    public Integer getPatientHeight() {
        return patientHeight;
    }

    public void setPatientHeight(Integer patientHeight) {
        this.patientHeight = patientHeight;
    }

    public Double getPatientWeight() {
        return patientWeight;
    }

    public void setPatientWeight(Double patientWeight) {
        this.patientWeight = patientWeight;
    }

    public String getPatientPosture() {
        return patientPosture;
    }

    public void setPatientPosture(String patientPosture) {
        this.patientPosture = patientPosture;
    }

    public String getPatientProfessional() {
        return patientProfessional;
    }

    public void setPatientProfessional(String patientProfessional) {
        this.patientProfessional = patientProfessional;
    }


    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }


    public String getPatientRemark() {
        return patientRemark;
    }

    public void setPatientRemark(String patientRemark) {
        this.patientRemark = patientRemark;
    }

}
