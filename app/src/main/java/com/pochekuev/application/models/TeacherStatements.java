package com.pochekuev.application.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeacherStatements {

    // Уникальный номер дисциплины
    @SerializedName("nrec")
    @Expose
    private String nrec;

    //
    @SerializedName("nrecint64")
    @Expose
    private String nrecint64;

    // Уникальный номер документа дисцилины ??
    @SerializedName("numdoc")
    @Expose
    private String numdoc;

    // Год на протяжении которого преподавателя будет вести дисциплину ??
    @SerializedName("year")
    @Expose
    private int year;

    // Семестр
    @SerializedName("semester")
    @Expose
    private String semester;

    // Тип дисциплины
    @SerializedName("typeList")
    @Expose
    private String typeList;

    //
    @SerializedName("typeListInt")
    @Expose
    private int typeListInt;

    //
    @SerializedName("status")
    @Expose
    private int status;

    // Форма/Тип обучения (заочка очка)??
    @SerializedName("formEdu")
    @Expose
    private int formEdu;

    // Группа
    @SerializedName("studGroup")
    @Expose
    private String studGroup;

    //
    @SerializedName("listChair")
    @Expose
    private String listChair;

    // Факультет ??
    @SerializedName("listFacult")
    @Expose
    private String listFacult;

    // Наименование дисциплины
    @SerializedName("discipline")
    @Expose
    private String discipline;

    // Уникальный номер преподавателя (идентификатор)
    @SerializedName("examinerNrec")
    @Expose
    private String examinerNrec;

    // ФИО преподавателя
    @SerializedName("examiner")
    @Expose
    private String examiner;

    //
    @SerializedName("dopStatusList")
    @Expose
    private int dopStatusList;

    // Количество студентов (есть ли разделение на подгруппы, если да то кол-во студентов, которые ходят на данную дисциплину)
    @SerializedName("studentCount")
    @Expose
    private int studentCount;

    // Количество оценок ??
    @SerializedName("markCount")
    @Expose
    private int markCount;


    // Getter Methods
    public String getNrec() {
        return nrec;
    }

    public String getNrecint64() {
        return nrecint64;
    }

    public String getNumdoc() {
        return numdoc;
    }

    public int getYear() {
        return year;
    }

    public String getSemester() {
        return semester;
    }

    public String getTypeList() {
        return typeList;
    }

    public int getTypeListInt() {
        return typeListInt;
    }

    public int getStatus() {
        return status;
    }

    public int getFormEdu() {
        return formEdu;
    }

    public String getStudGroup() {
        return studGroup;
    }

    public String getListChair() {
        return listChair;
    }

    public String getListFacult() {
        return listFacult;
    }

    public String getDiscipline() {
        return discipline;
    }

    public String getExaminerNrec() {
        return examinerNrec;
    }

    public String getExaminer() {
        return examiner;
    }

    public int getDopStatusList() {
        return dopStatusList;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public int getMarkCount() {
        return markCount;
    }

    // Setter Methods
    public void setNrec(String nrec) {
        this.nrec = nrec;
    }

    public void setNrecint64(String nrecint64) {
        this.nrecint64 = nrecint64;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setTypeList(String typeList) {
        this.typeList = typeList;
    }

    public void setTypeListInt(int typeListInt) {
        this.typeListInt = typeListInt;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setFormEdu(int formEdu) {
        this.formEdu = formEdu;
    }

    public void setStudGroup(String studGroup) {
        this.studGroup = studGroup;
    }

    public void setListChair(String listChair) {
        this.listChair = listChair;
    }

    public void setListFacult(String listFacult) {
        this.listFacult = listFacult;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public void setExaminerNrec(String examinerNrec) {
        this.examinerNrec = examinerNrec;
    }

    public void setExaminer(String examiner) {
        this.examiner = examiner;
    }

    public void setDopStatusList(int dopStatusList) {
        this.dopStatusList = dopStatusList;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public void setMarkCount(int markCount) {
        this.markCount = markCount;
    }
}
