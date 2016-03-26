package bishe.service;

import bishe.entity.FoodMaterialInfoEntity;

import java.util.List;

/**
 * Created by sjh on 16/3/24.
 */
public interface FoodMaterialInfoService {
    public List<FoodMaterialInfoEntity> getAllFood();
    public FoodMaterialInfoEntity findByFoodMaterialId(Long foodMaterialId);
    public FoodMaterialInfoEntity saveOrUpdateFood(FoodMaterialInfoEntity foodMaterialInfoEntity);
    public FoodMaterialInfoEntity delateFood(Long foodMaterialId);
}
