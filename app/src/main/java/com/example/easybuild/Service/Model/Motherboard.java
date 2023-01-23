package com.example.easybuild.Service.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Motherboard implements Serializable {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("VendorName")
    @Expose
    private String vendorName;
    @SerializedName("Model")
    @Expose
    private String model;
    @SerializedName("MemoryType")
    @Expose
    private String memoryType;
    @SerializedName("MemorySlots")
    @Expose
    private Integer memorySlots;
    @SerializedName("MaxMemory")
    @Expose
    private Integer maxMemory;
    @SerializedName("Price")
    @Expose
    private Integer price;
    @SerializedName("SupportedCPU")
    @Expose
    private String supportedCPU;


    public Motherboard(String vendorName, String model, String memoryType, Integer memorySlots, Integer maxMemory, Integer price, String supportedCPU) {
        this.vendorName = vendorName;
        this.model = model;
        this.memoryType = memoryType;
        this.memorySlots = memorySlots;
        this.maxMemory = maxMemory;
        this.price = price;
        this.supportedCPU = supportedCPU;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public Integer getMemorySlots() {
        return memorySlots;
    }

    public void setMemorySlots(Integer memorySlots) {
        this.memorySlots = memorySlots;
    }

    public Integer getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(Integer maxMemory) {
        this.maxMemory = maxMemory;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSupportedCPU() {
        return supportedCPU;
    }

    public void setSupportedCPU(String supportedCPU) {
        this.supportedCPU = supportedCPU;
    }


}
