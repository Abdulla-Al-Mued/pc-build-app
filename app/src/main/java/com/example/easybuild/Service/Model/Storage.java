package com.example.easybuild.Service.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Storage {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("VendorName")
    @Expose
    private String vendorName;
    @SerializedName("Model")
    @Expose
    private String model;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("Interface")
    @Expose
    private String _interface;
    @SerializedName("Capacity")
    @Expose
    private String capacity;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInterface() {
        return _interface;
    }

    public void setInterface(String _interface) {
        this._interface = _interface;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
