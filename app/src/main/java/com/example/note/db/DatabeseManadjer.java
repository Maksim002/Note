package com.example.note.db;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DatabeseManadjer {
    private final String DATABESE_NAME = "Notelist";

    public DatabeseManadjer(Context context){
        Realm.init(context);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name(DATABESE_NAME)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(configuration);
    }
    public Realm getDatabase(){
        return Realm.getDefaultInstance();
    }
}
