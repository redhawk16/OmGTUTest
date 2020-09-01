package com.pochekuev.application.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Statement {

    @SerializedName("nrec")
    @Expose
    private String nrec;

    @SerializedName("nrecint64")
    @Expose
    private String nrecint64;

    @SerializedName("numDoc")
    @Expose
    private String numDoc;

    @SerializedName("typeList")
    @Expose
    private int typeList;

    @SerializedName("listFacult")
    @Expose
    private String listFacult;

    @SerializedName("listChair")
    @Expose
    private String listChair;

    @SerializedName("studGroup")
    @Expose
    private String studGroup;

    @SerializedName("semester")
    @Expose
    private int semester;

    @SerializedName("discipline")
    @Expose
    private String discipline;

    @SerializedName("disciplineNrec")
    @Expose
    private String disciplineNrec;

    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("disciplineAbbr")
    @Expose
    private String disciplineAbbr;

    @SerializedName("audHoursTotalList")
    @Expose
    private int audHoursTotalList;

    @SerializedName("audHoursList")
    @Expose
    private int audHoursList;

    @SerializedName("formAttestationList")
    @Expose
    private String formAttestationList;

    @SerializedName("typeDiffer")
    @Expose
    private int typeDiffer;

    @SerializedName("dateList")
    @Expose
    private int dateList;

    @SerializedName("audHoursCurr")
    @Expose
    private int audHoursCurr;

    @SerializedName("dateOfCurHours")
    @Expose
    private int dateOfCurHours;

    @SerializedName("examinerNrec")
    @Expose
    private String examinerNrec;

    @SerializedName("examinerFio")
    @Expose
    private String examinerFio;

    @SerializedName("nreckurs")
    @Expose
    private String nreckurs;

    @SerializedName("dopStatusList")
    @Expose
    private int dopStatusList;

    @SerializedName("student")
    @Expose
    ArrayList<Student> listStudents = new ArrayList<>();

    @SerializedName("listexaminer")
    @Expose
    ArrayList<Examiner> listExaminers = new ArrayList<>();


    // Getter Methods

    public String getNrec() {
        return nrec;
    }

    public String getNrecint64() {
        return nrecint64;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public int getTypeList() {
        return typeList;
    }

    public String getListFacult() {
        return listFacult;
    }

    public String getListChair() {
        return listChair;
    }

    public String getStudGroup() {
        return studGroup;
    }

    public int getSemester() {
        return semester;
    }

    public String getDiscipline() {
        return discipline;
    }

    public String getDisciplineNrec() {
        return disciplineNrec;
    }

    public int getStatus() {
        return status;
    }

    public String getDisciplineAbbr() {
        return disciplineAbbr;
    }

    public int getAudHoursTotalList() {
        return audHoursTotalList;
    }

    public int getAudHoursList() {
        return audHoursList;
    }

    public String getFormAttestationList() {
        return formAttestationList;
    }

    public int getTypeDiffer() {
        return typeDiffer;
    }

    public int getDateList() {
        return dateList;
    }

    public int getAudHoursCurr() {
        return audHoursCurr;
    }

    public int getDateOfCurHours() {
        return dateOfCurHours;
    }

    public String getExaminerNrec() {
        return examinerNrec;
    }

    public String getExaminerFio() {
        return examinerFio;
    }

    public String getNreckurs() {
        return nreckurs;
    }

    public int getDopStatusList() {
        return dopStatusList;
    }

    public ArrayList<Student> getListStudents() {
        return listStudents;
    }

    public ArrayList<Examiner> getListExaminers() {
        return listExaminers;
    }

    // Setter Methods

    public void setNrec(String nrec) {
        this.nrec = nrec;
    }

    public void setNrecint64(String nrecint64) {
        this.nrecint64 = nrecint64;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public void setTypeList(int typeList) {
        this.typeList = typeList;
    }

    public void setListFacult(String listFacult) {
        this.listFacult = listFacult;
    }

    public void setListChair(String listChair) {
        this.listChair = listChair;
    }

    public void setStudGroup(String studGroup) {
        this.studGroup = studGroup;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public void setDisciplineNrec(String disciplineNrec) {
        this.disciplineNrec = disciplineNrec;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setDisciplineAbbr(String disciplineAbbr) {
        this.disciplineAbbr = disciplineAbbr;
    }

    public void setAudHoursTotalList(int audHoursTotalList) {
        this.audHoursTotalList = audHoursTotalList;
    }

    public void setAudHoursList(int audHoursList) {
        this.audHoursList = audHoursList;
    }

    public void setFormAttestationList(String formAttestationList) {
        this.formAttestationList = formAttestationList;
    }

    public void setTypeDiffer(int typeDiffer) {
        this.typeDiffer = typeDiffer;
    }

    public void setDateList(int dateList) {
        this.dateList = dateList;
    }

    public void setAudHoursCurr(int audHoursCurr) {
        this.audHoursCurr = audHoursCurr;
    }

    public void setDateOfCurHours(int dateOfCurHours) {
        this.dateOfCurHours = dateOfCurHours;
    }

    public void setExaminerNrec(String examinerNrec) {
        this.examinerNrec = examinerNrec;
    }

    public void setExaminerFio(String examinerFio) {
        this.examinerFio = examinerFio;
    }

    public void setNreckurs(String nreckurs) {
        this.nreckurs = nreckurs;
    }

    public void setDopStatusList(int dopStatusList) {
        this.dopStatusList = dopStatusList;
    }

}