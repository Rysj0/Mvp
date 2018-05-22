package cn.edu.gdmec.android.mvp.model;

import cn.edu.gdmec.android.mvp.WeatherBean;
import cn.edu.gdmec.android.mvp.utils.OkHttpUtils;

/**
 * Created by apple on 18/5/15.
 */

public class WeatherModel implements IWeatherModel {

    @Override
    public void loadWeather(String url, final ILoadlistener loadlistener) {
        OkHttpUtils.ResultCallback resultCallback = new OkHttpUtils.ResultCallback(){

            @Override
            public void getWeather(WeatherBean weatherBean) {
                loadlistener.onSuccess(weatherBean);
            }

            @Override
            public void onFailure(Exception e) {
                loadlistener.onFailure(e);

            }
        };
        OkHttpUtils.getResultCallback(url,resultCallback);

    }
}
