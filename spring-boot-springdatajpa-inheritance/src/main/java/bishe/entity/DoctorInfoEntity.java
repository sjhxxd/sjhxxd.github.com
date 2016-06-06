package bishe.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.Long;

@Entity
@Inheritance
@Table(name = "doctorinfo")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DoctorInfoEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long doctorId;
    private String doctorName;
    private String doctorSex;
    private Integer doctorAge;
    private String doctorPhoneNumber;
    private String doctorUnitName;
    private String doctorDepartmentName;
    private String doctorIdentity;
    private String doctorPassword;
    private String doctorAddress;
    private Integer checkState;
    private String doctorRemark;
    private String doctorWechat;
    private String doctorIntroduction;
    private String tempPictureLocationId;

    public DoctorInfoEntity() {

    }

    public DoctorInfoEntity(String doctorName, String doctorSex, Integer doctorAge, String doctorPhoneNumber, String doctorUnitName, String doctorDepartmentName, String doctorIdentity, String doctorPassword, String doctorAddress, Integer checkState, String doctorRemark, String doctorWechat, String doctorIntroduction, String tempPictureLocationId) {
        this.doctorName = doctorName;
        this.doctorSex = doctorSex;
        this.doctorAge = doctorAge;
        this.doctorPhoneNumber = doctorPhoneNumber;
        this.doctorUnitName = doctorUnitName;
        this.doctorDepartmentName = doctorDepartmentName;
        this.doctorIdentity = doctorIdentity;
        this.doctorPassword = doctorPassword;
        this.doctorAddress = doctorAddress;
        this.checkState = checkState;
        this.doctorRemark = doctorRemark;
        this.doctorWechat = doctorWechat;
        this.doctorIntroduction = doctorIntroduction;
        this.tempPictureLocationId = tempPictureLocationId;
    }

    public DoctorInfoEntity(String doctorName, String doctorSex, Integer doctorAge, String doctorPhoneNumber, String doctorUnitName, String doctorDepartmentName, String doctorIdentity, String doctorPassword, String doctorAddress, Integer checkState, String doctorRemark) {
        this.doctorName = doctorName;
        this.doctorSex = doctorSex;
        this.doctorAge = doctorAge;
        this.doctorPhoneNumber = doctorPhoneNumber;
        this.doctorUnitName = doctorUnitName;
        this.doctorDepartmentName = doctorDepartmentName;
        this.doctorIdentity = doctorIdentity;
        this.doctorPassword = doctorPassword;
        this.doctorAddress = doctorAddress;
        this.checkState = checkState;
        this.doctorRemark = doctorRemark;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }


    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSex() {
        return doctorSex;
    }

    public void setDoctorSex(String doctorSex) {
        this.doctorSex = doctorSex;
    }


    public Integer getDoctorAge() {
        return doctorAge;
    }

    public void setDoctorAge(Integer doctorAge) {
        this.doctorAge = doctorAge;
    }


    public String getDoctorPhoneNumber() {
        return doctorPhoneNumber;
    }

    public void setDoctorPhoneNumber(String doctorPhoneNumber) {
        this.doctorPhoneNumber = doctorPhoneNumber;
    }


    public String getDoctorUnitName() {
        return doctorUnitName;
    }

    public void setDoctorUnitName(String doctorUnitName) {
        this.doctorUnitName = doctorUnitName;
    }


    public String getDoctorDepartmentName() {
        return doctorDepartmentName;
    }

    public void setDoctorDepartmentName(String doctorDepartmentName) {
        this.doctorDepartmentName = doctorDepartmentName;
    }

    public String getDoctorIdentity() {
        return doctorIdentity;
    }

    public void setDoctorIdentity(String doctorIdentity) {
        this.doctorIdentity = doctorIdentity;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public void setDoctorPassword(String password) {
        this.doctorPassword = password;
    }


    public String getDoctorAddress() {
        return doctorAddress;
    }

    public void setDoctorAddress(String doctorAddress) {
        this.doctorAddress = doctorAddress;
    }


    public Integer getCheckState() {
        return checkState;
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
    }

    public String getDoctorRemark() {
        return doctorRemark;
    }

    public void setDoctorRemark(String doctorRemark) {
        this.doctorRemark = doctorRemark;
    }

    public String getDoctorWechat() {
        return doctorWechat;
    }

    public void setDoctorWechat(String doctorWechat) {
        this.doctorWechat = doctorWechat;
    }

    public String getDoctorIntroduction() {
        return doctorIntroduction;
    }

    public void setDoctorIntroduction(String doctorIntroduction) {
        this.doctorIntroduction = doctorIntroduction;
    }

    public String getTempPictureLocationId() {
        return tempPictureLocationId;
    }

    public void setTempPictureLocationId(String tempPictureLocationId) {
        this.tempPictureLocationId = tempPictureLocationId;
    }


}
