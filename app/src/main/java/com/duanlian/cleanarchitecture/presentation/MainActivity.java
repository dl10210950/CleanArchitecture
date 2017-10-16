package com.duanlian.cleanarchitecture.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.duanlian.cleanarchitecture.R;
import com.duanlian.cleanarchitecture.data.model.ResponseModelOne;

public class MainActivity extends AppCompatActivity implements Contract.MainView {
    private MainPresenter mPresenter;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainPresenter(this);
        mPresenter.getData(2);
        textView = (TextView) findViewById(R.id.tv);
    }

    @Override
    public void showError() {
        textView.setText("Error");
    }

    @Override
    public void showSuccess(ResponseModelOne responseModelOne) {
        String text = responseModelOne.getShowapi_res_body().getContentlist().get(0).getText();
        textView.setText(text);
    }
}
