package com.pochekuev.application.login;

import com.pochekuev.application.models.LoggedUserData;
import com.pochekuev.application.presenters.IBasePresenter;
import com.pochekuev.application.views.IBaseView;

public interface LoginActivityContract {

    interface View extends IBaseView {
        void showProgress();
        void hideProgress();
        void onSuccess(String message);
        void onError(String message);
    }

    interface Presenter extends IBasePresenter<View> {
        boolean validateCredentials(String login, String password);
        void onLoginButtonClicked(String login, String password);
    }

    interface Model {
        interface OnLoginListener {
            void onLoginSuccess(LoggedUserData loggedUserData);
            void onLoginFailed(Throwable error);
        }

        void doLogin(String login, String password, OnLoginListener onLoginListener);
    }

}
