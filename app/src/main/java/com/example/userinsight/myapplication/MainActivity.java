package com.example.userinsight.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "테스트";
    @BindView(R.id.tx_power) EditText text_tx_power;
    @BindView(R.id.rssi) EditText text_rssi;
    @BindView(R.id.distance) EditText text_distance;
    @BindView(R.id.result) Button result;

    RSSI_modeling rssi_m;
    Transmitter_location_estimation tle = new Transmitter_location_estimation();

    private double tx_power;
    private double rssi;

    @OnClick(R.id.result)
    void onClickResultBt()
    {
        if(TextUtils.isEmpty(text_tx_power.getText()) || TextUtils.isEmpty(text_rssi.getText()))
        {
            Toast.makeText(this, "숫자를 입력해주세요.", Toast.LENGTH_SHORT).show();
        }
        else
        {
           this.tx_power = Double.parseDouble(text_tx_power.getText().toString());
           this.rssi = Double.parseDouble(text_rssi.getText().toString());

            rssi_m = new RSSI_modeling(tx_power);
            String result = String.valueOf(rssi_m.CalculateRSSI()); // 핑거프린트로 측정한 RSSI, B번식

            text_distance.setText(result);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }
}
