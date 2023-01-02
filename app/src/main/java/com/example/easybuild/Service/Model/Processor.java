package com.example.easybuild.Service.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Processor {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("Vendor Name")
    @Expose
    private String vendorName;
    @SerializedName("Model")
    @Expose
    private String model;
    @SerializedName("Cores")
    @Expose
    private Integer cores;
    @SerializedName("Threads")
    @Expose
    private Integer threads;
    @SerializedName("Generation")
    @Expose
    private Integer generation;
    @SerializedName("V-RAM")
    @Expose
    private String vRam;
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

    public Integer getCores() {
        return cores;
    }

    public void setCores(Integer cores) {
        this.cores = cores;
    }

    public Integer getThreads() {
        return threads;
    }

    public void setThreads(Integer threads) {
        this.threads = threads;
    }

    public Integer getGeneration() {
        return generation;
    }

    public void setGeneration(Integer generation) {
        this.generation = generation;
    }

    public String getVRam() {
        return vRam;
    }

    public void setVRam(String vRam) {
        this.vRam = vRam;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
