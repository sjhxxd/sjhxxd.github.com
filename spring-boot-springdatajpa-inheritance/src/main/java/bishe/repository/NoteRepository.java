package bishe.repository;

import bishe.entity.NoteEntity;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sjh on 16/6/4.
 */
@Transactional
public interface NoteRepository extends BaseRepository<NoteEntity>{
    public List<NoteEntity> findByTempChineseMedicineId(Long tempChineseMedicineId);

    public List<NoteEntity> findByTempFoodMaterialId(Long tempFoodMaterialId);

    public List<NoteEntity> findByTempPatentMedicineId(Long tempPatentMedicineId);

    public List<NoteEntity> findByTempPrescriptionId(Long tempPrescriptionId);


}
