package cn.edu.gdmec.android.mvp.presenter;

import cn.edu.gdmec.android.mvp.View.IWeatherView;
import cn.edu.gdmec.android.mvp.WeatherBean;
import cn.edu.gdmec.android.mvp.model.ILoadlistener;
import cn.edu.gdmec.android.mvp.model.IWeatherModel;
import cn.edu.gdmec.android.mvp.model.WeatherModel;

/**
 * Created by apple on 18/5/15.
 */

public class WearherPresenter implements  IWeatherPresenter,ILoadlistener {
    private String url = "https://www.sojson.com/open/api/weather/json.shtml?city=";

    private IWeatherView iweatherView;
    private IWeatherModel iWeatherModel;
    public WearherPresenter(IWeatherView iweatherView){
        this.iweatherView = iweatherView;
        this.iWeatherModel = new WeatherModel();
    }


    @Override
    public void loadWeather(String city) {
        this.iweatherView.showProgress();
        this.iWeatherModel.loadWeather(url+city,this);

    }

    @Override
    public void onSuccess(WeatherBean bean) {
        iweatherView.hideProgress();
        iweatherView.showWeatnerData(bean);

    }

    @Override
    public void onFailure(Exception e) {
        iweatherView.hideProgress();
        iweatherView.showLoadFailMsg(e);
    }
}
