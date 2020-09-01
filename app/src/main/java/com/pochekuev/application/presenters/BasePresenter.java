package com.pochekuev.application.presenters;

import com.pochekuev.application.views.IBaseView;

public abstract class BasePresenter<T extends IBaseView> implements IBasePresenter<T> {

    private T view;

    public T getView() {
        return view;
    }

    protected boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void destroy() {

    }

}
