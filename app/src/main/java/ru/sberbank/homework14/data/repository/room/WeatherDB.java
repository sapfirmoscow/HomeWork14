package ru.sberbank.homework14.data.repository.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ru.sberbank.homework14.domain.entity.Forecast;

@Database(entities = Forecast.class, version = 2)

public abstract class WeatherDB extends RoomDatabase {

    public abstract WeatherDAO getWeatherDAO();
}
