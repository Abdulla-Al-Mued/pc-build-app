package com.example.easybuild.Service.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MotherboardResponse {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("motherBoard")
    @Expose
    private Motherboard motherBoard;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Motherboard getMotherBoard() {
        return motherBoard;
    }

    public void setMotherBoard(Motherboard motherBoard) {
        this.motherBoard = motherBoard;
    }

}
