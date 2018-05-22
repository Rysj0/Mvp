package cn.edu.gdmec.android.mvp.presenter;


import cn.edu.gdmec.android.mvp.BookBean;
import cn.edu.gdmec.android.mvp.View.IBookView;
import cn.edu.gdmec.android.mvp.model.BookModel;
import cn.edu.gdmec.android.mvp.model.IBookModel;
import cn.edu.gdmec.android.mvp.model.ILoadBookListener;

/**
 * Created by Administrator on 2018/5/15.
 */

public class BookPresenter implements ILoadBookListener,IBookPresenter{

    private String url="https://api.douban.com/v2/book/search?q=";

    private IBookView iBookView;
    private IBookModel iBookModel;

    public BookPresenter(IBookView iBookView) {
        this.iBookModel=new BookModel();
        this.iBookView=iBookView;
    }

    @Override
    public void onSuccess(BookBean bookBean) {
        iBookView.hideProgress();
        iBookView.showBook(bookBean);
    }

    @Override
    public void onFailure(Exception e) {
        iBookView.hideProgress();
        iBookView.showLoadFailMsg(e);
    }

    @Override
    public void loadBook(String bookName) {
        iBookView.showProgress();
        iBookModel.loadBook(url+bookName,this);
    }
}
