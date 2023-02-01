package com.example.easybuild.Service.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Powersupply implements Serializable {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("VendorName")
    @Expose
    private String vendorName;
    @SerializedName("Model")
    @Expose
    private String model;
    @SerializedName("PowerInW")
    @Expose
    private Integer powerInW;
    @SerializedName("Price")
    @Expose
    private Integer price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPowerInW() {
        return powerInW;
    }

    public void setPowerInW(Integer powerInW) {
        this.powerInW = powerInW;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
