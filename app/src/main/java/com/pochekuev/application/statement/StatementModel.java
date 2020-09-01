package com.pochekuev.application.statement;

import com.pochekuev.application.api.ApiClient;
import com.pochekuev.application.api.OnApiGetResponse;
import com.pochekuev.application.models.Statement;

import java.util.HashMap;

import retrofit2.Call;

public class StatementModel implements StatementContract.Model {

    @Override
    public void getStatement(String nrec, OnApiGetResponse<Statement> onApiGetResponse) {
        HashMap<String, String> map = new HashMap<>();
        map.put("nrec", nrec);

        Call<Statement> call = ApiClient.getInstance()
                .getJsonApi()
                .getStatement(map);

        ApiClient.getResponse(call, onApiGetResponse);
    }
}
