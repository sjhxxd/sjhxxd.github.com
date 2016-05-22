package bishe.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.Long;

/**
 * Created by sjh on 16/3/28.
 */
@Entity
@Inheritance
@Table(name = "picturelist")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PictureListEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pictureLocationId;
    private String originalPicturePath;
    private String smallPicturePath;
    private String pictureClass;
    private String pictureName;
    private String pictureTitle;
    private String pictureRemarks;
    private String folderName;

    public PictureListEntity() {

    }

    public PictureListEntity(String originalPicturePath, String smallPicturePath, String pictureClass, String pictureName, String pictureTitle, String pictureRemarks, String folderName) {
        this.originalPicturePath = originalPicturePath;
        this.smallPicturePath = smallPicturePath;
        this.pictureClass = pictureClass;
        this.pictureName = pictureName;
        this.pictureTitle = pictureTitle;
        this.pictureRemarks = pictureRemarks;
        this.folderName = folderName;
    }

    public Long getPictureLocationId() {
        return pictureLocationId;
    }

    public void setPictureLocationId(Long pictureLocationId) {
        this.pictureLocationId = pictureLocationId;
    }

    public String getOriginalPicturePath() {
        return originalPicturePath;
    }

    public void setOriginalPicturePath(String originalPicturePath) {
        this.originalPicturePath = originalPicturePath;
    }

    public String getSmallPicturePath() {
        return smallPicturePath;
    }

    public void setSmallPicturePath(String smallPicturePath) {
        this.smallPicturePath = smallPicturePath;
    }

    public String getPictureClass() {
        return pictureClass;
    }

    public void setPictureClass(String pictureClass) {
        this.pictureClass = pictureClass;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPictureTitle() {
        return pictureTitle;
    }

    public void setPictureTitle(String pictureTitle) {
        this.pictureTitle = pictureTitle;
    }

    public String getPictureRemarks() {
        return pictureRemarks;
    }

    public void setPictureRemarks(String pictureRemarks) {
        this.pictureRemarks = pictureRemarks;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

}
