package bishe.implement;

import bishe.entity.TbInquiryissuessEntity;
import bishe.repository.TbInquiryissuessRepository;
import bishe.service.TbInquiryissuessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjh on 16/4/21.
 */
@Service("TbInquiryissuessServiceImpl")
public class TbInquiryissuessServiceImpl implements TbInquiryissuessService{
    @Autowired
    private TbInquiryissuessRepository tbInquiryissuessRepository;

    @Override
    public List<TbInquiryissuessEntity> getAllInquiryissuess() {
        return (List<TbInquiryissuessEntity>) tbInquiryissuessRepository.findAll();
    }

    @Override
    public TbInquiryissuessEntity findbyInquiryQuestionId(Long inquiryQuestionId) {
        return tbInquiryissuessRepository.findOne(inquiryQuestionId);
    }

    @Override
    public TbInquiryissuessEntity saveOrUpdateTbInquiryissuess(TbInquiryissuessEntity tbInquiryissuessEntity) {
        try {
            tbInquiryissuessRepository.save(tbInquiryissuessEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tbInquiryissuessEntity;
    }

    @Override
    public TbInquiryissuessEntity deleteByInquiryQuestionId(Long inquiryQuestionId) {
        tbInquiryissuessRepository.delete(inquiryQuestionId);
        return null;
    }
}
