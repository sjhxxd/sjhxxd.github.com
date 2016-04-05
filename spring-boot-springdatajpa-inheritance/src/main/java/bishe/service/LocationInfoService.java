package bishe.service;

import bishe.entity.LocationInfoEntity;

import java.util.List;

/**
 * Created by sjh on 16/3/30.
 */
public interface LocationInfoService {

    public List<LocationInfoEntity> getAllLocation();
    public LocationInfoEntity fingByLocationInfoId(Long locationInfoId);
    public LocationInfoEntity saveOrUpdateLocation(LocationInfoEntity locationInfoEntity);
    public LocationInfoEntity deleteLocation(Long locationInfoId);

}
