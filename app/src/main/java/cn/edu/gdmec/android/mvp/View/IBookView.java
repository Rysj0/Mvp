package cn.edu.gdmec.android.mvp.View;


import cn.edu.gdmec.android.mvp.BookBean;

/**
 * Created by Administrator on 2018/5/15.
 */

public interface IBookView {
    void showBook(BookBean bookBean);

    void showProgress();

    void hideProgress();

    void showLoadFailMsg(Exception e);

}
