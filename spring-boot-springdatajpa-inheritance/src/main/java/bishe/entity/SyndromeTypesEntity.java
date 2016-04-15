package bishe.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.Long;

/**
 * Created by sjh on 16/3/28.
 */

@Entity
@Inheritance
@Table(name = "syndrometypes")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)


public class SyndromeTypesEntity implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long syndromeId;
    private String syndromeSystemType;
    private String syndromeLevelType;
    private String syndromeName;
    private String syndromeRemark;

    public SyndromeTypesEntity() {
    }

    public SyndromeTypesEntity(String syndromeSystemType, String syndromeLevelType, String syndromeName, String syndromeRemark) {
        this.syndromeSystemType = syndromeSystemType;
        this.syndromeLevelType = syndromeLevelType;
        this.syndromeName = syndromeName;
        this.syndromeRemark = syndromeRemark;
    }

    public Long getSyndromeId() {
        return syndromeId;
    }

    public void setSyndromeId(Long syndromeId) {
        this.syndromeId = syndromeId;
    }

    public String getSyndromeSystemType() {
        return syndromeSystemType;
    }

    public void setSyndromeSystemType(String syndromeSystemType) {
        this.syndromeSystemType = syndromeSystemType;
    }

    public String getSyndromeLevelType() {
        return syndromeLevelType;
    }

    public void setSyndromeLevelType(String syndromeLevelType) {
        this.syndromeLevelType = syndromeLevelType;
    }

    public String getSyndromeName() {
        return syndromeName;
    }

    public void setSyndromeName(String syndromeName) {
        this.syndromeName = syndromeName;
    }

    public String getSyndromeRemark() {
        return syndromeRemark;
    }

    public void setSyndromeRemark(String syndromeRemark) {
        this.syndromeRemark = syndromeRemark;
    }


}
