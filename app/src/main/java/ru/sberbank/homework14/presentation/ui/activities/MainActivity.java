package ru.sberbank.homework14.presentation.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import ru.sberbank.homework14.MainThreadImpl;
import ru.sberbank.homework14.R;
import ru.sberbank.homework14.data.ForecastRepositoryImpl;
import ru.sberbank.homework14.domain.entity.Forecast;
import ru.sberbank.homework14.domain.entity.Forecasts;
import ru.sberbank.homework14.domain.executor.impl.ThreadExecutor;
import ru.sberbank.homework14.presentation.presenters.MainPresenter;
import ru.sberbank.homework14.presentation.presenters.impl.MainPresenterImpl;
import ru.sberbank.homework14.presentation.ui.recycler.MyAdapter;
import ru.sberbank.homework14.presentation.ui.recycler.RecyclerItemClickListener;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    private MainPresenter mPresenter;

    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPresenter();
        initRecyclerView();
        initListeners();
    }

    private void initListeners() {
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Forecast forecast = mMyAdapter.getItemForecast(position);
                Intent intent = DetailActivity.newIntent(MainActivity.this, forecast);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }

    private void initPresenter() {
        mPresenter = new MainPresenterImpl(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), this, new ForecastRepositoryImpl(MainActivity.this));

    }

    private void initRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mMyAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mMyAdapter);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void displayWeather(Forecasts forecasts) {

        mMyAdapter.setData(forecasts.getForecasts());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.resume();
    }
}
