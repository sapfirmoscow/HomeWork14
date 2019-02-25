package ru.sberbank.homework14.data;

import java.io.IOException;

import ru.sberbank.homework14.data.repository.retrofit.ApiMapper;
import ru.sberbank.homework14.data.repository.retrofit.RetrofitHelper;
import ru.sberbank.homework14.domain.entity.Forecasts;
import ru.sberbank.homework14.domain.repository.ForecastRepository;


public class ForecastRepositoryImpl implements ForecastRepository {
    private final ApiMapper apiMapper;

    public ForecastRepositoryImpl() {
        apiMapper = new ApiMapper(new RetrofitHelper());
    }

    @Override
    public Forecasts getForecast(String latitude, String longitude) throws IOException {
        Forecasts forecasts = apiMapper.getForecastSync();
        return forecasts;
    }
}
