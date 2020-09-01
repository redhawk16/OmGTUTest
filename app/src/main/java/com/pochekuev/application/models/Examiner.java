package com.pochekuev.application.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Examiner {

    @SerializedName("nrec")
    @Expose
    private String nrec;

    @SerializedName("nrecExaminer")
    @Expose
    private String nrecExaminer;

    @SerializedName("fioExaminer")
    @Expose
    private String fioExaminer;

    // Getter Methods
    public String getNrec() {
        return nrec;
    }

    public String getNrecExaminer() {
        return nrecExaminer;
    }

    public String getFioExaminer() {
        return fioExaminer;
    }

    // Setter Methods
    public void setNrec(String nrec) {
        this.nrec = nrec;
    }

    public void setNrecExaminer(String nrecExaminer) {
        this.nrecExaminer = nrecExaminer;
    }

    public void setFioExaminer(String fioExaminer) {
        this.fioExaminer = fioExaminer;
    }
}
