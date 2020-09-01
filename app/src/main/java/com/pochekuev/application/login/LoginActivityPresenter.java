package com.pochekuev.application.login;

import com.pochekuev.application.PreferencesManager;
import com.pochekuev.application.Variables;
import com.pochekuev.application.models.LoggedUserData;
import com.pochekuev.application.presenters.BasePresenter;

public class LoginActivityPresenter extends BasePresenter<LoginActivityContract.View> implements LoginActivityContract.Presenter {

    private LoginActivityContract.Model model;
    private PreferencesManager preferencesManager;

    public LoginActivityPresenter(PreferencesManager preferencesManager) {
        model = new LoginModel();
        this.preferencesManager = preferencesManager;
    }

    @Override
    public boolean validateCredentials(String login, String password) {
        return !login.isEmpty() && !password.isEmpty();
    }

    @Override
    public void onLoginButtonClicked(String login, String password) {
        getView().showProgress();

        model.doLogin(login, password, new LoginActivityContract.Model.OnLoginListener() {
            @Override
            public void onLoginSuccess(LoggedUserData loggedUserData) {
                getView().onSuccess("Login successfully!");

                getView().hideProgress();

                // Save Fnpp User to SharedPreferences
                preferencesManager.setValue(Variables.FNPP_USER, loggedUserData.getFnpp());
            }

            @Override
            public void onLoginFailed(Throwable error) {
                getView().onError("Login failed, check your credentials or try again later");

                getView().hideProgress();
            }
        });
    }
}
