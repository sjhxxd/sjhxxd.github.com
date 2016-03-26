/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/3/4 14:58:21                            */
/*=============
/*==============================================================*/
/* Table: CaseRecord                                            */
/*==============================================================*/
create table CaseRecord
(
   CaseID               int not null auto_increment,
   temp_PatientID       int,
   temp_DoctorID        int,
   temp_DiseaseID       int,
   ClinicalTime         int,
   CaseDate             date,
   PatientTalk          varchar(1024),
   MedicalHistory       varchar(1024),
   temp_PictureLocationID int,
   Diagnosis            varchar(1024),
   temp_DoctorPrescriptionID int,
   CurativeEffect       varchar(200),
   CaseRemark           varchar(1024),
   TipsContent          varchar(1024),
   primary key (CaseID)
);

/*==============================================================*/
/* Table: ChineseMedPreMapp                                     */
/*==============================================================*/
create table ChineseMedPreMapp
(
   ChineseMedPreMappID  int not null auto_increment,
   temp_ChineseMedicineID int,
   temp_DoctorPrescriptionID int,
   temp_UnitID          int,
   ChineseMesicineDose  int,
   DecoctionMethod      varchar(1024),
   primary key (ChineseMedPreMappID)
);

/*==============================================================*/
/* Table: ChineseMedicineInfo                                   */
/*==============================================================*/
create table ChineseMedicineInfo
(
   ChineseMedicineID    int not null auto_increment,
   MedicineName         varchar(200),
   MedicineProperty     varchar(200),
   MedicineTaste        varchar(200),
   EffectType           varchar(200),
   MedicineGrade        varchar(200),
   ChannelTropism       varchar(200),
   IndicationsFunction  varchar(1024),
   ClinicalApplication  varchar(1024),
   temp_PictureLocationID int,
   ChineseMedicineRemark varchar(1024),
   AnotherName          varchar(200),
   primary key (ChineseMedicineID)
);

/*==============================================================*/
/* Table: ChineseMedicineNote                                   */
/*==============================================================*/
create table ChineseMedicineNote
(
   ChineseMedicineNoteID int not null auto_increment,
   temp_DoctorID        int,
   temp_ChineseMedicineID int,
   NoteDate             date,
   NoteRemark           varchar(1024),
   NoteContent          varchar(1024),
   primary key (ChineseMedicineNoteID)
);

/*==============================================================*/
/* Table: CommonDiseaseInfo                                     */
/*==============================================================*/
create table CommonDiseaseInfo
(
   CommonDiseaseID      int not null auto_increment,
   temp_CommonDiseaseTypeID int,
   CommonDiseaseName    varchar(200),
   CommonDiseaseExplain varchar(1024),
   primary key (CommonDiseaseID)
);

/*==============================================================*/
/* Table: CommonDiseaseType                                     */
/*==============================================================*/
create table CommonDiseaseType
(
   CommonDiseaseTypeID  int not null auto_increment,
   CommonDiseaseTypeName varbinary(200),
   CommonDiseaseTypeCode int,
   CommonDiseaseTypeExplain varbinary(1024),
   primary key (CommonDiseaseTypeID)
);

/*==============================================================*/
/* Table: DoctorInfo                                            */
/*==============================================================*/
create table DoctorInfo
(
   DoctorID             int not null auto_increment,
   DoctorName           varchar(50),
   DoctorSex            varchar(2),
   DoctorAge            int,
   DoctorPhoneNumber    varchar(20),
   DoctorUnitName       varchar(50),
   DoctorDepartmentName varchar(50),
   DoctorIdentity       varchar(50),
   Password             varchar(32),
   DoctorAddress        varchar(50),
   CheckState           int,
   DoctorRemark         varchar(1024),
   primary key (DoctorID)
);

/*==============================================================*/
/* Table: DoctorPrescription                                    */
/*==============================================================*/
create table DoctorPrescription
(
   DoctorPrescriptionID int not null auto_increment,
   temp_ChineseMedicineID int,
   ChineseMedicineDose  int,
   PrescriptionInstructions varchar(1024),
   OralDoses            int,
   DoctorPrescriptionRemark varchar(1024),
   PrescriptionType     varchar(200),
   primary key (DoctorPrescriptionID)
);

/*==============================================================*/
/* Table: FoodMaterialInfo                                      */
/*==============================================================*/
create table FoodMaterialInfo
(
   FoodMaterialID       int not null auto_increment,
   FoodMaterialName     varchar(200),
   FoodMaterialProperty varchar(200),
   FoodMaterialTaste    varchar(200),
   FoodMaterialContent  varchar(1024),
   temp_PictureLocationID int,
   FoodMaterialRemark   varchar(1024),
   FoodMaterialEffect   varchar(200),
   primary key (FoodMaterialID)
);

/*==============================================================*/
/* Table: FoodMaterialNote                                      */
/*==============================================================*/
create table FoodMaterialNote
(
   FoodMaterialNoteID   int not null auto_increment,
   temp_DoctorID        int,
   temp_FoodMaterialID  int,
   NoteDate             date,
   NoteRemark           varchar(1024),
   NoteContent          varchar(1024),
   primary key (FoodMaterialNoteID)
);

/*==============================================================*/
/* Table: LocationInfo                                          */
/*==============================================================*/
create table LocationInfo
(
   LocationInfoID       int not null auto_increment,
   LocationLongitude    decimal(8,2),
   LocationLatitude     decimal(8,2),
   RealLocation         varchar(200),
   LocationProvince     varchar(200),
   LocationCity         varchar(200),
   LocationClassify     varchar(200),
   LocationCounty       varchar(200),
   LocationRemarks      varchar(1024),
   primary key (LocationInfoID)
);

/*==============================================================*/
/* Table: MeasurementUnit                                       */
/*==============================================================*/
create table MeasurementUnit
(
   UnitID               int not null auto_increment,
   UnitName             varchar(200),
   Hexadecimal          int,
   UnitRemarks          varchar(1024),
   primary key (UnitID)
);

/*==============================================================*/
/* Table: MedPrescriptMapp                                      */
/*==============================================================*/
create table MedPrescriptMapp
(
   MedPrescriptMappID   int not null auto_increment,
   temp_ChineseMedicineID int,
   temp_PrescriptionID  int,
   MedicineAmount       varchar(1024),
   temp_UnitID          int,
   DecoctionMethod      varchar(1024),
   MedPrescriptMappRemarks varchar(1024),
   primary key (MedPrescriptMappID)
);

/*==============================================================*/
/* Table: Note                                                  */
/*==============================================================*/
create table Note
(
   MyNoteID             int not null auto_increment,
   temp_DoctorID        int,
   NoteDate             date,
   NoteClass            varchar(200),
   primary key (MyNoteID)
);

/*==============================================================*/
/* Table: PatentMedicineInfo                                    */
/*==============================================================*/
create table PatentMedicineInfo
(
   PatentMedicineID     int not null auto_increment,
   PatentMedicineName   varchar(50),
   PatentMedicineContent varchar(200),
   IndicationsFunction  varchar(200),
   Shape                varchar(200),
   UsageDosage          varchar(200),
   Attention            varchar(200),
   Specifications       varchar(200),
   StorageMethod        varchar(50),
   Saute                varchar(1024),
   PatentMedicineRemark varchar(200),
   primary key (PatentMedicineID)
);

/*==============================================================*/
/* Table: PatentMedicineNote                                    */
/*==============================================================*/
create table PatentMedicineNote
(
   PatentMedicineNoteID int not null auto_increment,
   temp_DoctorID        int,
   temp_ChineseMedicineID int,
   NoteDate             date,
   NoteRemark           varchar(1024),
   NoteContent          varchar(1024),
   primary key (PatentMedicineNoteID)
);

/*==============================================================*/
/* Table: PatientInfo                                           */
/*==============================================================*/
create table PatientInfo
(
   PatientID            int not null auto_increment,
   PatientName          varchar(50),
   PatientSex           varchar(5),
   PatientAge           int,
   PatientPhoneNumber   varchar(20),
   PatientHeight        int,
   PatientWeight        double,
   PatientProfessional  varchar(50),
   PatientAddress       varchar(50),
   PatientRemark        varchar(1024),
   primary key (PatientID)
);

/*==============================================================*/
/* Table: PictureList                                           */
/*==============================================================*/
create table PictureList
(
   PictureLocationID    int not null auto_increment,
   OriginalPicturePath  varchar(1024),
   SmallPicturePath     varchar(1024),
   PictureClass         varchar(200),
   PictureName          varchar(200),
   PictureTitle         varchar(200),
   PictureRemarks       varchar(1024),
   primary key (PictureLocationID)
);

/*==============================================================*/
/* Table: PrescriptionsInfo                                     */
/*==============================================================*/
create table PrescriptionsInfo
(
   PrescriptionID       int not null auto_increment,
   PrescriptionName     varchar(200),
   PrescriptionOrigin   varchar(200),
   PrescriptionEffect   varchar(200),
   PrescriptionClass    varchar(200),
   PrescriptionFunction varchar(1024),
   PrescriptionSummary  varchar(1024),
   PrescriptionInstructions varchar(1024),
   PrescriptionRemark   varchar(1024),
   primary key (PrescriptionID)
);

/*==============================================================*/
/* Table: PrescriptionsNote                                     */
/*==============================================================*/
create table PrescriptionsNote
(
   PrescriptionsNoteID  int not null auto_increment,
   temp_DoctorID        int,
   temp_PrescriptionID  int,
   NoteDate             date,
   NoteRemark           varchar(1024),
   NoteContent          varchar(1024),
   primary key (PrescriptionsNoteID)
);

/*==============================================================*/
/* Table: SyndromeTypes                                         */
/*==============================================================*/
create table SyndromeTypes
(
   SyndromeTypeID       int not null auto_increment,
   SyndromeTypeName     varchar(200),
   DialecticalMethod    varchar(1024),
   primary key (SyndromeTypeID)
);

/*==============================================================*/
/* Table: WTreatmentRecords                                     */
/*==============================================================*/
create table WTreatmentRecords
(
   WTreatmentRecordID   int not null auto_increment,
   temp_WestMedicineExamID int,
   WestExamResultVal    decimal(8,2),
   temp_PatientID       int,
   primary key (WTreatmentRecordID)
);

/*==============================================================*/
/* Table: WestMedicineExamItem                                  */
/*==============================================================*/
create table WestMedicineExamItem
(
   WestMedicineExamID   int not null auto_increment,
   WestMedicineItemName varchar(200),
   WesMedicineItemExpl  varchar(1024),
   primary key (WestMedicineExamID)
);

