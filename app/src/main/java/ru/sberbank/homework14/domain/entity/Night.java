package ru.sberbank.homework14.domain.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Night implements Serializable {

    @SerializedName("_source")
    @Expose
    private String source;
    @SerializedName("temp_min")
    @Expose
    private int tempMin;
    @SerializedName("temp_max")
    @Expose
    private int tempMax;
    @SerializedName("temp_avg")
    @Expose
    private int tempAvg;
    @SerializedName("feels_like")
    @Expose
    private int feelsLike;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("daytime")
    @Expose
    private String daytime;
    @SerializedName("polar")
    @Expose
    private boolean polar;
    @SerializedName("wind_speed")
    @Expose
    private float windSpeed;
    @SerializedName("wind_gust")
    @Expose
    private float windGust;
    @SerializedName("wind_dir")
    @Expose
    private String windDir;
    @SerializedName("pressure_mm")
    @Expose
    private int pressureMm;
    @SerializedName("pressure_pa")
    @Expose
    private int pressurePa;
    @SerializedName("humidity")
    @Expose
    private int humidity;
    @SerializedName("uv_index")
    @Expose
    private int uvIndex;
    @SerializedName("soil_temp")
    @Expose
    private int soilTemp;
    @SerializedName("soil_moisture")
    @Expose
    private float soilMoisture;
    @SerializedName("prec_mm")
    @Expose
    private float precMm;
    @SerializedName("prec_period")
    @Expose
    private int precPeriod;
    @SerializedName("prec_prob")
    @Expose
    private int precProb;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public int getTempAvg() {
        return tempAvg;
    }

    public void setTempAvg(int tempAvg) {
        this.tempAvg = tempAvg;
    }

    public int getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(int feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCondition() {
        switch (condition) {
            case "clear":
                return "Ясно";
            case "partly-cloudy":
                return "Малооблачно";
            case "cloudy":
                return "Облачно с прояснениями";
            case "overcast":
                return "Пасмурно";
            case "partly-cloudy-and-light-rain":
                return "Небольшой дождь";
            case "partly-cloudy-and-rain":
                return "Дождь";
            case "overcast-and-rain":
                return "Сильный дождь";
            case "overcast-thunderstorms-with-rain":
                return "Сильный дождь, гроза";
            case "cloudy-and-light-rain":
                return "Небольшой дождь";
            case "overcast-and-light-rain":
                return "Небольшой дождь";
            case "cloudy-and-rain":
                return "Дождь";
            case "overcast-and-wet-snow":
                return "Дождь со снегом";
            case "partly-cloudy-and-light-snow":
                return "Небольшой снег";
            case "partly-cloudy-and-snow":
                return "Снег";
            case "overcast-and-snow":
                return "Снегопад";
            case "cloudy-and-light-snow":
                return "Небольшой снег";
            case "overcast-and-light-snow":
                return "Небольшой снег";
            case "cloudy-and-snow":
                return "Снег";
            default:
                return condition;
        }

    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDaytime() {
        return daytime;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public boolean isPolar() {
        return polar;
    }

    public void setPolar(boolean polar) {
        this.polar = polar;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public float getWindGust() {
        return windGust;
    }

    public void setWindGust(float windGust) {
        this.windGust = windGust;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public int getPressureMm() {
        return pressureMm;
    }

    public void setPressureMm(int pressureMm) {
        this.pressureMm = pressureMm;
    }

    public int getPressurePa() {
        return pressurePa;
    }

    public void setPressurePa(int pressurePa) {
        this.pressurePa = pressurePa;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(int uvIndex) {
        this.uvIndex = uvIndex;
    }

    public int getSoilTemp() {
        return soilTemp;
    }

    public void setSoilTemp(int soilTemp) {
        this.soilTemp = soilTemp;
    }

    public float getSoilMoisture() {
        return soilMoisture;
    }

    public void setSoilMoisture(float soilMoisture) {
        this.soilMoisture = soilMoisture;
    }

    public float getPrecMm() {
        return precMm;
    }

    public void setPrecMm(float precMm) {
        this.precMm = precMm;
    }

    public int getPrecPeriod() {
        return precPeriod;
    }

    public void setPrecPeriod(int precPeriod) {
        this.precPeriod = precPeriod;
    }

    public int getPrecProb() {
        return precProb;
    }

    public void setPrecProb(int precProb) {
        this.precProb = precProb;
    }

}
