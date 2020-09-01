package com.pochekuev.application.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Student {

    @SerializedName("markStudNrec")
    @Expose
    private String markStudNrec;

    @SerializedName("fio")
    @Expose
    private String fio;

    @SerializedName("recordBookNumber")
    @Expose
    private String recordBookNumber;

    @SerializedName("studPersonNrec")
    @Expose
    private String studPersonNrec;

    @SerializedName("markLinkNumberNrec")
    @Expose
    private String markLinkNumberNrec;

    @SerializedName("markString")
    @Expose
    private String markString;

    @SerializedName("markNumber")
    @Expose
    private int markNumber;

    @SerializedName("markWendres")
    @Expose
    private int markWendres;

    @SerializedName("recordBookExist")
    @Expose
    private int recordBookExist;

    @SerializedName("makrExaminerNrec")
    @Expose
    private String makrExaminerNrec;

    @SerializedName("makrExaminerFio")
    @Expose
    private String makrExaminerFio;

    @SerializedName("totalStudHours")
    @Expose
    private int totalStudHours;

    @SerializedName("percent")
    @Expose
    private int percent;

    @SerializedName("rating")
    @Expose
    private float rating;

    @SerializedName("ratingsem")
    @Expose
    private int ratingsem;

    @SerializedName("ratingatt")
    @Expose
    private int ratingatt;

    @SerializedName("ratingres")
    @Expose
    private int ratingres;

    @SerializedName("markFromKursList")
    @Expose
    private int markFromKursList;

    @SerializedName("dbDipNrecNrec")
    @Expose
    private String dbDipNrecNrec;

    @SerializedName("tolerance")
    @Expose
    private int tolerance;

    @SerializedName("markListType")
    @Expose
    private int markListType;

    @SerializedName("markListNumDoc")
    @Expose
    private String markListNumDoc;

    // Getter Methods

    public String getMarkStudNrec() {
        return markStudNrec;
    }

    public String getFio() {
        return fio;
    }

    public String getRecordBookNumber() {
        return recordBookNumber;
    }

    public String getStudPersonNrec() {
        return studPersonNrec;
    }

    public String getMarkLinkNumberNrec() {
        return markLinkNumberNrec;
    }

    public String getMarkString() {
        return markString;
    }

    public int getMarkNumber() {
        return markNumber;
    }

    public void setMarkNumber(int markNumber) {
        this.markNumber = markNumber;
    }

    public int getMarkWendres() {
        return markWendres;
    }

    public void setMarkWendres(int markWendres) {
        this.markWendres = markWendres;
    }

    public int getRecordBookExist() {
        return recordBookExist;
    }

    public void setRecordBookExist(int recordBookExist) {
        this.recordBookExist = recordBookExist;
    }

    public String getMakrExaminerNrec() {
        return makrExaminerNrec;
    }

    public String getMakrExaminerFio() {
        return makrExaminerFio;
    }

    public int getTotalStudHours() {
        return totalStudHours;
    }

    public void setTotalStudHours(int totalStudHours) {
        this.totalStudHours = totalStudHours;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public float getRating() {
        return rating;
    }

    public int getRatingsem() {
        return ratingsem;
    }

    public void setRatingsem(int ratingsem) {
        this.ratingsem = ratingsem;
    }

    public int getRatingatt() {
        return ratingatt;
    }

    public void setRatingatt(int ratingatt) {
        this.ratingatt = ratingatt;
    }

    public int getRatingres() {
        return ratingres;
    }

    public void setRatingres(int ratingres) {
        this.ratingres = ratingres;
    }

    public int getMarkFromKursList() {
        return markFromKursList;
    }

    public void setMarkFromKursList(int markFromKursList) {
        this.markFromKursList = markFromKursList;
    }

    public String getDbDipNrecNrec() {
        return dbDipNrecNrec;
    }

    public int getTolerance() {
        return tolerance;
    }

    public void setTolerance(int tolerance) {
        this.tolerance = tolerance;
    }

    public int getMarkListType() {
        return markListType;
    }

    public void setMarkListType(int markListType) {
        this.markListType = markListType;
    }

    public String getMarkListNumDoc() {
        return markListNumDoc;
    }


    // Setter Methods

    public void setMarkStudNrec(String markStudNrec) {
        this.markStudNrec = markStudNrec;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setRecordBookNumber(String recordBookNumber) {
        this.recordBookNumber = recordBookNumber;
    }

    public void setStudPersonNrec(String studPersonNrec) {
        this.studPersonNrec = studPersonNrec;
    }

    public void setMarkLinkNumberNrec(String markLinkNumberNrec) {
        this.markLinkNumberNrec = markLinkNumberNrec;
    }

    public void setMarkString(String markString) {
        this.markString = markString;
    }

    public void setMakrExaminerNrec(String makrExaminerNrec) {
        this.makrExaminerNrec = makrExaminerNrec;
    }

    public void setMakrExaminerFio(String makrExaminerFio) {
        this.makrExaminerFio = makrExaminerFio;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setDbDipNrecNrec(String dbDipNrecNrec) {
        this.dbDipNrecNrec = dbDipNrecNrec;
    }

    public void setMarkListNumDoc(String markListNumDoc) {
        this.markListNumDoc = markListNumDoc;
    }
}