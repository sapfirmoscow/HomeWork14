package ru.sberbank.homework14.domain.usecase.impl;

import java.io.IOException;

import ru.sberbank.homework14.domain.entity.Forecasts;
import ru.sberbank.homework14.domain.executor.Executor;
import ru.sberbank.homework14.domain.executor.MainThread;
import ru.sberbank.homework14.domain.repository.ForecastRepository;
import ru.sberbank.homework14.domain.usecase.GetForecast;
import ru.sberbank.homework14.domain.usecase.base.AbstractUseCase;

public class GetForecastImpl extends AbstractUseCase implements GetForecast {

    private GetForecast.Callback mCallback;
    private ForecastRepository mForecastRepository;


    public GetForecastImpl(Executor threadExecutor, MainThread mainThread, Callback callback, ForecastRepository forecastRepository) {
        super(threadExecutor, mainThread);
        mCallback = callback;
        mForecastRepository = forecastRepository;

    }


    private void postMessage(Forecasts forecasts) {
        mMainThread.post(() -> mCallback.onMessageRetrieved(forecasts));
    }

    @Override
    public void run() {

        try {
            postMessage(mForecastRepository.getForecast("", ""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
