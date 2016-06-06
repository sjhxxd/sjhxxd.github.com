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
@Table(name = "commondiseasetype")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CommonDiseaseTypeEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commonDiseaseTypeId;
    private String commonDiseaseTypeName;
    private String commonDiseaseTypeCode;
    private String commonDiseaseTypeExplain;

    public CommonDiseaseTypeEntity(){

    }

    public CommonDiseaseTypeEntity(String commonDiseaseTypeName, String commonDiseaseTypeCode, String commonDiseaseTypeExplain) {
        this.commonDiseaseTypeName = commonDiseaseTypeName;
        this.commonDiseaseTypeCode = commonDiseaseTypeCode;
        this.commonDiseaseTypeExplain = commonDiseaseTypeExplain;
    }

    public Long getCommonDiseaseTypeId() {
        return commonDiseaseTypeId;
    }

    public void setCommonDiseaseTypeId(Long commonDiseaseTypeId) {
        this.commonDiseaseTypeId = commonDiseaseTypeId;
    }

    public String getCommonDiseaseTypeName() {
        return commonDiseaseTypeName;
    }

    public void setCommonDiseaseTypeName(String commonDiseaseTypeName) {
        this.commonDiseaseTypeName = commonDiseaseTypeName;
    }

    public String getCommonDiseaseTypeCode() {
        return commonDiseaseTypeCode;
    }

    public void setCommonDiseaseTypeCode(String commonDiseaseTypeCode) {
        this.commonDiseaseTypeCode = commonDiseaseTypeCode;
    }

    public String getCommonDiseaseTypeExplain() {
        return commonDiseaseTypeExplain;
    }

    public void setCommonDiseaseTypeExplain(String commonDiseaseTypeExplain) {
        this.commonDiseaseTypeExplain = commonDiseaseTypeExplain;
    }
}
