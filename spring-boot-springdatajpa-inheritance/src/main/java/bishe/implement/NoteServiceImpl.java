package bishe.implement;

import bishe.entity.NoteEntity;
import bishe.repository.NoteRepository;
import bishe.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjh on 16/6/4.
 */
@Service("NoteServiceImpl")
public class NoteServiceImpl implements NoteService{
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<NoteEntity> getAllNote() {
        return (List<NoteEntity>) noteRepository.findAll();
    }

    @Override
    public NoteEntity saveOrUpdateNote(NoteEntity noteEntity) {
        try {
            noteRepository.save(noteEntity);
        } catch (Exception e) {
            System.out.println("笔记添或改错误:"+e.getMessage());
        }
        return noteEntity;
    }

    @Override
    public NoteEntity deleteNote(Long myNoteId) {
        noteRepository.delete(myNoteId);
        return null;
    }
}
