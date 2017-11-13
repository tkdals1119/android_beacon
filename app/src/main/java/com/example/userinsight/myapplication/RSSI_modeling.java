package com.example.userinsight.myapplication;

/**
 * Created by Userinsight on 2017-11-07.
 */

public class RSSI_modeling {


    private double coefficientNap = 0.7141178; // * 주요 변수 *
    private double coefficientFlap = 0.3912203; // * 주요 변수 *
    private double tx; // * 주요 변수 *

    private double d = 5.0; // 송신기와 핑거프린트 사이의 거리(?)
    private double number_floor = 5.0;
    private double noise_factor = 1.1;

    private double result_rssi;

    public RSSI_modeling() {}

    public RSSI_modeling(double tx)
    {
        this.tx = tx;
    }

    public double CalculateRSSI()
    {

        result_rssi = tx - 10*coefficientNap*Math.log10(d) - 10*coefficientNap*Math.log10(10) - coefficientFlap*number_floor + noise_factor;

        return result_rssi;
    }

}
