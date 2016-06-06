package bishe.repository;

import bishe.entity.NoteEntity;

import javax.transaction.Transactional;

/**
 * Created by sjh on 16/6/4.
 */
@Transactional
public interface NoteRepository extends BaseRepository<NoteEntity>{

}
