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
@Table(name = "chinesemedpremapp")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ChineseMedPreMappEntity implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long chineseMedPrescriptMappId;
    private Long tempChineseMedicineId;
    private Long tempDoctorPrescriptionId;
    private Long tempUnitId;
    private Integer chineseMesicineDose;
    private String decoctionMethod;

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

    public Integer getChineseMesicineDose() {
        return chineseMesicineDose;
    }

    public void setChineseMesicineDose(Integer chineseMesicineDose) {
        this.chineseMesicineDose = chineseMesicineDose;
    }

    public String getDecoctionMethod() {
        return decoctionMethod;
    }

    public void setDecoctionMethod(String decoctionMethod) {
        this.decoctionMethod = decoctionMethod;
    }


}
