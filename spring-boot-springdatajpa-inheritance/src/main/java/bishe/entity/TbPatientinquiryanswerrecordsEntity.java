package bishe.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Inheritance
@Table(name = "tb_patientinquiryanswerrecords")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TbPatientinquiryanswerrecordsEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long answerRecordsId;
    private Long tempInquiryQuestionId;
    private Long tempPatientId;
    private String inquiryQuestionAnswer;

    public Long getAnswerRecordsId() {
        return answerRecordsId;
    }

    public void setAnswerRecordsId(Long answerRecordsId) {
        this.answerRecordsId = answerRecordsId;
    }

    public Long getTempInquiryQuestionId() {
        return tempInquiryQuestionId;
    }

    public void setTempInquiryQuestionId(Long tempInquiryQuestionId) {
        this.tempInquiryQuestionId = tempInquiryQuestionId;
    }

    public Long getTempPatientId() {
        return tempPatientId;
    }

    public void setTempPatientId(Long tempPatientId) {
        this.tempPatientId = tempPatientId;
    }

    public String getInquiryQuestionAnswer() {
        return inquiryQuestionAnswer;
    }

    public void setInquiryQuestionAnswer(String inquiryQuestionAnswer) {
        this.inquiryQuestionAnswer = inquiryQuestionAnswer;
    }

}
