package bishe.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sjh on 16/4/5.
 */
@Entity
@Inheritance
@Table(name = "commonsiseasetype")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CommonDiseaseTypeEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long commonDiseaseTypeId;
    private String commonDiseaseTypeName;
    private Integer commonDiseaseTypeCode;
    private String commonDiseaseTypeExplain;

    public CommonDiseaseTypeEntity(){

    }

    public CommonDiseaseTypeEntity(String commonDiseaseTypeName, Integer commonDiseaseTypeCode, String commonDiseaseTypeExplain) {
        this.commonDiseaseTypeName = commonDiseaseTypeName;
        this.commonDiseaseTypeCode = commonDiseaseTypeCode;
        this.commonDiseaseTypeExplain = commonDiseaseTypeExplain;
    }

    public long getCommonDiseaseTypeId() {
        return commonDiseaseTypeId;
    }

    public void setCommonDiseaseTypeId(long commonDiseaseTypeId) {
        this.commonDiseaseTypeId = commonDiseaseTypeId;
    }

    public String getCommonDiseaseTypeName() {
        return commonDiseaseTypeName;
    }

    public void setCommonDiseaseTypeName(String commonDiseaseTypeName) {
        this.commonDiseaseTypeName = commonDiseaseTypeName;
    }

    public Integer getCommonDiseaseTypeCode() {
        return commonDiseaseTypeCode;
    }

    public void setCommonDiseaseTypeCode(Integer commonDiseaseTypeCode) {
        this.commonDiseaseTypeCode = commonDiseaseTypeCode;
    }

    public String getCommonDiseaseTypeExplain() {
        return commonDiseaseTypeExplain;
    }

    public void setCommonDiseaseTypeExplain(String commonDiseaseTypeExplain) {
        this.commonDiseaseTypeExplain = commonDiseaseTypeExplain;
    }
}
