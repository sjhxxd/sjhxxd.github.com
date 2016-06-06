package bishe.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;

/**
 * Created by sjh on 16/6/4.
 */
@Entity
@Inheritance
@Table(name = "note")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NoteEntity implements  java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long myNoteId;
    private Long tempDoctorId;
    private Long tempNoteTypeId;
    private Date noteDate;
    private String noteContent;
    private Long tempChineseMedicineId;
    private Long tempFoodMaterialId;
    private Long tempPatentMedicineId;
    private Long tempPrescriptionId;
    private String noteRemark;

    public NoteEntity(){

    }

    public NoteEntity(Long tempDoctorId, Long tempNoteTypeId, Date noteDate, String noteContent, Long tempChineseMedicineId, Long tempFoodMaterialId, Long tempPatentMedicineId, Long tempPrescriptionId, String noteRemark) { 
        this.tempDoctorId = tempDoctorId;
        this.tempNoteTypeId = tempNoteTypeId;
        this.noteDate = noteDate;
        this.noteContent = noteContent;
        this.tempChineseMedicineId = tempChineseMedicineId;
        this.tempFoodMaterialId = tempFoodMaterialId;
        this.tempPatentMedicineId = tempPatentMedicineId;
        this.tempPrescriptionId = tempPrescriptionId;
        this.noteRemark = noteRemark;
    }

    public Long getMyNoteId() {
        return myNoteId;
    }

    public void setMyNoteId(Long myNoteId) {
        this.myNoteId = myNoteId;
    }

    public Long getTempDoctorId() {
        return tempDoctorId;
    }

    public void setTempDoctorId(Long tempDoctorId) {
        this.tempDoctorId = tempDoctorId;
    }

    public Long getTempNoteTypeId() {
        return tempNoteTypeId;
    }

    public void setTempNoteTypeId(Long tempNoteTypeId) {
        this.tempNoteTypeId = tempNoteTypeId;
    }

    public Date getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public Long getTempChineseMedicineId() {
        return tempChineseMedicineId;
    }

    public void setTempChineseMedicineId(Long tempChineseMedicineId) {
        this.tempChineseMedicineId = tempChineseMedicineId;
    }

    public Long getTempFoodMaterialId() {
        return tempFoodMaterialId;
    }

    public void setTempFoodMaterialId(Long tempFoodMaterialId) {
        this.tempFoodMaterialId = tempFoodMaterialId;
    }

    public Long getTempPatentMedicineId() {
        return tempPatentMedicineId;
    }

    public void setTempPatentMedicineId(Long tempPatentMedicineId) {
        this.tempPatentMedicineId = tempPatentMedicineId;
    }

    public Long getTempPrescriptionId() {
        return tempPrescriptionId;
    }

    public void setTempPrescriptionId(Long tempPrescriptionId) {
        this.tempPrescriptionId = tempPrescriptionId;
    }

    public String getNoteRemark() {
        return noteRemark;
    }

    public void setNoteRemark(String noteRemark) {
        this.noteRemark = noteRemark;
    }
}
