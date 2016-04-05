package bishe.implement;

import bishe.entity.SyndromeTypesEntity;
import bishe.repository.SyndromeTypesReopsitory;
import bishe.service.SyndromeTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjh on 16/3/31.
 */
@Service("SyndromeTypesServiceImpl")
public class SyndromeTypesServiceImpl implements SyndromeTypesService {
    @Autowired
    private SyndromeTypesReopsitory  syndromeTypesReopsitory;

    @Override
    public List<SyndromeTypesEntity> getAllSyndromeTypes() {
        return (List<SyndromeTypesEntity>) syndromeTypesReopsitory.findAll();
    }

    @Override
    public SyndromeTypesEntity findBySyndromeId(Long syndromeId) {
        return syndromeTypesReopsitory.findOne(syndromeId);
    }

    @Override
    public SyndromeTypesEntity saveOrUpdateSyndromeTypes(SyndromeTypesEntity syndromeTypesEntity) {
        try {
            System.out.println(syndromeTypesEntity.getSyndromeId());
            syndromeTypesReopsitory.save(syndromeTypesEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return syndromeTypesEntity;


    }

    @Override
    public SyndromeTypesEntity deleteSyndromeTypes(Long syndromeId) {
        syndromeTypesReopsitory.delete(syndromeId);
        return null;
    }
}
