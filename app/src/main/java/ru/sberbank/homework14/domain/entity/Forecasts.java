package ru.sberbank.homework14.domain.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class Forecasts implements Serializable {

    private int id;
    @SerializedName("now")
    @Expose
    private int now;
    @SerializedName("now_dt")
    @Expose
    private String nowDt;
    @SerializedName("forecasts")
    @Expose
    private List<Forecast> forecasts = null;


    public Forecasts() {

    }

    public int getNow() {
        return now;
    }

    public void setNow(int now) {
        this.now = now;
    }

    public String getNowDt() {
        return nowDt;
    }

    public void setNowDt(String nowDt) {
        this.nowDt = nowDt;
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
