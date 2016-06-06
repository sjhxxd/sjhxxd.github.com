package bishe.entity;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.Long;
import java.sql.Date;

/**
 * Created by sjh on 16/3/24.
 */
@Entity
@Inheritance
@Table(name = "doctorprescription")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DoctorPrescriptionEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long doctorPrescriptionId;
    private String prescriptionInstructions;
    private Integer oralDoses;
    private String doctorPrescriptionRemark;
    private String prescriptionType;
    private String prescriptionName;
    private Date prescriptionDate;

    public DoctorPrescriptionEntity(){

    }

    public DoctorPrescriptionEntity(String prescriptionInstructions, Integer oralDoses, String doctorPrescriptionRemark, String prescriptionType, String prescriptionName, Date prescriptionDate) {
        this.prescriptionInstructions = prescriptionInstructions;
        this.oralDoses = oralDoses;
        this.doctorPrescriptionRemark = doctorPrescriptionRemark;
        this.prescriptionType = prescriptionType;
        this.prescriptionName = prescriptionName;
        this.prescriptionDate = prescriptionDate;
    }

    public Long getDoctorPrescriptionId() {
        return doctorPrescriptionId;
    }

    public void setDoctorPrescriptionId(Long doctorPrescriptionId) {
        this.doctorPrescriptionId = doctorPrescriptionId;
    }

    public String getPrescriptionInstructions() {
        return prescriptionInstructions;
    }

    public void setPrescriptionInstructions(String prescriptionInstructions) {
        this.prescriptionInstructions = prescriptionInstructions;
    }

    public Integer getOralDoses() {
        return oralDoses;
    }

    public void setOralDoses(Integer oralDoses) {
        this.oralDoses = oralDoses;
    }

    public String getDoctorPrescriptionRemark() {
        return doctorPrescriptionRemark;
    }

    public void setDoctorPrescriptionRemark(String doctorPrescriptionRemark) {
        this.doctorPrescriptionRemark = doctorPrescriptionRemark;
    }

    public String getPrescriptionType() {
        return prescriptionType;
    }

    public void setPrescriptionType(String prescriptionType) {
        this.prescriptionType = prescriptionType;
    }

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

    public Date getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(Date prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

}
