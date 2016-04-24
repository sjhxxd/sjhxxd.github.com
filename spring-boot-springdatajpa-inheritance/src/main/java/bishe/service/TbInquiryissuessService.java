package bishe.service;

import bishe.entity.TbInquiryissuessEntity;

import java.util.List;

/**
 * Created by sjh on 16/4/21.
 */
public interface TbInquiryissuessService {
    public List<TbInquiryissuessEntity> getAllInquiryissuess();
    public TbInquiryissuessEntity findbyInquiryQuestionId(Long inquiryQuestionId);
    public TbInquiryissuessEntity saveOrUpdateTbInquiryissuess(TbInquiryissuessEntity tbInquiryissuessEntity);
    public TbInquiryissuessEntity deleteByInquiryQuestionId(Long inquiryQuestionId);

}
