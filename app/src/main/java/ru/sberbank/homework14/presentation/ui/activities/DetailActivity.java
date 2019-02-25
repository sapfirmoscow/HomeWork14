package ru.sberbank.homework14.presentation.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import ru.sberbank.homework14.R;
import ru.sberbank.homework14.domain.entity.Forecast;

public class DetailActivity extends AppCompatActivity {

    private static final String EXTRA_NAME = "forecast";
    private Forecast mForecast;
    private TextView mHeaderDayOfWeek;
    private TextView mHeaderDate;

    private TextView mMorningMinMaxTemp;
    private TextView mMorningCond;
    private TextView mMorningPressure;
    private TextView mMorningFeel;
    private TextView mMorningWindSpeed;

    private TextView mDayMinMaxTemp;
    private TextView mDayCond;
    private TextView mDayPressure;
    private TextView mDayFeel;
    private TextView mDayWindSpeed;

    private TextView mEveningMinMaxTemp;
    private TextView mEveningCond;
    private TextView mEveningPressure;
    private TextView mEveningFeel;
    private TextView mEveningWindSpeed;

    private TextView mNightMinMaxTemp;
    private TextView mNightCond;
    private TextView mNightPressure;
    private TextView mNightFeel;
    private TextView mNightWindSpeed;

    public static final Intent newIntent(Context context, Forecast forecast) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_NAME, forecast);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initForecast();
        initView();
        initActionBar();
        setValues();
    }

    private String getDayOfWeekFromDate(String s) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Locale locale = new Locale("ru");
        String dayOfWeek = new SimpleDateFormat("EEEE", locale).format(date);
        dayOfWeek = dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1);
        return dayOfWeek;

    }

    private void setValues() {
        mHeaderDayOfWeek.setText(getDayOfWeekFromDate(mForecast.getDate()));
        mHeaderDate.setText(mForecast.getDate());

        mMorningCond.setText(mForecast.getParts().getMorning().getCondition());
        mMorningWindSpeed.setText(String.valueOf(mForecast.getParts().getMorning().getWindSpeed()));
        mMorningPressure.setText(String.valueOf(mForecast.getParts().getMorning().getPressureMm()));
        mMorningFeel.setText(String.valueOf(mForecast.getParts().getMorning().getFeelsLike()));
        mMorningMinMaxTemp.setText(mForecast.getParts().getMorning().getTempMin() + "°" + "..." + mForecast.getParts().getMorning().getTempMax() + "°");

        mDayCond.setText(mForecast.getParts().getDay().getCondition());
        mDayWindSpeed.setText(String.valueOf(mForecast.getParts().getDay().getWindSpeed()));
        mDayPressure.setText(String.valueOf(mForecast.getParts().getDay().getPressureMm()));
        mDayFeel.setText(String.valueOf(mForecast.getParts().getDay().getFeelsLike()));
        mDayMinMaxTemp.setText(mForecast.getParts().getDay().getTempMin() + "°" + " ... " + mForecast.getParts().getDay().getTempMax() + "°");

        mEveningCond.setText(mForecast.getParts().getEvening().getCondition());
        mEveningWindSpeed.setText(String.valueOf(mForecast.getParts().getEvening().getWindSpeed()));
        mEveningPressure.setText(String.valueOf(mForecast.getParts().getEvening().getPressureMm()));
        mEveningFeel.setText(String.valueOf(mForecast.getParts().getEvening().getFeelsLike()));
        mEveningMinMaxTemp.setText(mForecast.getParts().getEvening().getTempMin() + "°" + " ... " + mForecast.getParts().getEvening().getTempMax() + "°");

        mNightCond.setText(mForecast.getParts().getNight().getCondition());
        mNightWindSpeed.setText(String.valueOf(mForecast.getParts().getNight().getWindSpeed()));
        mNightPressure.setText(String.valueOf(mForecast.getParts().getNight().getPressureMm()));
        mNightFeel.setText(String.valueOf(mForecast.getParts().getNight().getFeelsLike()));
        mNightMinMaxTemp.setText(mForecast.getParts().getNight().getTempMin() + "°" + " ... " + mForecast.getParts().getNight().getTempMax() + "°");
    }

    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void initView() {
        mHeaderDate = findViewById(R.id.header_date);
        mHeaderDayOfWeek = findViewById(R.id.header_dayOfWeek);

        mMorningCond = findViewById(R.id.morning_cond);
        mMorningFeel = findViewById(R.id.morning_feel);
        mMorningMinMaxTemp = findViewById(R.id.morning_minmaxtemp);
        mMorningPressure = findViewById(R.id.morning_pressure);
        mMorningWindSpeed = findViewById(R.id.morning_windspeed);

        mDayCond = findViewById(R.id.day_cond);
        mDayFeel = findViewById(R.id.day_feel);
        mDayMinMaxTemp = findViewById(R.id.day_minmaxtemp);
        mDayPressure = findViewById(R.id.day_pressure);
        mDayWindSpeed = findViewById(R.id.day_windspeed);

        mEveningCond = findViewById(R.id.evening_cond);
        mEveningFeel = findViewById(R.id.evening_feel);
        mEveningMinMaxTemp = findViewById(R.id.evening_minmaxtemp);
        mEveningPressure = findViewById(R.id.evening_pressure);
        mEveningWindSpeed = findViewById(R.id.evening_windspeed);

        mNightCond = findViewById(R.id.night_cond);
        mNightFeel = findViewById(R.id.night_feel);
        mNightMinMaxTemp = findViewById(R.id.night_minmaxtemp);
        mNightPressure = findViewById(R.id.night_pressure);
        mNightWindSpeed = findViewById(R.id.night_windspeed);
    }

    private void initForecast() {
        if (getIntent().getExtras() != null) {
            mForecast = (Forecast) getIntent().getExtras().get(EXTRA_NAME);
        }
    }
}
