package com.pochekuev.application.main;

import android.os.Bundle;

import com.pochekuev.application.models.TeacherStatements;
import com.pochekuev.application.presenters.IBasePresenter;
import com.pochekuev.application.views.IBaseView;

import java.util.List;

public interface MainContract {

    interface Model {
    }

    interface View extends IBaseView {
        void openStatement(Class<?> activity, Bundle bundle);
        void showError(String message);
        void setDataToRecycler(List<TeacherStatements> teacherStatements);
        void showProgress();
        void hideProgress();
        void logoutAccount(Class<?> activity);
    }

    interface Presenter extends IBasePresenter<View> {
        void onLogoutButtonClicked();
        void onStatementClicked(TeacherStatements teacherStatements);
        void onRecyclerViewReady();
    }

}
