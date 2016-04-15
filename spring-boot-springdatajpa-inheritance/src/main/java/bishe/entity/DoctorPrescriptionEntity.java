package bishe.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.Long;


/**
 * Created by sjh on 16/3/24.
 */
@Entity
@Inheritance
@Table(name = "doctorprescription")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DoctorPrescriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long doctorPrescriptionId;
    private String prescriptionInstructions;
    private Integer oralDoses;
    private String doctorPrescriptionRemark;
    private String prescriptionType;

    public DoctorPrescriptionEntity(){

    }

    public DoctorPrescriptionEntity(String prescriptionType, Integer oralDoses, String prescriptionInstructions, String doctorPrescriptionRemark) {
        this.prescriptionType = prescriptionType;
        this.oralDoses = oralDoses;
        this.prescriptionInstructions = prescriptionInstructions;
        this.doctorPrescriptionRemark = doctorPrescriptionRemark;
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


}
