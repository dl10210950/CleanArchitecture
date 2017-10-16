package com.duanlian.cleanarchitecture.data.server;

import com.duanlian.cleanarchitecture.data.model.ResponseModelOne;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by duanlian on 2017/10/16.
 * Description :
 */

public interface Api {
    @GET("/341-1")
    Observable<ResponseModelOne> getJoke(@Query("showapi_appid") String appid,
                                         @Query("showapi_sign") String showapi_sign,
                                         @Query("page") int page);
}
