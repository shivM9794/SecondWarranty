package com.secondwarranty.app.LoginAndSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.secondwarranty.app.R;

public class SetNewPasswordActivity extends AppCompatActivity {
    
    TextInputEditText ed_password,ed_password1;
    Button btn_set_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);
        ed_password = findViewById(R.id.ed_password);
        ed_password1 = findViewById(R.id.ed_password1);
        btn_set_password = findViewById(R.id.btn_set_password);
    }

    public void updatePassword(View view) {
        newPassword();
    }

    private void newPassword() {
    }
}