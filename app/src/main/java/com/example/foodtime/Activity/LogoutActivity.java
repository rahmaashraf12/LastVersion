package com.example.foodtime.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.foodtime.R;

public class LogoutActivity extends AppCompatActivity {
Button logout;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LogoutActivity.this, loginActivity.class);
                startActivity(i);
                finish();
            }
        });
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn =findViewById(R.id.homeBtn_Card);
        LinearLayout cartBtn = findViewById(R.id.CardBtn_again);
        LinearLayout settingBtn=findViewById(R.id.homebtn_setting);
        LinearLayout map=findViewById(R.id.out_Google_Map);

        homeBtn.setOnClickListener((v -> {
            startActivity(new Intent(LogoutActivity.this,MainActivity.class));
        }));

        cartBtn.setOnClickListener((v -> {
            startActivity(new Intent(LogoutActivity.this,CartActivity.class));
        }));
        settingBtn.setOnClickListener((v -> {
            startActivity(new Intent(LogoutActivity.this, LogoutActivity.class));
        }));

        map.setOnClickListener((v -> {
            startActivity(new Intent(LogoutActivity.this, My_Map_Activity.class));
        }));
    }
}