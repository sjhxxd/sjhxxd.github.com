package bishe.implement;

import bishe.entity.LocationInfoEntity;
import bishe.repository.LocationInfoRepository;
import bishe.service.LocationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjh on 16/3/30.
 */
@Service("LocationInfoServiceImpl")
public class LocationInfoServiceImpl  implements LocationInfoService{
    @Autowired
    private LocationInfoRepository locationInfoRepository;

    @Override
    public List<LocationInfoEntity> getAllLocation() {
        return (List<LocationInfoEntity>) locationInfoRepository.findAll();
    }

    @Override
    public LocationInfoEntity fingByLocationInfoId(Long locationInfoId) {
        return locationInfoRepository.findOne(locationInfoId);
    }

    @Override
    public LocationInfoEntity saveOrUpdateLocation(LocationInfoEntity locationInfoEntity) {
        try {
            System.out.println(locationInfoEntity.getLocationInfoId());
            locationInfoRepository.save(locationInfoEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return locationInfoEntity;
    }

    @Override
    public LocationInfoEntity deleteLocation(Long locationInfoId) {
        locationInfoRepository.delete(locationInfoId);
        return null;
    }
}
