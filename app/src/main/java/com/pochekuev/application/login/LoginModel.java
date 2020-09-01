package com.pochekuev.application.login;

import com.pochekuev.application.api.ApiClient;
import com.pochekuev.application.api.OnApiGetResponse;
import com.pochekuev.application.models.LoggedUserData;

import retrofit2.Call;

public class LoginModel implements LoginActivityContract.Model {

    @Override
    public void doLogin(String login, String password, OnLoginListener onLoginListener) {
        Call<LoggedUserData> call = ApiClient.getInstance()
                .getJsonApi()
                .getAccountData("https://omgtu.ru/ecab/exauth.php", login, password);

        ApiClient.getResponse(call, new OnApiGetResponse<LoggedUserData>() {
            @Override
            public void onGetResponseSuccessfully(LoggedUserData responseData) {
                if(responseData != null && responseData.getFnpp() > 0) {
                    onLoginListener.onLoginSuccess(responseData);
                } else {
                    onLoginListener.onLoginFailed(new NumberFormatException());
                }
            }

            @Override
            public void onGetResponseFailed(Throwable error) {
                //System.out.println("Error occured while getting request!");

                error.printStackTrace();
                onLoginListener.onLoginFailed(error);
            }
        });
    }
}
