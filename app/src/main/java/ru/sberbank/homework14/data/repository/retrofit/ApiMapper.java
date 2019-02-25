package ru.sberbank.homework14.data.repository.retrofit;


import java.io.IOException;

import ru.sberbank.homework14.WeatherApplication;
import ru.sberbank.homework14.domain.entity.Forecasts;


public class ApiMapper {
    private RetrofitHelper mHelper;

    public ApiMapper(RetrofitHelper helper) {
        mHelper = helper;
    }

    public Forecasts getForecastSync() throws IOException {
        return mHelper.getService().getCurrentForecast(WeatherApplication.X_YANDEX_API_KEY, "55.75222", "37.61556", false, false, 7).execute().body();
    }

}
