package bishe.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.Long;


@Entity
@Inheritance
@Table(name = "tb_inquiryissuess")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TbInquiryissuessEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inquiryQuestionId;
    private String inquiryQuestionContent;
    private String inquiryQuestionRemarks;

    public Long getInquiryQuestionId() {
        return inquiryQuestionId;
    }

    public void setInquiryQuestionId(Long inquiryQuestionId) {
        this.inquiryQuestionId = inquiryQuestionId;
    }

    public String getInquiryQuestionContent() {
        return inquiryQuestionContent;
    }

    public void setInquiryQuestionContent(String inquiryQuestionContent) {
        this.inquiryQuestionContent = inquiryQuestionContent;
    }

    public String getInquiryQuestionRemarks() {
        return inquiryQuestionRemarks;
    }

    public void setInquiryQuestionRemarks(String inquiryQuestionRemarks) {
        this.inquiryQuestionRemarks = inquiryQuestionRemarks;
    }
}
