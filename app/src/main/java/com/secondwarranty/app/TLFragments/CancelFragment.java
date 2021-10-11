package com.secondwarranty.app.TLFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.secondwarranty.app.Dashboard.DashboardActivity;
import com.secondwarranty.app.R;
import com.secondwarranty.app.ResponseModel.GetOrderDetails.Result;
import com.secondwarranty.app.ViewModel.DataViewModel;


public class CancelFragment extends AppCompatActivity {

    Button cancel;
    DataViewModel dataViewModel;
    String cancellation_reason = "";
    RadioButton radio_btn1,radio_btn2,radio_btn3,radio_btn4,radio_btn5,radio_btn6,radio_btn7;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_ftab3);
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        cancel = findViewById(R.id.btn_cancel);
        radio_btn1 = findViewById(R.id.radio_btn1);
        radio_btn2 = findViewById(R.id.radio_btn2);
        radio_btn3 = findViewById(R.id.radio_btn3);
        radio_btn4 = findViewById(R.id.radio_btn4);
        radio_btn5 = findViewById(R.id.radio_btn5);
        radio_btn6 = findViewById(R.id.radio_btn6);
        radio_btn7 = findViewById(R.id.radio_btn7);

    }

    public void cancel_reason(View view) {

        cancellation();
    }

    private void cancellation() {

        dataViewModel.getCancellation(getApplicationContext(),cancellation_reason)
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.Cancellation.Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.Cancellation.Result result) {

                        if (result != null) {

                            Intent intent = new Intent(CancelFragment.this, DashboardActivity.class);
                            startActivity(intent);
                            finish();

                        }
                    }
                });
    }

    public void others_btn(View view) {

        cancellation_reason = radio_btn1.getText().toString();
    }

    public void placed_btn(View view) {

        cancellation_reason = radio_btn2.getText().toString();
    }

    public void professional_btn(View view) {

        cancellation_reason = radio_btn3.getText().toString();
    }

    public void hired_btn(View view) {

        cancellation_reason = radio_btn4.getText().toString();
    }

    public void concerned_btn(View view) {

        cancellation_reason = radio_btn5.getText().toString();
    }

    public void service_btn(View view) {

        cancellation_reason = radio_btn6.getText().toString();
    }

    public void society_btn(View view) {

        cancellation_reason = radio_btn7.getText().toString();
    }
}