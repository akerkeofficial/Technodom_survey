package com.example.akerke.technodom_survey.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.akerke.technodom_survey.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button admin = (Button)findViewById(R.id.admin);
        admin.setOnClickListener(this);
        Button user = (Button)findViewById(R.id.user);
        user.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case  R.id.admin: {
                startActivity(new Intent(this, Admin.class));
                break;
            }

            case R.id.user: {
                startActivity(new Intent(this, User.class));
                break;
            }
        }
    }
}

