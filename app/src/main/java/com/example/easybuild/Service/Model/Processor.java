package com.example.easybuild.Service.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Processor implements Serializable {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("VendorName")
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
    @SerializedName("Series")
    @Expose
    private Integer series;
    @SerializedName("VideoRam")
    @Expose
    private String videoRam;
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

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public String getVideoRam() {
        return videoRam;
    }

    public void setVideoRam(String videoRam) {
        this.videoRam = videoRam;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
