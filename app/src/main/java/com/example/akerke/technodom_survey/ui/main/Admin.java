package com.example.akerke.technodom_survey.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.akerke.technodom_survey.R;


public class Admin extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Button consultant = (Button)findViewById(R.id.consultant);
        consultant.setOnClickListener(this);
        Button question = (Button)findViewById(R.id.question);
        question.setOnClickListener(this);
        Button client = (Button)findViewById(R.id.client);
        client.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case  R.id.consultant: {
                startActivity(new Intent(this, Consultant.class));
                break;
            }

            case R.id.question: {
                startActivity(new Intent(this, Question.class));
                break;
            }
            case R.id.client: {
                startActivity(new Intent(this, Client.class));
                break;
            }
        }
    }
}
