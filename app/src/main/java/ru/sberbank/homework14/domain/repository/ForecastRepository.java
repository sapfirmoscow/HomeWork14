package ru.sberbank.homework14.domain.repository;

import java.io.IOException;

import ru.sberbank.homework14.domain.entity.Forecasts;

public interface ForecastRepository {
    Forecasts getForecast(String latitude, String longitude) throws IOException;
}
