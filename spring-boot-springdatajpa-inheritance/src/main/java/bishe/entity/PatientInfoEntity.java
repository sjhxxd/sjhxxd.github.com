package bishe.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sjh on 16/3/7.
 */
@Entity
@Inheritance
@Table(name = "patientinfo")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PatientInfoEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long patientId;
    private String patientName;
    private String patientSex;
    private Integer patientAge;
    private String patientPhoneNumber;
    private Integer patientHeight;
    private Double patientWeight;
    private String patientProfessional;
    private String patientAddress;
    private String patientRemark;

    public PatientInfoEntity() {
    }

    public PatientInfoEntity(String patientSex, String patientName, Integer patientAge, String patientPhoneNumber, Integer patientHeight, String patientProfessional, Double patientWeight, String patientAddress, String patientRemark) {
        this.patientSex = patientSex;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientPhoneNumber = patientPhoneNumber;
        this.patientHeight = patientHeight;
        this.patientProfessional = patientProfessional;
        this.patientWeight = patientWeight;
        this.patientAddress = patientAddress;
        this.patientRemark = patientRemark;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        PatientInfoEntity that = (PatientInfoEntity) o;
//
//        if (patientId != that.patientId) return false;
//        if (patientName != null ? !patientName.equals(that.patientName) : that.patientName != null) return false;
//        if (patientSex != null ? !patientSex.equals(that.patientSex) : that.patientSex != null) return false;
//        if (patientAge != null ? !patientAge.equals(that.patientAge) : that.patientAge != null) return false;
//        if (patientPhoneNumber != null ? !patientPhoneNumber.equals(that.patientPhoneNumber) : that.patientPhoneNumber != null)
//            return false;
//        if (patientHeight != null ? !patientHeight.equals(that.patientHeight) : that.patientHeight != null)
//            return false;
//        if (patientWeight != null ? !patientWeight.equals(that.patientWeight) : that.patientWeight != null)
//            return false;
//        if (patientProfessional != null ? !patientProfessional.equals(that.patientProfessional) : that.patientProfessional != null)
//            return false;
//        if (patientAddress != null ? !patientAddress.equals(that.patientAddress) : that.patientAddress != null)
//            return false;
//        if (patientRemark != null ? !patientRemark.equals(that.patientRemark) : that.patientRemark != null)
//            return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = patientId;
//        result = 31 * result + (patientName != null ? patientName.hashCode() : 0);
//        result = 31 * result + (patientSex != null ? patientSex.hashCode() : 0);
//        result = 31 * result + (patientAge != null ? patientAge.hashCode() : 0);
//        result = 31 * result + (patientPhoneNumber != null ? patientPhoneNumber.hashCode() : 0);
//        result = 31 * result + (patientHeight != null ? patientHeight.hashCode() : 0);
//        result = 31 * result + (patientWeight != null ? patientWeight.hashCode() : 0);
//        result = 31 * result + (patientProfessional != null ? patientProfessional.hashCode() : 0);
//        result = 31 * result + (patientAddress != null ? patientAddress.hashCode() : 0);
//        result = 31 * result + (patientRemark != null ? patientRemark.hashCode() : 0);
//        return result;
//    }
}
