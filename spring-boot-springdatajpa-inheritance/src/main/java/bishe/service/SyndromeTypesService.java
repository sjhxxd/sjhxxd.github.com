package bishe.service;

import bishe.entity.SyndromeTypesEntity;

import java.util.List;

/**
 * Created by sjh on 16/3/31.
 */
public interface SyndromeTypesService {
    public List<SyndromeTypesEntity> getAllSyndromeTypes();
    public SyndromeTypesEntity findBySyndromeId(Long  syndromeId);
    public SyndromeTypesEntity saveOrUpdateSyndromeTypes(SyndromeTypesEntity syndromeTypesEntity);
    public SyndromeTypesEntity deleteSyndromeTypes(Long syndromeId);
}
