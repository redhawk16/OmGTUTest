package com.pochekuev.application.statement;

import android.os.Bundle;

import com.pochekuev.application.api.OnApiGetResponse;
import com.pochekuev.application.models.Statement;
import com.pochekuev.application.presenters.BasePresenter;

public class StatementPresenter extends BasePresenter<StatementContract.View> implements StatementContract.Presenter {

    private StatementContract.Model model;

    public StatementPresenter() {
        this.model = new StatementModel();
    }

    @Override
    public void onActivityReady(Bundle bundle) {
        if(bundle != null && bundle.containsKey("nrec")) {
            getView().showProgress();

            model.getStatement(bundle.getString("nrec"), new OnApiGetResponse<Statement>() {
                @Override
                public void onGetResponseSuccessfully(Statement responseData) {
                    if(isViewAttached()) {
                        getView().hideProgress();
                        getView().setDataToRecycler(responseData.getListStudents());
                        getView().setDataToViews(responseData);
                    }
                }

                @Override
                public void onGetResponseFailed(Throwable error) {
                    if(isViewAttached()) {
                        getView().hideProgress();
                        getView().showError(error);
                    }
                }
            });
        } else {
            throw new NullPointerException("Require Bundle!");
        }
    }

}
