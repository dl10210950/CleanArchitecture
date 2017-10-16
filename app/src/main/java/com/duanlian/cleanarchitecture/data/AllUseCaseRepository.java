package com.duanlian.cleanarchitecture.data;

import com.duanlian.cleanarchitecture.data.server.Api;
import com.duanlian.cleanarchitecture.data.model.ResponseModelOne;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by duanlian on 2017/10/16.
 * Description :业务具体实现类,可以分开写,一个业务一个Repository,我这里就写一起
 */

public class AllUseCaseRepository implements AllUseCaseSource {
    private final String YIYUAN_BASE_URL = "http://route.showapi.com";
    private Api api;
    public AllUseCaseRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(YIYUAN_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    @Override
    public Observable<ResponseModelOne> getUseCaseOne(String value1, String value2,int page) {
        return api.getJoke(value1,value2,page);
    }

    @Override
    public Observable<ResponseModelOne> getUseCaseTwo(String value1) {
        return null;
    }
}
