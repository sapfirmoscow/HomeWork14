package ru.sberbank.homework14.data.repository.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import ru.sberbank.homework14.domain.entity.Forecasts;

public interface WebService {

    /**
     * Метод запроса погоды
     *
     * @param apiKey  - Ключ для пользования сервисами яндекса
     * @param lat     - широта
     * @param lon     - долгота
     * @param isExtra - подробный прогноз осадков
     * @param isHours - наличие почасового прогноза
     * @param limit   -срок прогноза
     */

    @GET("forecast/")
    Call<Forecasts> getCurrentForecast(@Header("X-Yandex-API-Key") String apiKey, @Query("lat") String lat, @Query("lon") String lon, @Query("extra") boolean isExtra, @Query("hours") boolean isHours, @Query("limit") int limit);
}
