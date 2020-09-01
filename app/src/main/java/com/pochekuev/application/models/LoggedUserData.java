package com.pochekuev.application.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LoggedUserData {

    @SerializedName("fnpp")
    @Expose
    private int fnpp;

    @SerializedName("wnpp")
    @Expose
    ArrayList<String> wnpp = new ArrayList<>();

    // Getter Methods
    public int getFnpp() {
        return fnpp;
    }

    // Setter Methods
    public void setFnpp(int fnpp) {
        this.fnpp = fnpp;
    }

}

