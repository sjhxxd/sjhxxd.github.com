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
    private long syndromeTypeId;
    private String syndromeTypeName;
    private String dialecticalMethod;

    public SyndromeTypesEntity(){}

    public SyndromeTypesEntity(String syndromeTypeName, String dialecticalMethod) {
        this.syndromeTypeName = syndromeTypeName;
        this.dialecticalMethod = dialecticalMethod;
    }

    public long getSyndromeTypeId() {
        return syndromeTypeId;
    }

    public void setSyndromeTypeId(long syndromeTypeId) {
        this.syndromeTypeId = syndromeTypeId;
    }

    public String getSyndromeTypeName() {
        return syndromeTypeName;
    }

    public void setSyndromeTypeName(String syndromeTypeName) {
        this.syndromeTypeName = syndromeTypeName;
    }

    public String getDialecticalMethod() {
        return dialecticalMethod;
    }

    public void setDialecticalMethod(String dialecticalMethod) {
        this.dialecticalMethod = dialecticalMethod;
    }

}
