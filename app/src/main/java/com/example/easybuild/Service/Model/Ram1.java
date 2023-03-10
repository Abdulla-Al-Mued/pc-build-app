package com.example.easybuild.Service.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Ram1 implements Serializable {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("VendorName")
    @Expose
    private String vendorName;
    @SerializedName("MemoryType")
    @Expose
    private String memoryType;
    @SerializedName("BusSpeed")
    @Expose
    private Integer busSpeed;
    @SerializedName("Capacity")
    @Expose
    private Integer capacity;
    @SerializedName("Model")
    @Expose
    private String model;
    @SerializedName("Price")
    @Expose
    private Integer price;

    public Ram1(String vendorName, String memoryType, Integer busSpeed, Integer capacity, String model, Integer price) {
        this.vendorName = vendorName;
        this.memoryType = memoryType;
        this.busSpeed = busSpeed;
        this.capacity = capacity;
        this.model = model;
        this.price = price;
    }

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

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public Integer getBusSpeed() {
        return busSpeed;
    }

    public void setBusSpeed(Integer busSpeed) {
        this.busSpeed = busSpeed;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
