package cn.edu.gdmec.android.mvp.model;

/**
 * Created by Administrator on 2018/5/15.
 */

public interface IBookModel {
    void loadBook(String url, ILoadBookListener iLoadBookListener);
}
