package bishe.implement;

import bishe.entity.MedPrescriptMappEntity;
import bishe.repository.MedPrescriptMappRepository;
import bishe.service.MedPrescriptMappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjh on 16/3/29.
 */
@Service("MedPrescriptMappServiceImpl")
public class MedPrescriptMappServiceImpl implements MedPrescriptMappService{
    @Autowired
    private MedPrescriptMappRepository medPrescriptMappRepository;

    @Override
    public List<MedPrescriptMappEntity> getAllMedPrescriptMapp() {
        return (List<MedPrescriptMappEntity>) medPrescriptMappRepository.findAll();
    }

    @Override
    public MedPrescriptMappEntity fingByChineseMedPrescriptMappId(Long chineseMedPrescriptMappId) {
        return medPrescriptMappRepository.findOne(chineseMedPrescriptMappId);
    }

    @Override
    public MedPrescriptMappEntity saveOrUpdateMedPrescriptMapp(MedPrescriptMappEntity medPrescriptMappEntity) {
        try {
            System.out.println(medPrescriptMappEntity.getChineseMedPrescriptMappId());
            medPrescriptMappRepository.save(medPrescriptMappEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return medPrescriptMappEntity;
    }

    @Override
    public MedPrescriptMappEntity deleteMedPrescriptMapp(Long chineseMedPrescriptMappId) {
        medPrescriptMappRepository.delete(chineseMedPrescriptMappId);
        return null;
    }
}
