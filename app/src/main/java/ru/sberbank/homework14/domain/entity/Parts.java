package ru.sberbank.homework14.domain.entity;


import android.arch.persistence.room.Embedded;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Parts implements Serializable {

    @SerializedName("night")
    @Expose
    @Embedded(prefix = "night")
    private Night night;
    @SerializedName("morning")
    @Expose
    @Embedded(prefix = "morning")
    private Morning morning;
    @SerializedName("day")
    @Expose
    @Embedded(prefix = "day")
    private Day day;
    @SerializedName("evening")
    @Expose
    @Embedded(prefix = "evening")
    private Evening evening;

    public Night getNight() {
        return night;
    }

    public void setNight(Night night) {
        this.night = night;
    }

    public Morning getMorning() {
        return morning;
    }

    public void setMorning(Morning morning) {
        this.morning = morning;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Evening getEvening() {
        return evening;
    }

    public void setEvening(Evening evening) {
        this.evening = evening;
    }
}
