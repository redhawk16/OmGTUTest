package com.pochekuev.application.statement;

import com.pochekuev.application.presenters.IBasePresenter;
import com.pochekuev.application.views.IBaseView;

public interface StatementContract {

   interface Model {

   }

   interface View extends IBaseView {

   }

   interface Presenter extends IBasePresenter<View> {

   }

}
