package bishe.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sjh on 16/3/28.
 */
@Entity
@Inheritance
@Table(name = "medprescriptmapp")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MedPrescriptMappEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long chineseMedPrescriptMappId;
    private Long tempChineseMedicineId;
    private Long tempPrescriptionId;
    private String medicineAmount;
    private Long tempUnitId;
    private String decoctionMethod;
    private String medPrescriptMappRemarks;

    public MedPrescriptMappEntity(){

    }

    public MedPrescriptMappEntity(Long tempChineseMedicineId, Long tempPrescriptionId, String medicineAmount, Long tempUnitId, String decoctionMethod, String medPrescriptMappRemarks) {
        this.tempChineseMedicineId = tempChineseMedicineId;
        this.tempPrescriptionId = tempPrescriptionId;
        this.medicineAmount = medicineAmount;
        this.tempUnitId = tempUnitId;
        this.decoctionMethod = decoctionMethod;
        this.medPrescriptMappRemarks = medPrescriptMappRemarks;
    }

    public long getChineseMedPrescriptMappId() {
        return chineseMedPrescriptMappId;
    }

    public void setChineseMedPrescriptMappId(long chineseMedPrescriptMappId) {
        this.chineseMedPrescriptMappId = chineseMedPrescriptMappId;
    }

    public Long getTempChineseMedicineId() {
        return tempChineseMedicineId;
    }

    public void setTempChineseMedicineId(Long tempChineseMedicineId) {
        this.tempChineseMedicineId = tempChineseMedicineId;
    }

    public Long getTempPrescriptionId() {
        return tempPrescriptionId;
    }

    public void setTempPrescriptionId(Long tempPrescriptionId) {
        this.tempPrescriptionId = tempPrescriptionId;
    }

    public String getMedicineAmount() {
        return medicineAmount;
    }

    public void setMedicineAmount(String medicineAmount) {
        this.medicineAmount = medicineAmount;
    }

    public Long getTempUnitId() {
        return tempUnitId;
    }

    public void setTempUnitId(Long tempUnitId) {
        this.tempUnitId = tempUnitId;
    }

    public String getDecoctionMethod() {
        return decoctionMethod;
    }

    public void setDecoctionMethod(String decoctionMethod) {
        this.decoctionMethod = decoctionMethod;
    }

    public String getMedPrescriptMappRemarks() {
        return medPrescriptMappRemarks;
    }

    public void setMedPrescriptMappRemarks(String medPrescriptMappRemarks) {
        this.medPrescriptMappRemarks = medPrescriptMappRemarks;
    }
}
