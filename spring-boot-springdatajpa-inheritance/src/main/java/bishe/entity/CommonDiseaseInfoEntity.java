package bishe.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.Long;


/**
 * Created by sjh on 16/4/5.
 */
@Entity
@Inheritance
@Table(name = "commondiseaseinfo")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CommonDiseaseInfoEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commonDiseaseId;
    private Long tempCommonDiseaseTypeId;
    private String commonDiseaseName;
    private String commonDiseaseCode;
    private String commonDiseaseExplain;
    private String patientNumber;

    public CommonDiseaseInfoEntity(){

    }

    public CommonDiseaseInfoEntity(Long tempCommonDiseaseTypeId, String commonDiseaseName, String commonDiseaseCode, String commonDiseaseExplain, String patientNumber) {
        this.tempCommonDiseaseTypeId = tempCommonDiseaseTypeId;
        this.commonDiseaseName = commonDiseaseName;
        this.commonDiseaseCode = commonDiseaseCode;
        this.commonDiseaseExplain = commonDiseaseExplain;
        this.patientNumber = patientNumber;
    }

    public CommonDiseaseInfoEntity(Long tempCommonDiseaseTypeId, String commonDiseaseName, String commonDiseaseCode, String commonDiseaseExplain) {
        this.tempCommonDiseaseTypeId = tempCommonDiseaseTypeId;
        this.commonDiseaseName = commonDiseaseName;
        this.commonDiseaseCode = commonDiseaseCode;
        this.commonDiseaseExplain = commonDiseaseExplain;
    }

    public CommonDiseaseInfoEntity(Long tempCommonDiseaseTypeId, String commonDiseaseName, String commonDiseaseExplain) {
        this.tempCommonDiseaseTypeId = tempCommonDiseaseTypeId;
        this.commonDiseaseName = commonDiseaseName;
        this.commonDiseaseExplain = commonDiseaseExplain;
    }

    public Long getCommonDiseaseId() {
        return commonDiseaseId;
    }

    public void setCommonDiseaseId(Long commonDiseaseId) {
        this.commonDiseaseId = commonDiseaseId;
    }

    public Long getTempCommonDiseaseTypeId() {
        return tempCommonDiseaseTypeId;
    }

    public void setTempCommonDiseaseTypeId(Long tempCommonDiseaseTypeId) {
        this.tempCommonDiseaseTypeId = tempCommonDiseaseTypeId;
    }

    public String getCommonDiseaseName() {
        return commonDiseaseName;
    }

    public void setCommonDiseaseName(String commonDiseaseName) {
        this.commonDiseaseName = commonDiseaseName;
    }

    public String getCommonDiseaseCode() {
        return commonDiseaseCode;
    }

    public void setCommonDiseaseCode(String commonDiseaseCode) {
        this.commonDiseaseCode = commonDiseaseCode;
    }

    public String getCommonDiseaseExplain() {
        return commonDiseaseExplain;
    }

    public void setCommonDiseaseExplain(String commonDiseaseExplain) {
        this.commonDiseaseExplain = commonDiseaseExplain;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }
}
