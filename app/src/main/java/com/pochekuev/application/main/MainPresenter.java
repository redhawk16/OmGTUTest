package com.pochekuev.application.main;

import android.os.Bundle;

import com.pochekuev.application.PreferencesManager;
import com.pochekuev.application.Variables;
import com.pochekuev.application.api.ApiClient;
import com.pochekuev.application.api.OnApiGetResponse;
import com.pochekuev.application.login.LoginActivity;
import com.pochekuev.application.models.Statement;
import com.pochekuev.application.models.TeacherStatements;
import com.pochekuev.application.presenters.BasePresenter;
import com.pochekuev.application.statement.StatementActivity;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private MainContract.Model model;
    private PreferencesManager preferencesManager;

    public MainPresenter(PreferencesManager preferencesManager) {
        this.model = new MainModel();
        this.preferencesManager = preferencesManager;
    }

    @Override
    public void onLogoutButtonClicked() {
        preferencesManager.removeValue(Variables.FNPP_USER);

        getView().logoutAccount(LoginActivity.class);
    }

    @Override
    public void onStatementClicked(TeacherStatements teacherStatements) {
        // TODO: new intent to activity with bundle
        Bundle bundle = new Bundle();
        bundle.putString("nrec", teacherStatements.getNrec());
        getView().openStatement(StatementActivity.class, bundle);

/*        HashMap<String, String> map = new HashMap<>();
        map.put("nrec", teacherStatements.getNrec());

        Call<Statement> call = ApiClient.getInstance()
                .getJsonApi()
                .getStatement(map);

        ApiClient.getResponse(call, new OnApiGetResponse<Statement>() {
            @Override
            public void onGetResponseSuccessfully(Statement responseData) {

            }

            @Override
            public void onGetResponseFailed(Throwable error) {

            }
        });*/

    }

    @Override
    public void onRecyclerViewReady() {
        int fnppUser = preferencesManager.getValue(Variables.FNPP_USER);

        if(fnppUser <= 0) {
            getView().showError("Shared Preferences doesn't contains fnpp user");
            return;
        }

        getView().showProgress();

        HashMap<String, String> map = new HashMap<>();
        map.put("fnpp", String.valueOf(fnppUser));

        Call<List<TeacherStatements>> call = ApiClient.getInstance()
                .getJsonApi()
                .getTeacherStatements(map);

        ApiClient.getResponse(call, new OnApiGetResponse<List<TeacherStatements>>() {
            @Override
            public void onGetResponseSuccessfully(List<TeacherStatements> responseData) {
                if(isViewAttached()) {
                    getView().hideProgress();
                    getView().setDataToRecycler(responseData);
                }
            }

            @Override
            public void onGetResponseFailed(Throwable error) {
                if(isViewAttached()) {
                    getView().hideProgress();
                    getView().showError(error.getMessage());
                }
            }
        });
    }
}
