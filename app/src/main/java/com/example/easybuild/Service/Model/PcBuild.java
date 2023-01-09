package com.example.easybuild.Service.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PcBuild {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("totalBudget")
    @Expose
    private Integer totalBudget;
    @SerializedName("MOTHERBOARD")
    @Expose
    private Motherboard motherboard;
    @SerializedName("RAM1")
    @Expose
    private Ram1 ram1;
    @SerializedName("RAM2")
    @Expose
    private Ram2 ram2;
    @SerializedName("PROCESSOR")
    @Expose
    private Processor processor;
    @SerializedName("POWERSUPPLY")
    @Expose
    private Powersupply powersupply;
    @SerializedName("SSD")
    @Expose
    private Ssd ssd;
    @SerializedName("HDD")
    @Expose
    private Hdd hdd;
    @SerializedName("GRAPHICSCARD")
    @Expose
    private Graphicscard graphicscard;
    @SerializedName("MONITOR")
    @Expose
    private Monitor monitor;

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

    public Integer getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(Integer totalBudget) {
        this.totalBudget = totalBudget;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public Ram1 getRam1() {
        return ram1;
    }

    public void setRam1(Ram1 ram1) {
        this.ram1 = ram1;
    }

    public Ram2 getRam2() {
        return ram2;
    }

    public void setRam2(Ram2 ram2) {
        this.ram2 = ram2;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Powersupply getPowersupply() {
        return powersupply;
    }

    public void setPowersupply(Powersupply powersupply) {
        this.powersupply = powersupply;
    }

    public Ssd getSsd() {
        return ssd;
    }

    public void setSsd(Ssd ssd) {
        this.ssd = ssd;
    }

    public Hdd getHdd() {
        return hdd;
    }

    public void setHdd(Hdd hdd) {
        this.hdd = hdd;
    }

    public Graphicscard getGraphicscard() {
        return graphicscard;
    }

    public void setGraphicscard(Graphicscard graphicscard) {
        this.graphicscard = graphicscard;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

}
