package bishe.service;

import bishe.entity.PictureListEntity;

import java.util.List;

/**
 * Created by sjh on 16/4/20.
 */
public interface PictureListService {
    public List<PictureListEntity> getAllPicture();
    public PictureListEntity findByPictureLocationId(Long pictureLocationId);
    public PictureListEntity saveOrUpdatePicture(PictureListEntity pictureListEntity);
    public PictureListEntity deletePicture(Long pictureLocationId);

}
