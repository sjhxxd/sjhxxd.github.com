package bishe.implement;

import bishe.entity.TbInquiryresultEntity;
import bishe.repository.TbInquiryresultReopository;
import bishe.service.TbInquiryresultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjh on 16/4/23.
 */
@Service("TbInquiryresultServiceImpl")
public class TbInquiryresultServiceImpl implements TbInquiryresultService{
    @Autowired
    private TbInquiryresultReopository tbInquiryresultReopository;

    @Override
    public List<TbInquiryresultEntity> getAllInquiryResult() {
        return (List<TbInquiryresultEntity>) tbInquiryresultReopository.findAll();
    }

    @Override
    public TbInquiryresultEntity findByInquiryResultId(Long inquiryResultId) {
        return tbInquiryresultReopository.findOne(inquiryResultId );
    }

    @Override
    public TbInquiryresultEntity saveOrUpdateInquiryResult(TbInquiryresultEntity tbInquiryresultEntity) {
        try {
            tbInquiryresultReopository.save(tbInquiryresultEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tbInquiryresultEntity;
    }

    @Override
    public TbInquiryresultEntity deleteByInquiryResultId(Long inquiryResultId) {
        tbInquiryresultReopository.delete(inquiryResultId);
        return null;
    }
}
