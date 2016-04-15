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
    private String commonDiseaseExplain;

    public CommonDiseaseInfoEntity(){

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

    public String getCommonDiseaseExplain() {
        return commonDiseaseExplain;
    }

    public void setCommonDiseaseExplain(String commonDiseaseExplain) {
        this.commonDiseaseExplain = commonDiseaseExplain;
    }
}
