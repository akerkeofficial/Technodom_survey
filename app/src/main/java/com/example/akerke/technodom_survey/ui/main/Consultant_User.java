package com.example.akerke.technodom_survey.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.akerke.technodom_survey.App;
import com.example.akerke.technodom_survey.R;
import com.example.akerke.technodom_survey.db.DatabaseHelper;
import com.example.akerke.technodom_survey.db.model.DataModel;
import com.example.akerke.technodom_survey.ui.AddDataActivity;
import com.example.akerke.technodom_survey.ui.main.adapter.SomeDataRecyclerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Consultant_User extends AppCompatActivity implements SomeDataRecyclerAdapter.OnDeleteListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultant_user);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        databaseHelper = App.getInstance().getDatabaseInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add: {
                startActivity(new Intent(this, AddDataActivity.class));
                break;
            }
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        SomeDataRecyclerAdapter recyclerAdapter = new SomeDataRecyclerAdapter(this, databaseHelper.getDataDao().getAllData());
        recyclerAdapter.setOnDeleteListener(this);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void onDelete(DataModel dataModel) {
        databaseHelper.getDataDao().delete(dataModel);
    }
}
