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

    @SerializedName("processor")
    @Expose
    private List<Processor> processors = null;

    @SerializedName("power_supply")
    @Expose
    private List<Powersupply> powersupplies = null;

    @SerializedName("Ram")
    @Expose
    private List<Ram1> rams = null;

    @SerializedName("STORAGE")
    @Expose
    private List<Ssd> storages = null;

    @SerializedName("GraphicsCard")
    @Expose
    private List<Graphicscard> graphicscards = null;

    @SerializedName("MONITOR")
    @Expose
    private List<Monitor> Monitors = null;


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

    public List<Processor> getProcessors() {
        return processors;
    }

    public void setProcessors(List<Processor> processors) {
        this.processors = processors;
    }

    public List<Powersupply> getPowersupplies() {
        return powersupplies;
    }

    public void setPowersupplies(List<Powersupply> powersupplies) {
        this.powersupplies = powersupplies;
    }

    public List<Ram1> getRams() {
        return rams;
    }

    public void setRams(List<Ram1> rams) {
        this.rams = rams;
    }

    public List<Ssd> getStorages() {
        return storages;
    }

    public void setStorages(List<Ssd> storages) {
        this.storages = storages;
    }

    public List<Graphicscard> getGraphicscards() {
        return graphicscards;
    }

    public void setGraphicscards(List<Graphicscard> graphicscards) {
        this.graphicscards = graphicscards;
    }

    public List<Monitor> getMonitors() {
        return Monitors;
    }

    public void setMonitors(List<Monitor> monitors) {
        Monitors = monitors;
    }
}
