package ru.sberbank.homework14.presentation.presenters.impl;

import ru.sberbank.homework14.domain.entity.Forecasts;
import ru.sberbank.homework14.domain.executor.Executor;
import ru.sberbank.homework14.domain.executor.MainThread;
import ru.sberbank.homework14.domain.repository.ForecastRepository;
import ru.sberbank.homework14.domain.usecase.GetForecast;
import ru.sberbank.homework14.domain.usecase.impl.GetForecastImpl;
import ru.sberbank.homework14.presentation.presenters.MainPresenter;
import ru.sberbank.homework14.presentation.presenters.base.AbstractPresenter;

public class MainPresenterImpl extends AbstractPresenter implements MainPresenter, GetForecast.Callback {

    private MainPresenter.View mView;
    private ForecastRepository mForecastRepository;

    public MainPresenterImpl(Executor executor, MainThread mainThread, View view, ForecastRepository forecastRepository) {
        super(executor, mainThread);
        mView = view;
        mForecastRepository = forecastRepository;
    }

    @Override
    public void resume() {
        mView.showProgress();
        GetForecast getForecast = new GetForecastImpl(mExecutor, mMainThread, this, mForecastRepository);
        getForecast.execute();

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onMessageRetrieved(Forecasts forecasts) {
        mView.displayWeather(forecasts);
    }

    @Override
    public void onRetrievalFailed() {

    }
}
