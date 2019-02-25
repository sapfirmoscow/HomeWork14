package ru.sberbank.homework14.presentation.presenters;

import ru.sberbank.homework14.domain.entity.Forecasts;
import ru.sberbank.homework14.presentation.presenters.base.BasePresenter;
import ru.sberbank.homework14.presentation.ui.BaseView;

public interface MainPresenter extends BasePresenter {
    interface View extends BaseView {
        void displayWeather(Forecasts forecasts);
    }
}
