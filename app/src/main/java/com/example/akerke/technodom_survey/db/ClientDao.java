package com.example.akerke.technodom_survey.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


import com.example.akerke.technodom_survey.db.model.ClientModel;

import java.util.List;


@Dao
public interface ClientDao {
    @Insert
    void insert(ClientModel clientModel);

    @Delete
    void delete(ClientModel clientModel);

    @Query("SELECT * FROM ClientModel")
    List<ClientModel> getAllData();
}
