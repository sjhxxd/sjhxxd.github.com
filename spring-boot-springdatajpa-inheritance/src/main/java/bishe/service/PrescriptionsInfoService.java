package bishe.service;

import bishe.entity.PrescriptionsInfoEntity;

import java.util.List;

/**
 * Created by sjh on 16/3/23.
 */
public interface PrescriptionsInfoService {
    public List<PrescriptionsInfoEntity> getAllPrescriptions();
    public PrescriptionsInfoEntity findByPrescriptionId(Long prescriptionId);
    public PrescriptionsInfoEntity saveOrUpdatePrescriptions(PrescriptionsInfoEntity prescriptionsInfoEntity);
    public PrescriptionsInfoEntity deletePresriptions(Long prescriptionId);
}

