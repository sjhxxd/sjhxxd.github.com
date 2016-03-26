package bishe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by sjh on 16/3/9.
 *
 */
@NoRepositoryBean
public interface BaseRepository <T> extends CrudRepository<T,Long>{
}
