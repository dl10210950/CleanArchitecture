package com.duanlian.cleanarchitecture.presentation;

import com.duanlian.cleanarchitecture.data.AllUseCaseRepository;
import com.duanlian.cleanarchitecture.data.model.ResponseModelOne;
import com.duanlian.cleanarchitecture.domain.usecase.GetOneUseCase;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by duanlian on 2017/10/16.
 * Description :MainActivity的presenter
 */

public class MainPresenter implements Contract.Presenter {
    private Contract.MainView mView;
    private GetOneUseCase getOneUseCase;

    public MainPresenter(Contract.MainView view) {
        this.mView = view;
        getOneUseCase = new GetOneUseCase(new AllUseCaseRepository());
    }

    @Override
    public void onError() {
        mView.showError();
    }

    @Override
    public void onSuccess(ResponseModelOne responseModelOne) {
        mView.showSuccess(responseModelOne);
    }

    @Override
    public void getData(int page) {
        getOneUseCase.executeUseCase(
                new GetOneUseCase.RequestValues("41446", "20dd11eedac1404897d01af26d501373", page))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseModelOne>() {
                    @Override
                    public void accept(ResponseModelOne responseModelOne) throws Exception {
                        onSuccess(responseModelOne);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        onError();
                    }
                });
    }
}
