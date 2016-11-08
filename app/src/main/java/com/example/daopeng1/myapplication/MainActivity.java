package com.example.daopeng1.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    MyView mView;
    SeekBar seekBar1,seekBar2,seekBar3,seekBar4,seekBar5,seekBar6,seekBar7;
    private float precent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mView= (MyView) findViewById(R.id.view);

        seekBar1= (SeekBar) findViewById(R.id.seekbar1);
        seekBar1.setOnSeekBarChangeListener(this);
        seekBar2= (SeekBar) findViewById(R.id.seekbar2);
        seekBar2.setOnSeekBarChangeListener(this);
        seekBar3= (SeekBar) findViewById(R.id.seekbar3);
        seekBar3.setOnSeekBarChangeListener(this);
        seekBar4= (SeekBar) findViewById(R.id.seekbar4);
        seekBar4.setOnSeekBarChangeListener(this);
        seekBar5= (SeekBar) findViewById(R.id.seekbar5);
        seekBar5.setOnSeekBarChangeListener(this);
        seekBar6= (SeekBar) findViewById(R.id.seekbar6);
        seekBar6.setOnSeekBarChangeListener(this);
        seekBar7= (SeekBar) findViewById(R.id.seekbar7);
        seekBar7.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        precent = (float) progress/100;
        switch(seekBar.getId()){
            case R.id.seekbar1:
                mView.setNum1(precent);
                break;
            case R.id.seekbar2:
                mView.setNum2(precent);
                break;
            case R.id.seekbar3:
                mView.setNum3(precent);
                break;
            case R.id.seekbar4:
                mView.setNum4(precent);
                break;
            case R.id.seekbar5:
                mView.setNum5(precent);
                break;
            case R.id.seekbar6:
                mView.setNum6(precent);
                break;
            case R.id.seekbar7:
                mView.setNum7(precent);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
