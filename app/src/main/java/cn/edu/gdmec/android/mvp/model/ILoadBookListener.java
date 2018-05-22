package cn.edu.gdmec.android.mvp.model;


import cn.edu.gdmec.android.mvp.BookBean;

/**
 * Created by Administrator on 2018/5/15.
 */

public interface ILoadBookListener {
    void onSuccess(BookBean bookBean);

    void onFailure(Exception e);
}
