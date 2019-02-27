package ru.sberbank.homework14.data;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;
import java.util.List;

import ru.sberbank.homework14.data.repository.retrofit.ApiMapper;
import ru.sberbank.homework14.data.repository.retrofit.RetrofitHelper;
import ru.sberbank.homework14.data.repository.room.WeatherDB;
import ru.sberbank.homework14.domain.entity.Forecast;
import ru.sberbank.homework14.domain.entity.Forecasts;
import ru.sberbank.homework14.domain.repository.ForecastRepository;


public class ForecastRepositoryImpl implements ForecastRepository {
    private final ApiMapper apiMapper;
    private final String DB_NAME = "weather";
    private WeatherDB weatherDB;
    private Context mContext;

    public ForecastRepositoryImpl(Context context) {
        apiMapper = new ApiMapper(new RetrofitHelper());
        mContext = context;
        weatherDB = Room.databaseBuilder(context, WeatherDB.class, DB_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

    }

    @Override
    public Forecasts getForecast(String latitude, String longitude) throws IOException {
        List<Forecast> forecast = null;
        if (isOnline()) {
            forecast = getForecastsFromNetwork();
        } else {
            forecast = getForecastsFromDataBase();
        }

        Forecasts forecasts = new Forecasts();
        forecasts.setForecasts(forecast);
        return forecasts;
    }

    private List<Forecast> getForecastsFromNetwork() throws IOException {
        List<Forecast> forecasts = apiMapper.getForecastSync().getForecasts();

        weatherDB.getWeatherDAO().setDailyForecasts(forecasts);
        return forecasts;
    }

    private List<Forecast> getForecastsFromDataBase() {

        return weatherDB.getWeatherDAO().getForecast();
    }

    public boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED;
    }
}
