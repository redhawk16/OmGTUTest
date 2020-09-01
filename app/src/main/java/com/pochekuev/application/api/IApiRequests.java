package com.pochekuev.application.api;

import com.pochekuev.application.models.Statement;
import com.pochekuev.application.models.TeacherStatements;
import com.pochekuev.application.models.LoggedUserData;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface IApiRequests {

    /**
     * Request for authorization user by login and password
     * @param login - user login name on university site
     * @param password - user password on university site
     * @return user account data {@link LoggedUserData}
     */
    //@GET("/ecab/exauth.php")
    @GET
    public Call<LoggedUserData> getAccountData(
            @Url String url,
            @Query("l") String login,
            @Query("p") String password
    );

    /**
     *
     * @param fnppUser
     * @return
     */
    @POST("/fnppList")
    public Call<List<TeacherStatements>> getTeacherStatements(
            @Body HashMap<String, String> fnppUser
    );

    /**
     *
     * @param nrecStatement
     * @return
     */
    @POST("/getListStruct")
    public Call<Statement> getStatement(
            @Body HashMap<String, String> nrecStatement
    );
}
