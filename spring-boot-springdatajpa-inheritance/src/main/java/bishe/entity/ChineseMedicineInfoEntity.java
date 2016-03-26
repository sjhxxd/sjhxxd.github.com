package bishe.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sjh on 16/3/22.
 */
@Entity
@Inheritance
@Table(name = "chinesemedicineinfo")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ChineseMedicineInfoEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long chineseMedicineId;
    private String medicineName;
    private String medicineProperty;
    private String medicineTaste;
    private String effectType;
    private String medicineGrade;
    private String channelTropism;
    private String indicationsFunction;
    private String clinicalApplication;
    private Long tempPictureLocationId;
    private String chineseMedicineRemark;
    private String anotherName;

    public ChineseMedicineInfoEntity(){

    }

    public ChineseMedicineInfoEntity(String medicineName, String medicineProperty, String medicineTaste, String effectType, String medicineGrade, String channelTropism, String indicationsFunction, String clinicalApplication, Long tempPictureLocationId, String chineseMedicineRemark, String anotherName) {
        this.medicineName = medicineName;
        this.medicineProperty = medicineProperty;
        this.medicineTaste = medicineTaste;
        this.effectType = effectType;
        this.medicineGrade = medicineGrade;
        this.channelTropism = channelTropism;
        this.indicationsFunction = indicationsFunction;
        this.clinicalApplication = clinicalApplication;
        this.tempPictureLocationId = tempPictureLocationId;
        this.chineseMedicineRemark = chineseMedicineRemark;
        this.anotherName = anotherName;
    }

    public long getChineseMedicineId() {
        return chineseMedicineId;
    }

    public void setChineseMedicineId(long chineseMedicineId) {
        this.chineseMedicineId = chineseMedicineId;
    }


    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }


    public String getMedicineProperty() {
        return medicineProperty;
    }

    public void setMedicineProperty(String medicineProperty) {
        this.medicineProperty = medicineProperty;
    }


    public String getMedicineTaste() {
        return medicineTaste;
    }

    public void setMedicineTaste(String medicineTaste) {
        this.medicineTaste = medicineTaste;
    }

    public String getEffectType() {
        return effectType;
    }

    public void setEffectType(String effectType) {
        this.effectType = effectType;
    }

    public String getMedicineGrade() {
        return medicineGrade;
    }

    public void setMedicineGrade(String medicineGrade) {
        this.medicineGrade = medicineGrade;
    }

    public String getChannelTropism() {
        return channelTropism;
    }

    public void setChannelTropism(String channelTropism) {
        this.channelTropism = channelTropism;
    }

    public String getIndicationsFunction() {
        return indicationsFunction;
    }

    public void setIndicationsFunction(String indicationsFunction) {
        this.indicationsFunction = indicationsFunction;
    }

    public String getClinicalApplication() {
        return clinicalApplication;
    }

    public void setClinicalApplication(String clinicalApplication) {
        this.clinicalApplication = clinicalApplication;
    }

    public Long getTempPictureLocationId() {
        return tempPictureLocationId;
    }

    public void setTempPictureLocationId(Long tempPictureLocationId) {
        this.tempPictureLocationId = tempPictureLocationId;
    }

    public String getChineseMedicineRemark() {
        return chineseMedicineRemark;
    }

    public void setChineseMedicineRemark(String chineseMedicineRemark) {
        this.chineseMedicineRemark = chineseMedicineRemark;
    }

    public String getAnotherName() {
        return anotherName;
    }

    public void setAnotherName(String anotherName) {
        this.anotherName = anotherName;
    }

}
