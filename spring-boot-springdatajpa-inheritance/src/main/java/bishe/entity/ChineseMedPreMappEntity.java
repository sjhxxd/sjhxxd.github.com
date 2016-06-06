package bishe.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.Long;

/**
 * Created by sjh on 16/3/28.
 */
//中药处方映射
@Entity
@Inheritance
@Table(name = "chinesemedpremapp")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ChineseMedPreMappEntity implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long chineseMedPrescriptMappId;
    private Long tempChineseMedicineId;
    private Long tempDoctorPrescriptionId;
    private Long tempUnitId;
    private String chineseMedicineDose;
    private String decoctionMethod;
     public ChineseMedPreMappEntity(){

     }

    public ChineseMedPreMappEntity(Long tempChineseMedicineId, Long tempDoctorPrescriptionId, Long tempUnitId, String chineseMedicineDose, String decoctionMethod) {
        this.tempChineseMedicineId = tempChineseMedicineId;
        this.tempDoctorPrescriptionId = tempDoctorPrescriptionId;
        this.tempUnitId = tempUnitId;
        this.chineseMedicineDose = chineseMedicineDose;
        this.decoctionMethod = decoctionMethod;
    }

    public Long getChineseMedPrescriptMappId() {
        return chineseMedPrescriptMappId;
    }

    public void setChineseMedPrescriptMappId(Long chineseMedPrescriptMappId) {
        this.chineseMedPrescriptMappId = chineseMedPrescriptMappId;
    }

    public Long getTempChineseMedicineId() {
        return tempChineseMedicineId;
    }

    public void setTempChineseMedicineId(Long tempChineseMedicineId) {
        this.tempChineseMedicineId = tempChineseMedicineId;
    }

    public Long getTempDoctorPrescriptionId() {
        return tempDoctorPrescriptionId;
    }

    public void setTempDoctorPrescriptionId(Long tempDoctorPrescriptionId) {
        this.tempDoctorPrescriptionId = tempDoctorPrescriptionId;
    }

    public Long getTempUnitId() {
        return tempUnitId;
    }

    public void setTempUnitId(Long tempUnitId) {
        this.tempUnitId = tempUnitId;
    }

    public String getchineseMedicineDose() {
        return chineseMedicineDose;
    }

    public void setchineseMedicineDose(String chineseMedicineDose) {
        this.chineseMedicineDose = chineseMedicineDose;
    }

    public String getDecoctionMethod() {
        return decoctionMethod;
    }

    public void setDecoctionMethod(String decoctionMethod) {
        this.decoctionMethod = decoctionMethod;
    }


}
