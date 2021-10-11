package com.secondwarranty.app.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.secondwarranty.app.R;

public class HelpCentreActivity extends AppCompatActivity {

    MaterialCardView materialCardView1,materialCardView2,materialCardView3,materialCardView4,
            materialCardView_et1,materialCardView_et2,materialCardView_et3,materialCardView_et4;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_centre);
        materialCardView1 = findViewById(R.id.service_experience);
        materialCardView2 = findViewById(R.id.materialCard2);
        materialCardView3 = findViewById(R.id.materialCard3);
        materialCardView4 = findViewById(R.id.materialCard4);
        materialCardView_et1 = findViewById(R.id.et_cardView1);
        materialCardView_et2 = findViewById(R.id.et_cardView2);
        materialCardView_et3 = findViewById(R.id.et_cardView3);
        materialCardView_et4 = findViewById(R.id.et_cardView4);




        materialCardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialCardView_et1.setVisibility(View.VISIBLE);
                materialCardView_et2.setVisibility(View.GONE);
                materialCardView_et3.setVisibility(View.GONE);
                materialCardView_et4.setVisibility(View.GONE);
                submit.setVisibility(View.VISIBLE);
            }
        });
        materialCardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialCardView_et2.setVisibility(View.VISIBLE);
                materialCardView_et1.setVisibility(View.GONE);
                materialCardView_et3.setVisibility(View.GONE);
                materialCardView_et4.setVisibility(View.GONE);
                submit.setVisibility(View.VISIBLE);
            }
        });
        materialCardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialCardView_et3.setVisibility(View.VISIBLE);
                materialCardView_et1.setVisibility(View.GONE);
                materialCardView_et2.setVisibility(View.GONE);
                materialCardView_et4.setVisibility(View.GONE);
                submit.setVisibility(View.VISIBLE);
            }
        });
        materialCardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialCardView_et4.setVisibility(View.VISIBLE);
                materialCardView_et1.setVisibility(View.GONE);
                materialCardView_et2.setVisibility(View.GONE);
                materialCardView_et3.setVisibility(View.GONE);
                submit.setVisibility(View.VISIBLE);
            }
        });
        submit = findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelpCentreActivity.this,DashboardActivity.class);
                startActivity(intent);
                Toast.makeText(HelpCentreActivity.this, "Response Submitted Successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}