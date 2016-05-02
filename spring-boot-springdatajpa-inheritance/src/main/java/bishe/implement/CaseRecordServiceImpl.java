package bishe.implement;

import bishe.entity.CaseRecordEntity;
import bishe.repository.CaseRecordRepository;
import bishe.service.CaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjh on 16/3/29.
 */
@Service("CaseRecordServiceImpl")
public class CaseRecordServiceImpl implements CaseRecordService {
    @Autowired
    private CaseRecordRepository caseRecordRepository;

    @Override
    public List<CaseRecordEntity> getAllCaseRecord() {
        return (List<CaseRecordEntity>) caseRecordRepository.findAll();
    }

    @Override
    public CaseRecordEntity findByTempPatientId(Long tempPatientId) {
        return caseRecordRepository.findOne(tempPatientId);
    }

    @Override
    public CaseRecordEntity findBytempDiseaseId(Long tempDiseaseId) {
//        return (List<CaseRecordEntity>) caseRecordRepository.findAll(tempDiseaseId);
        return caseRecordRepository.findOne(tempDiseaseId);
    }

    @Override
    public CaseRecordEntity saveOrUpdateCaseRecord(CaseRecordEntity caseRecordEntity) {
        try {
            System.out.println(caseRecordEntity.getCaseId());
            caseRecordRepository.save(caseRecordEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return caseRecordEntity;
    }

    @Override
    public CaseRecordEntity deleteCaseRecord(Long caseId) {
        caseRecordRepository.delete(caseId);
        return null;
    }
}
