package bishe.repository;

import bishe.entity.TbInquiryresultEntity;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sjh on 16/4/23.
 */
@Transactional
public interface TbInquiryresultReopository extends BaseRepository<TbInquiryresultEntity>{
    public List<TbInquiryresultEntity> findByInquiryResult(String inquiryResult);
}
