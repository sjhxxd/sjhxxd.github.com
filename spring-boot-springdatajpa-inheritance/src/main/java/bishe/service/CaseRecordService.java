package bishe.service;

import bishe.entity.CaseRecordEntity;

import java.util.List;

/**
 * Created by sjh on 16/3/29.
 */
public interface CaseRecordService {
    public List<CaseRecordEntity> getAllCaseRecord();
    public CaseRecordEntity findByCaseId(Long caseId);
    public CaseRecordEntity saveOrUpdateCaseRecord(CaseRecordEntity caseRecordEntity);
    public CaseRecordEntity deleteCaseRecord(Long caseId);
}
