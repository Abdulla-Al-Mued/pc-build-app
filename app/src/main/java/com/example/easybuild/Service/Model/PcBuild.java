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
    @SerializedName("MOTHERBOARD")
    @Expose
    private List<Motherboard> motherboard = null;
    @SerializedName("RAM")
    @Expose
    private List<Ram> ram = null;
    @SerializedName("PROCESSOR")
    @Expose
    private List<Processor> processor = null;
    @SerializedName("POWERSUPPLY")
    @Expose
    private List<PowerSupply> powerSupply = null;
    @SerializedName("STORAGE")
    @Expose
    private List<Storage> storage = null;
    @SerializedName("MONITOR")
    @Expose
    private List<Monitor> monitor = null;

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

    public List<Motherboard> getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(List<Motherboard> motherboard) {
        this.motherboard = motherboard;
    }

    public List<Ram> getRam() {
        return ram;
    }

    public void setRam(List<Ram> ram) {
        this.ram = ram;
    }

    public List<Processor> getProcessor() {
        return processor;
    }

    public void setProcessor(List<Processor> processor) {
        this.processor = processor;
    }

    public List<PowerSupply> getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(List<PowerSupply> powerSupply) {
        this.powerSupply = powerSupply;
    }

    public List<Storage> getStorage() {
        return storage;
    }

    public void setStorage(List<Storage> storage) {
        this.storage = storage;
    }

    public List<Monitor> getMonitor() {
        return monitor;
    }

    public void setMonitor(List<Monitor> monitor) {
        this.monitor = monitor;
    }

}
