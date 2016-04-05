package bishe.repository;

import bishe.entity.SyndromeTypesEntity;

/**
 * Created by sjh on 16/3/31.
 */
public interface SyndromeTypesReopsitory extends BaseRepository<SyndromeTypesEntity>{
    public SyndromeTypesEntity findBySyndromeName(String syndromeName);
}
