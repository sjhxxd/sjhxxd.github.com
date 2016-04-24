package bishe.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;
import java.lang.Long;


@Entity
@Inheritance
@Table(name = "tb_inquiryresult")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TbInquiryresultEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inquiryResultId;
    private Long tempPatientId;
    private Date inquiryDate;
    private String inquiryRemarks;
    private String inquiryResult;
    private Long inquiryFlag;

    public Long getInquiryResultId() {
        return inquiryResultId;
    }

    public void setInquiryResultId(Long inquiryResultId) {
        this.inquiryResultId = inquiryResultId;
    }

    public Long getTempPatientId() {
        return tempPatientId;
    }

    public void setTempPatientId(Long tempPatientId) {
        this.tempPatientId = tempPatientId;
    }

    public Date getInquiryDate() {
        return inquiryDate;
    }

    public void setInquiryDate(Date inquiryDate) {
        this.inquiryDate = inquiryDate;
    }

    public String getInquiryRemarks() {
        return inquiryRemarks;
    }

    public void setInquiryRemarks(String inquiryRemarks) {
        this.inquiryRemarks = inquiryRemarks;
    }

    public String getInquiryResult() {
        return inquiryResult;
    }

    public void setInquiryResult(String inquiryResult) {
        this.inquiryResult = inquiryResult;
    }

    public Long getInquiryFlag() {
        return inquiryFlag;
    }

    public void setInquiryFlag(Long inquiryFlag) {
        this.inquiryFlag = inquiryFlag;
    }

}
