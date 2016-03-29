package bishe.service;

import bishe.entity.CaseRecordEntity;

import java.util.List;

/**
 * Created by sjh on 16/3/29.
 */
public interface CaseRecordService {
    public List<CaseRecordEntity> getAllCaseRecord();

//    通过病人名字查找
    public CaseRecordEntity findByTempPatientId(Long tempPatientId);


//    通过疾病查找
    public CaseRecordEntity findBytempDiseaseId(Long tempDiseaseId);

//    通过证型查找

    public CaseRecordEntity saveOrUpdateCaseRecord(CaseRecordEntity caseRecordEntity);


    public CaseRecordEntity deleteCaseRecord(Long caseId);
}
