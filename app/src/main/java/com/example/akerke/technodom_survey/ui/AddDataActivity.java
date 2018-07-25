package com.example.akerke.technodom_survey.ui;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;


import com.example.akerke.technodom_survey.App;
import com.example.akerke.technodom_survey.R;
import com.example.akerke.technodom_survey.db.DatabaseHelper;
import com.example.akerke.technodom_survey.db.model.DataModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AddDataActivity extends AppCompatActivity {

    @BindView(R.id.title)
    EditText title;
    @BindView(R.id.description)
    EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.save)
    public void onSaveClick() {
        DatabaseHelper databaseHelper = App.getInstance().getDatabaseInstance();

        DataModel model = new DataModel();
        model.setTitle(title.getText().toString());
        model.setDescription(description.getText().toString());
        databaseHelper.getDataDao().insert(model);

        finish();
    }
}