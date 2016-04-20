package bishe.implement;

import bishe.entity.PatientInfoEntity;
import bishe.entity.PictureListEntity;
import bishe.repository.PictureListRepository;
import bishe.service.PatientInfoService;
import bishe.service.PictureListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjh on 16/4/20.
 */
@Service("PictureListServiceImpl")
public class PictureListServiceImpl implements PictureListService {
    @Autowired
    private PictureListRepository pictureListRepository;

    @Override
    public List<PictureListEntity> getAllPicture() {
        return (List<PictureListEntity>) pictureListRepository.findAll();
    }

    @Override
    public PictureListEntity findByPictureLocationId(Long pictureLocationId) {
        return pictureListRepository.findOne(pictureLocationId);
    }

    @Override
    public PictureListEntity saveOrUpdatePicture(PictureListEntity pictureListEntity) {
        try {
            pictureListRepository.save(pictureListEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pictureListEntity;
    }

    @Override
    public PictureListEntity deletePicture(Long pictureLocationId) {
        pictureListRepository.delete(pictureLocationId);
        return null;
    }
}
