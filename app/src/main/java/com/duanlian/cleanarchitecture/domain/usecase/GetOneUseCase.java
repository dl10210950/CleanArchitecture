package com.duanlian.cleanarchitecture.domain.usecase;

import com.duanlian.cleanarchitecture.data.AllUseCaseSource;
import com.duanlian.cleanarchitecture.domain.RxUseCase;
import com.duanlian.cleanarchitecture.data.model.ResponseModelOne;

import io.reactivex.Observable;

/**
 * Created by duanlian on 2017/10/16.
 * Description :其中一个业务
 */

public class GetOneUseCase extends RxUseCase<GetOneUseCase.RequestValues,ResponseModelOne> {

    private AllUseCaseSource source;

    public GetOneUseCase(AllUseCaseSource source) {
        this.source = source;
    }

    @Override
    protected Observable<ResponseModelOne> buildUseCaseObservable(RequestValues var1) {
        return source.getUseCaseOne(var1.value1,var1.value2,var1.value3);
    }

    /**
     * 请求所需要的参数
     */
    public static class RequestValues implements RxUseCase.RequestValues {
        private final String value1;
        private final String value2;
        private final int value3;

        public RequestValues(String value1, String value2,int value3) {
            this.value1 = value1;
            this.value2 = value2;
            this.value3 = value3;
        }
    }
}
