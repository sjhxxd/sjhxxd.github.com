package bishe.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

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
    private long doctorPrescriptionId;
    private Long tempChineseMedicineId;
    private Integer chineseMedicineDose;
    private String prescriptionInstructions;
    private Integer oralDoses;
    private String doctorPrescriptionRemark;
    private String prescriptionType;

    public DoctorPrescriptionEntity(){

    }

    public DoctorPrescriptionEntity(Long tempChineseMedicineId, String prescriptionType, Integer oralDoses, Integer chineseMedicineDose, String prescriptionInstructions, String doctorPrescriptionRemark) {
        this.tempChineseMedicineId = tempChineseMedicineId;
        this.prescriptionType = prescriptionType;
        this.oralDoses = oralDoses;
        this.chineseMedicineDose = chineseMedicineDose;
        this.prescriptionInstructions = prescriptionInstructions;
        this.doctorPrescriptionRemark = doctorPrescriptionRemark;
    }

    public long getDoctorPrescriptionId() {
        return doctorPrescriptionId;
    }

    public void setDoctorPrescriptionId(long doctorPrescriptionId) {
        this.doctorPrescriptionId = doctorPrescriptionId;
    }

    public Long getTempChineseMedicineId() {
        return tempChineseMedicineId;
    }

    public void setTempChineseMedicineId(Long tempChineseMedicineId) {
        this.tempChineseMedicineId = tempChineseMedicineId;
    }

    public Integer getChineseMedicineDose() {
        return chineseMedicineDose;
    }

    public void setChineseMedicineDose(Integer chineseMedicineDose) {
        this.chineseMedicineDose = chineseMedicineDose;
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
