package ru.sberbank.homework14.data.repository.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;

import java.util.List;

import ru.sberbank.homework14.domain.entity.Forecast;


@Dao
public abstract class WeatherDAO {

    @Query("SELECT * FROM Forecast")
    public abstract List<Forecast> getForecast();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long[] insert(List<Forecast> forecasts);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public abstract int update(List<Forecast> forecasts);

    @Query("DELETE FROM Forecast")
    public abstract void clear();

    @Transaction
    public void setDailyForecasts(List<Forecast> dailyForecasts) {
        clear();
        insert(dailyForecasts);
    }
}
