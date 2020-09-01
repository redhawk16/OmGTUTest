package com.pochekuev.application.statement;

import android.os.Bundle;

import com.pochekuev.application.api.OnApiGetResponse;
import com.pochekuev.application.models.Statement;
import com.pochekuev.application.models.Student;
import com.pochekuev.application.presenters.IBasePresenter;
import com.pochekuev.application.views.IBaseView;

import java.util.List;

public interface StatementContract {

   interface Model {
      void getStatement(String nrec, OnApiGetResponse<Statement> onApiGetResponse);
   }

   interface View extends IBaseView {
      void setDataToViews(Statement statement);
      void setDataToRecycler(List<Student> studentsList);
      void showError(Throwable error);
      void showProgress();
      void hideProgress();
   }

   interface Presenter extends IBasePresenter<View> {
      void onActivityReady(Bundle bundle);
   }

}
