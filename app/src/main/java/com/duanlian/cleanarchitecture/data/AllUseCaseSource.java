package com.duanlian.cleanarchitecture.data;

import com.duanlian.cleanarchitecture.data.model.ResponseModelOne;

import io.reactivex.Observable;

/**
 * Created by duanlian on 2017/10/16.
 * Description :所有useCase获取数据的接口,具体实现在实现这个接口的类
 */

public interface AllUseCaseSource {
    //获取某一个useCase的数据
    Observable<ResponseModelOne> getUseCaseOne(String value1, String value2,int value3);
    //获取某一个useCase的数据
    Observable<ResponseModelOne> getUseCaseTwo(String value1);
}
