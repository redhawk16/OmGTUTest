package com.pochekuev.application.presenters;

import com.pochekuev.application.views.IBaseView;

public interface IBasePresenter<V extends IBaseView> {

    // Метод для передачи/привязывания View к Presenter'y
    void attachView(V view);

    // Отвязывание View от Presenter'a
    void detachView();

    // Уведомление Presenter'а о том, что View уничтожается
    void destroy();

}
