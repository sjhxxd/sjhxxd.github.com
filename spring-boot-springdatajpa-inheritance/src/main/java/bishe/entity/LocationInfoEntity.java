package bishe.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.lang.Long;

/**
 * Created by sjh on 16/3/28.
 */
@Entity
@Inheritance
@Table(name = "locationinfo")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LocationInfoEntity implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationInfoId;
    private BigDecimal locationLongitude;
    private BigDecimal locationLatitude;
    private String realLocation;
    private String locationProvince;
    private String locationCity;
    private String locationClassify;
    private String locationCounty;
    private String locationRemarks;


    public LocationInfoEntity(){

    }

    public LocationInfoEntity(BigDecimal locationLongitude, BigDecimal locationLatitude, String realLocation, String locationProvince, String locationCity, String locationClassify, String locationCounty, String locationRemarks) {
        this.locationLongitude = locationLongitude;
        this.locationLatitude = locationLatitude;
        this.realLocation = realLocation;
        this.locationProvince = locationProvince;
        this.locationCity = locationCity;
        this.locationClassify = locationClassify;
        this.locationCounty = locationCounty;
        this.locationRemarks = locationRemarks;
    }

    public Long getLocationInfoId() {
        return locationInfoId;
    }

    public void setLocationInfoId(Long locationInfoId) {
        this.locationInfoId = locationInfoId;
    }

    public BigDecimal getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(BigDecimal locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public BigDecimal getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(BigDecimal locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public String getRealLocation() {
        return realLocation;
    }

    public void setRealLocation(String realLocation) {
        this.realLocation = realLocation;
    }

    public String getLocationProvince() {
        return locationProvince;
    }

    public void setLocationProvince(String locationProvince) {
        this.locationProvince = locationProvince;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationClassify() {
        return locationClassify;
    }

    public void setLocationClassify(String locationClassify) {
        this.locationClassify = locationClassify;
    }

    public String getLocationCounty() {
        return locationCounty;
    }

    public void setLocationCounty(String locationCounty) {
        this.locationCounty = locationCounty;
    }

    public String getLocationRemarks() {
        return locationRemarks;
    }

    public void setLocationRemarks(String locationRemarks) {
        this.locationRemarks = locationRemarks;
    }

}
