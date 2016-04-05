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
@Table(name = "syndrometypes")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)


public class SyndromeTypesEntity implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long syndromeId;
    private String syndromeSystemType;
    private String syndromeLevelType;
    private String syndromeName;

    public SyndromeTypesEntity(){}

    public SyndromeTypesEntity(String syndromeSystemType, String syndromeLevelType, String syndromeName) {
        this.syndromeSystemType = syndromeSystemType;
        this.syndromeLevelType = syndromeLevelType;
        this.syndromeName = syndromeName;
    }

    public long getSyndromeId() {
        return syndromeId;
    }

    public void setSyndromeId(long syndromeId) {
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


}
