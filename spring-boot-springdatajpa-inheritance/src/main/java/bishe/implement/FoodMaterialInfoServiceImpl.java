package bishe.implement;

import bishe.entity.FoodMaterialInfoEntity;
import bishe.repository.FoodMaterialInfoRepository;
import bishe.service.FoodMaterialInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjh on 16/3/24.
 */
@Service("FoodMaterialInfoServiceImpl")
public class FoodMaterialInfoServiceImpl implements FoodMaterialInfoService{

    @Autowired
    private FoodMaterialInfoRepository foodMaterialInfoRepository;

    @Override
    public List<FoodMaterialInfoEntity> getAllFood() {
        return (List<FoodMaterialInfoEntity>) foodMaterialInfoRepository.findAll();
    }

    @Override
    public FoodMaterialInfoEntity delateFood(Long foodMaterialId) {
        foodMaterialInfoRepository.delete(foodMaterialId);

        return null;
    }

    @Override
    public FoodMaterialInfoEntity findByFoodMaterialId(Long foodMaterialId) {
        return foodMaterialInfoRepository.findOne(foodMaterialId);
    }

    @Override
    public FoodMaterialInfoEntity saveOrUpdateFood(FoodMaterialInfoEntity foodMaterialInfoEntity) {
        try {
            System.out.println(foodMaterialInfoEntity.getFoodMaterialId());
            foodMaterialInfoRepository.save(foodMaterialInfoEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return foodMaterialInfoEntity;
    }
}
