package com.example.akerke.technodom_survey.ui.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;


import com.example.akerke.technodom_survey.App;
import com.example.akerke.technodom_survey.R;
import com.example.akerke.technodom_survey.db.DatabaseHelper;
import com.example.akerke.technodom_survey.db.model.ClientModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class User extends AppCompatActivity {

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.number)
    EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.save)
    public void onSaveClick() {
        DatabaseHelper databaseHelper = App.getInstance().getDatabaseInstance();

        ClientModel model = new ClientModel();
        model.setName(name.getText().toString());
        model.setNumber(number.getText().toString());
        databaseHelper.getClientDao().insert(model);

        finish();
        Toast toast = Toast.makeText(this, "Successful",Toast.LENGTH_LONG);
        toast.show();
        startActivity(new Intent(this, Consultant_User.class));
    }
}
