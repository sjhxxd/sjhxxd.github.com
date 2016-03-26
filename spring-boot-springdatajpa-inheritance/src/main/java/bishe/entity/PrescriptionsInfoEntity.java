package bishe.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sjh on 16/3/23.
 */
@Entity
@Inheritance
@Table(name="prescriptinfo")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PrescriptionsInfoEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long prescriptionId;
    private String prescriptionName;
    private String prescriptionOrigin;
    private String prescriptionEffect;
    private String prescriptionClass;
    private String prescriptionFunction;
    private String prescriptionSummary;
    private String prescriptionInstructions;
    private String prescriptionRemark;

    public PrescriptionsInfoEntity() {
    }

    public PrescriptionsInfoEntity(String prescriptionName, String prescriptionOrigin, String prescriptionEffect, String prescriptionClass, String prescriptionFunction, String prescriptionSummary, String prescriptionInstructions, String prescriptionRemark) {
        this.prescriptionName = prescriptionName;
        this.prescriptionOrigin = prescriptionOrigin;
        this.prescriptionEffect = prescriptionEffect;
        this.prescriptionClass = prescriptionClass;
        this.prescriptionFunction = prescriptionFunction;
        this.prescriptionSummary = prescriptionSummary;
        this.prescriptionInstructions = prescriptionInstructions;
        this.prescriptionRemark = prescriptionRemark;
    }

    public long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

    public String getPrescriptionOrigin() {
        return prescriptionOrigin;
    }

    public void setPrescriptionOrigin(String prescriptionOrigin) {
        this.prescriptionOrigin = prescriptionOrigin;
    }

    public String getPrescriptionEffect() {
        return prescriptionEffect;
    }

    public void setPrescriptionEffect(String prescriptionEffect) {
        this.prescriptionEffect = prescriptionEffect;
    }

    public String getPrescriptionClass() {
        return prescriptionClass;
    }

    public void setPrescriptionClass(String prescriptionClass) {
        this.prescriptionClass = prescriptionClass;
    }

    public String getPrescriptionFunction() {
        return prescriptionFunction;
    }

    public void setPrescriptionFunction(String prescriptionFunction) {
        this.prescriptionFunction = prescriptionFunction;
    }

    public String getPrescriptionSummary() {
        return prescriptionSummary;
    }

    public void setPrescriptionSummary(String prescriptionSummary) {
        this.prescriptionSummary = prescriptionSummary;
    }

    public String getPrescriptionInstructions() {
        return prescriptionInstructions;
    }

    public void setPrescriptionInstructions(String prescriptionInstructions) {
        this.prescriptionInstructions = prescriptionInstructions;
    }

    public String getPrescriptionRemark() {
        return prescriptionRemark;
    }

    public void setPrescriptionRemark(String prescriptionRemark) {
        this.prescriptionRemark = prescriptionRemark;
    }



}
