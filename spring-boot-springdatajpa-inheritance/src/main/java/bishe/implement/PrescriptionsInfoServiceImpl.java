package bishe.implement;

import bishe.entity.PrescriptionsInfoEntity;
import bishe.repository.PrescriptionsInfoRepository;
import bishe.service.PrescriptionsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjh on 16/3/23.
 */
@Service("PrescriptionsInfoServiceImpl")
public class PrescriptionsInfoServiceImpl implements PrescriptionsInfoService{
    @Autowired
    private PrescriptionsInfoRepository prescriptionsInfoRepository;

    @Override
    public List<PrescriptionsInfoEntity> getAllPrescriptions() {
        return (List<PrescriptionsInfoEntity>) prescriptionsInfoRepository.findAll();
    }

    @Override
    public PrescriptionsInfoEntity findByPrescriptionId(Long prescriptionId) {
        return null;
    }

    @Override
    public PrescriptionsInfoEntity saveOrUpdatePrescriptions(PrescriptionsInfoEntity prescriptionsInfoEntity) {
        try {
            System.out.println(prescriptionsInfoEntity.getPrescriptionId());
            prescriptionsInfoRepository.save(prescriptionsInfoEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return prescriptionsInfoEntity;
    }

    @Override
    public PrescriptionsInfoEntity deletePresriptions(long prescriptionId) {
        prescriptionsInfoRepository.delete(prescriptionId);
        return null;
    }
}
