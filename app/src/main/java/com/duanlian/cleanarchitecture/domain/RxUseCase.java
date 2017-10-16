package com.duanlian.cleanarchitecture.domain;

import io.reactivex.Observable;

/**
 * Created by duanlian on 2017/10/16.
 * Description :base UseCase
 */

public abstract class RxUseCase<Q, P> {
    public RxUseCase() {
    }

    public Observable<P> executeUseCase(Q requestValues) {
        return buildUseCaseObservable(requestValues);
    }

    public Observable<P> executeUseCase() {
        return this.executeUseCase(null);
    }

    protected abstract Observable<P> buildUseCaseObservable(Q var1);
    public interface ResponseValue {
    }

    public interface RequestValues {
    }

}
