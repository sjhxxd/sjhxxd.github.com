package bishe.repository;

import bishe.entity.SyndromeTypesEntity;

import java.util.List;

/**
 * Created by sjh on 16/3/31.
 */
public interface SyndromeTypesReopsitory extends BaseRepository<SyndromeTypesEntity>{
    public List<SyndromeTypesEntity> findBySyndromeName(String syndromeName);
}
