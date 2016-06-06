package bishe.service;

import bishe.entity.NoteEntity;

import java.util.List;

/**
 * Created by sjh on 16/6/4.
 */
public interface NoteService {
    public List<NoteEntity> getAllNote();
    public NoteEntity saveOrUpdateNote(NoteEntity noteEntity);
    public NoteEntity deleteNote(Long myNoteId);

}
