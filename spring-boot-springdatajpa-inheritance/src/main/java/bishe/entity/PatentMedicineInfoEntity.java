package bishe.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sjh on 16/3/26.
 */
@Entity
@Inheritance
@Table(name = "patentmedicineinfo")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PatentMedicineInfoEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long patentMedicineId;
    private String patentMedicineName;
    private String patentMedicineContent;
    private String indicationsFunction;
    private String shape;
    private String usageDosage;
    private String attention;
    private String specifications;
    private String storageMethod;
    private String saute;
    private String patentMedicineRemark;

    public PatentMedicineInfoEntity(){

    }

    public PatentMedicineInfoEntity(String patentMedicineName, String patentMedicineContent, String indicationsFunction, String shape, String usageDosage, String attention, String specifications, String storageMethod, String saute, String patentMedicineRemark) {
        this.patentMedicineName = patentMedicineName;
        this.patentMedicineContent = patentMedicineContent;
        this.indicationsFunction = indicationsFunction;
        this.shape = shape;
        this.usageDosage = usageDosage;
        this.attention = attention;
        this.specifications = specifications;
        this.storageMethod = storageMethod;
        this.saute = saute;
        this.patentMedicineRemark = patentMedicineRemark;
    }

    public long getPatentMedicineId() {
        return patentMedicineId;
    }

    public void setPatentMedicineId(long patentMedicineId) {
        this.patentMedicineId = patentMedicineId;
    }

    public String getPatentMedicineName() {
        return patentMedicineName;
    }

    public void setPatentMedicineName(String patentMedicineName) {
        this.patentMedicineName = patentMedicineName;
    }

    public String getPatentMedicineContent() {
        return patentMedicineContent;
    }

    public void setPatentMedicineContent(String patentMedicineContent) {
        this.patentMedicineContent = patentMedicineContent;
    }

    public String getIndicationsFunction() {
        return indicationsFunction;
    }

    public void setIndicationsFunction(String indicationsFunction) {
        this.indicationsFunction = indicationsFunction;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getUsageDosage() {
        return usageDosage;
    }

    public void setUsageDosage(String usageDosage) {
        this.usageDosage = usageDosage;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getStorageMethod() {
        return storageMethod;
    }

    public void setStorageMethod(String storageMethod) {
        this.storageMethod = storageMethod;
    }

    public String getSaute() {
        return saute;
    }

    public void setSaute(String saute) {
        this.saute = saute;
    }

    public String getPatentMedicineRemark() {
        return patentMedicineRemark;
    }

    public void setPatentMedicineRemark(String patentMedicineRemark) {
        this.patentMedicineRemark = patentMedicineRemark;
    }
}
