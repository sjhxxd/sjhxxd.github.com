package bishe.service;

import bishe.entity.TbInquiryresultEntity;

import java.util.List;

/**
 * Created by sjh on 16/4/23.
 */
public interface TbInquiryresultService {
    public List<TbInquiryresultEntity> getAllInquiryResult();
    public TbInquiryresultEntity findByInquiryResultId(Long inquiryResultId);
    public TbInquiryresultEntity saveOrUpdateInquiryResult(TbInquiryresultEntity tbInquiryresultEntity);
    public TbInquiryresultEntity deleteByInquiryResultId(Long inquiryResultId);
}
