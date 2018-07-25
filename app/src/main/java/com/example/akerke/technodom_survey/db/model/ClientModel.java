package com.example.akerke.technodom_survey.db.model;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;




@Entity
public class ClientModel {

    @NonNull
    @PrimaryKey
    private String name;
    private String number;

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) { this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

