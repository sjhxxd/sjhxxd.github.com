package bishe.service;

import bishe.entity.TbPatientinquiryanswerrecordsEntity;

import java.util.List;

/**
 * Created by sjh on 16/4/24.
 */
public interface TbPatientinquiryanswerrecordsService {
    public List<TbPatientinquiryanswerrecordsEntity> getAllInquiryAnswerRecords();
    public TbPatientinquiryanswerrecordsEntity findByAnswerRecordsId(Long answerRecordsId);
    public TbPatientinquiryanswerrecordsEntity saveOrUpdateAnswerRecords(TbPatientinquiryanswerrecordsEntity tbPatientinquiryanswerrecordsEntity);
    public TbPatientinquiryanswerrecordsEntity deleteAnswerRecords(Long answerRecordsId);
}
