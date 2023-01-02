package com.example.easybuild.Service.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ram {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("Vendor Name")
    @Expose
    private String vendorName;
    @SerializedName("Memory Type")
    @Expose
    private String memoryType;
    @SerializedName("Bus Speed(Mhz)")
    @Expose
    private Integer busSpeedMhz;
    @SerializedName("Capacity(GB)")
    @Expose
    private Integer capacityGB;
    @SerializedName("Model")
    @Expose
    private String model;
    @SerializedName("Price(tk)")
    @Expose
    private Integer priceTk;

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

    public Integer getBusSpeedMhz() {
        return busSpeedMhz;
    }

    public void setBusSpeedMhz(Integer busSpeedMhz) {
        this.busSpeedMhz = busSpeedMhz;
    }

    public Integer getCapacityGB() {
        return capacityGB;
    }

    public void setCapacityGB(Integer capacityGB) {
        this.capacityGB = capacityGB;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPriceTk() {
        return priceTk;
    }

    public void setPriceTk(Integer priceTk) {
        this.priceTk = priceTk;
    }

}
