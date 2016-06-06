package bishe.repository;

import bishe.entity.PictureListEntity;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sjh on 16/4/20.
 */
@Transactional
public interface PictureListRepository extends BaseRepository<PictureListEntity> {
    public PictureListEntity findByPictureName(String pictureName);
    public List<PictureListEntity> findByPictureClass(String pictureClass);
}
