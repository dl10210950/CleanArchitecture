package com.duanlian.cleanarchitecture.presentation;

import com.duanlian.cleanarchitecture.data.model.ResponseModelOne;

/**
 * Created by duanlian on 2017/10/16.
 * Description :
 */

public interface Contract {
    interface MainView {
        void showError();

        void showSuccess(ResponseModelOne responseModelOne);
    }

    interface Presenter {
        void onError();

        void onSuccess(ResponseModelOne responseModelOne);

        void getData(int page);
    }
}
