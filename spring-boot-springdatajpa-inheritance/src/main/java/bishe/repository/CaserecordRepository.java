package bishe.repository;

import bishe.entity.CaseRecordEntity;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sjh on 16/3/23.
 */
@Transactional
public interface CaseRecordRepository extends BaseRepository<CaseRecordEntity>{
    //    通过病人名字查找
    public List<CaseRecordEntity> findByTempPatientId(Long tempPatientId);

    //    通过疾病查找
    public List<CaseRecordEntity> findByTempDiseaseId(Long tempDiseaseId);

    //    通过证型查找
    public List<CaseRecordEntity> findByTempSyndromeId(Long tempSyndromeId);
}
