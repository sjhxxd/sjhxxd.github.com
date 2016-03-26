package bishe.repository;

import bishe.entity.FoodMaterialInfoEntity;

import javax.transaction.Transactional;

/**
 * Created by sjh on 16/3/23.
 */
@Transactional
public interface FoodMaterialInfoRepository extends BaseRepository<FoodMaterialInfoEntity>{
    public FoodMaterialInfoEntity findByFoodMaterialName(String foodMaterialName);
}
