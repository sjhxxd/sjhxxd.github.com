package bishe.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.Long;


/**
 * Created by sjh on 16/3/24.
 */
@Entity
@Inheritance
@Table(name = "foodmaterialinfo")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FoodMaterialInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long foodMaterialId;
    private String foodMaterialName;
    private String foodMaterialProperty;
    private String foodMaterialTaste;
    private String foodMaterialContent;
    private Long tempPictureLocationId;
    private String foodMaterialRemark;
    private String foodMaterialEffect;

    public FoodMaterialInfoEntity() {

    }

    public FoodMaterialInfoEntity(String foodMaterialName, String foodMaterialProperty, String foodMaterialTaste, String foodMaterialContent, Long tempPictureLocationId, String foodMaterialRemark, String foodMaterialEffect) {
        this.foodMaterialName = foodMaterialName;
        this.foodMaterialProperty = foodMaterialProperty;
        this.foodMaterialTaste = foodMaterialTaste;
        this.foodMaterialContent = foodMaterialContent;
        this.tempPictureLocationId = tempPictureLocationId;
        this.foodMaterialRemark = foodMaterialRemark;
        this.foodMaterialEffect = foodMaterialEffect;
    }

    public Long getFoodMaterialId() {
        return foodMaterialId;
    }

    public void setFoodMaterialId(Long foodMaterialId) {
        this.foodMaterialId = foodMaterialId;
    }

    public String getFoodMaterialName() {
        return foodMaterialName;
    }

    public void setFoodMaterialName(String foodMaterialName) {
        this.foodMaterialName = foodMaterialName;
    }

    public String getFoodMaterialProperty() {
        return foodMaterialProperty;
    }

    public void setFoodMaterialProperty(String foodMaterialProperty) {
        this.foodMaterialProperty = foodMaterialProperty;
    }

    public String getFoodMaterialTaste() {
        return foodMaterialTaste;
    }

    public void setFoodMaterialTaste(String foodMaterialTaste) {
        this.foodMaterialTaste = foodMaterialTaste;
    }

    public String getFoodMaterialContent() {
        return foodMaterialContent;
    }

    public void setFoodMaterialContent(String foodMaterialContent) {
        this.foodMaterialContent = foodMaterialContent;
    }

    public Long getTempPictureLocationId() {
        return tempPictureLocationId;
    }

    public void setTempPictureLocationId(Long tempPictureLocationId) {
        this.tempPictureLocationId = tempPictureLocationId;
    }

    public String getFoodMaterialRemark() {
        return foodMaterialRemark;
    }

    public void setFoodMaterialRemark(String foodMaterialRemark) {
        this.foodMaterialRemark = foodMaterialRemark;
    }

    public String getFoodMaterialEffect() {
        return foodMaterialEffect;
    }

    public void setFoodMaterialEffect(String foodMaterialEffect) {
        this.foodMaterialEffect = foodMaterialEffect;
    }

}
