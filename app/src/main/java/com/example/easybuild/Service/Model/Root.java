package com.example.easybuild.Service.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Root {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("motherboard")
    @Expose
    private List<Motherboard> motherboard = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Motherboard> getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(List<Motherboard> motherboard) {
        this.motherboard = motherboard;
    }
}
