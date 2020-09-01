package com.pochekuev.application.api;

public interface OnApiGetResponse<T> {

    void onGetResponseSuccessfully(T responseData);
    void onGetResponseFailed(Throwable error);

}
