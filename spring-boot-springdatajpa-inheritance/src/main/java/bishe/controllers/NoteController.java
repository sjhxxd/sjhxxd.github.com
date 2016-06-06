package bishe.controllers;

import bishe.entity.NoteEntity;
import bishe.repository.NoteRepository;
import bishe.service.NoteService;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sjh on 16/6/4.
 */
@RestController
@RequestMapping(value = "/note")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private NoteRepository noteRepository;
    Gson gson = new Gson();

    @RequestMapping(value = "getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<NoteEntity> getCaseRecordAll() {
        return noteService.getAllNote();
    }


    @RequestMapping(value = "findbytempchinesemedicineid/{tempChineseMedicineId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<NoteEntity> getNoteByTempChineseMedicineId(@PathVariable Long tempChineseMedicineId) {
        return noteRepository.findByTempChineseMedicineId(tempChineseMedicineId);
    }

    @RequestMapping(value = "findbytempfoodmaterialid/{tempFoodMaterialId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<NoteEntity> getNoteByTempFoodMaterialId(@PathVariable Long tempFoodMaterialId) {
        return noteRepository.findByTempFoodMaterialId(tempFoodMaterialId);
    }

    @RequestMapping(value = "findbytemppatentmedicineid/{tempPatentMedicineId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<NoteEntity> getNoteByTempPatentMedicineId(@PathVariable Long tempPatentMedicineId) {
        return noteRepository.findByTempPatentMedicineId(tempPatentMedicineId);
    }

    @RequestMapping(value = "findbytempprescriptionid/{tempPrescriptionId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<NoteEntity> getNoteByTempPrescriptionId(@PathVariable Long tempPrescriptionId) {
        return noteRepository.findByTempPrescriptionId(tempPrescriptionId);
    }

    @RequestMapping(value = "saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String saveOrUpdateNote(NoteEntity noteEntity, @RequestBody String requestBody) {
        try {
            if (requestBody.substring(0, 1).equals("[")) {
                NoteEntity noteEntity1 = gson.fromJson(requestBody.substring(1, requestBody.length() - 1), NoteEntity.class);
                noteService.saveOrUpdateNote(noteEntity1);
                return "Success";
            }
            noteService.saveOrUpdateNote(noteEntity);
            return "Success";
        } catch (JsonSyntaxException e) {
            System.out.println("错误:" + e.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "deletebyid/{myNoteId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteNote(@PathVariable Long myNoteId) {
        noteService.deleteNote(myNoteId);
        return myNoteId;
    }

}
