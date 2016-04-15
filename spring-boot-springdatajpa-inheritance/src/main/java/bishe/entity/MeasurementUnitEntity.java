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
@Table(name = "measurementunit")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MeasurementUnitEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long unitId;
    private String unitName;
    private Integer hexadecimal;
    private String unitRemarks;

    public MeasurementUnitEntity(){

    }

    public MeasurementUnitEntity(String unitRemarks, String unitName, Integer hexadecimal) {
        this.unitRemarks = unitRemarks;
        this.unitName = unitName;
        this.hexadecimal = hexadecimal;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getHexadecimal() {
        return hexadecimal;
    }

    public void setHexadecimal(Integer hexadecimal) {
        this.hexadecimal = hexadecimal;
    }

    public String getUnitRemarks() {
        return unitRemarks;
    }

    public void setUnitRemarks(String unitRemarks) {
        this.unitRemarks = unitRemarks;
    }

}
