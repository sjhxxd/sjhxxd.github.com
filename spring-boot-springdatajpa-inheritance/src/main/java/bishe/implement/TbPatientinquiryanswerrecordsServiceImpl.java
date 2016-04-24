package bishe.implement;

import bishe.entity.TbPatientinquiryanswerrecordsEntity;
import bishe.repository.TbPatientinquiryanswerrecordsRepository;
import bishe.service.TbPatientinquiryanswerrecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by sjh on 16/4/24.
 */
@Service("TbPatientinquiryanswerrecordsServiceImpl")
public class TbPatientinquiryanswerrecordsServiceImpl implements TbPatientinquiryanswerrecordsService{
    @Autowired
    private TbPatientinquiryanswerrecordsRepository tbPatientinquiryanswerrecordsRepository;

    @Override
    public List<TbPatientinquiryanswerrecordsEntity> getAllInquiryAnswerRecords() {
        return (List<TbPatientinquiryanswerrecordsEntity>) tbPatientinquiryanswerrecordsRepository.findAll();
    }

    @Override
    public TbPatientinquiryanswerrecordsEntity findByAnswerRecordsId(Long answerRecordsId) {
        return tbPatientinquiryanswerrecordsRepository.findOne(answerRecordsId);
    }

    @Override
    public TbPatientinquiryanswerrecordsEntity saveOrUpdateAnswerRecords(TbPatientinquiryanswerrecordsEntity tbPatientinquiryanswerrecordsEntity) {
        try {
            tbPatientinquiryanswerrecordsRepository.save(tbPatientinquiryanswerrecordsEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tbPatientinquiryanswerrecordsEntity;
    }

    @Override
    public TbPatientinquiryanswerrecordsEntity deleteAnswerRecords(Long answerRecordsId) {
        tbPatientinquiryanswerrecordsRepository.delete(answerRecordsId);
        return null;
    }
}
