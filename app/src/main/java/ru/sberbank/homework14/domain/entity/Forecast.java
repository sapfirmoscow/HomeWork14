package ru.sberbank.homework14.domain.entity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class Forecast implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("date_ts")
    @Expose
    private int dateTs;
    @SerializedName("week")
    @Expose
    private int week;
    @SerializedName("sunrise")
    @Expose
    private String sunrise;
    @SerializedName("sunset")
    @Expose
    private String sunset;
    @SerializedName("rise_begin")
    @Expose
    private String riseBegin;
    @SerializedName("set_end")
    @Expose
    private String setEnd;
    @SerializedName("moon_code")
    @Expose
    private int moonCode;
    @SerializedName("moon_text")
    @Expose
    private String moonText;
    @SerializedName("parts")
    @Expose
    @Embedded
    private Parts parts;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDateTs() {
        return dateTs;
    }

    public void setDateTs(int dateTs) {
        this.dateTs = dateTs;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getRiseBegin() {
        return riseBegin;
    }

    public void setRiseBegin(String riseBegin) {
        this.riseBegin = riseBegin;
    }

    public String getSetEnd() {
        return setEnd;
    }

    public void setSetEnd(String setEnd) {
        this.setEnd = setEnd;
    }

    public int getMoonCode() {
        return moonCode;
    }

    public void setMoonCode(int moonCode) {
        this.moonCode = moonCode;
    }

    public String getMoonText() {
        return moonText;
    }

    public void setMoonText(String moonText) {
        this.moonText = moonText;
    }

    public Parts getParts() {
        return parts;
    }

    public void setParts(Parts parts) {
        this.parts = parts;
    }
}
