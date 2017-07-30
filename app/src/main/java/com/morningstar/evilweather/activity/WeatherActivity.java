package com.morningstar.evilweather.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.morningstar.evilweather.R;
import com.morningstar.evilweather.gson.Weather;
import com.morningstar.evilweather.util.Utility;

/**
 * Created by morningstar on 2017/7/30.
 */
public class WeatherActivity extends AppCompatActivity {

    private ScrollView mWeatherLayout;

    private TextView mTitleCity, mTitleUpdateTime, mDegreeText, mWeatherInfoText, mAqiText, mPM25Text, mComfortText, mCarWashText, mSportText;

    private LinearLayout mForecastLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        //初始化控件
        initViews();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String weatherString = prefs.getString("weather",null);
        if(weatherString != null){
            //有缓存时直接解析天气数据
            Weather weather = Utility.handleWeatherResponse(weatherString);
            showWeatherInfo(weather);
        }
    }

    /**
     * 处理并展示 Weather 实体类中的数据
     * @param weather 天气数据
     */
    private void showWeatherInfo(Weather weather) {
        
    }

    private void initViews() {
        mWeatherLayout = (ScrollView) findViewById(R.id.weather_layout);
        mTitleCity = (TextView) findViewById(R.id.title_city);
        mTitleUpdateTime = (TextView) findViewById(R.id.title_update_time);
        mDegreeText = (TextView) findViewById(R.id.degree_text);
        mWeatherInfoText = (TextView) findViewById(R.id.weather_info_text);
        mAqiText = (TextView) findViewById(R.id.aqi_text);
        mPM25Text = (TextView) findViewById(R.id.pm25_text);
        mComfortText = (TextView) findViewById(R.id.comfort_text);
        mCarWashText = (TextView) findViewById(R.id.car_wash_text);
        mSportText = (TextView) findViewById(R.id.sport_text);
        mForecastLayout = (LinearLayout) findViewById(R.id.forecast_layout);
    }
}
