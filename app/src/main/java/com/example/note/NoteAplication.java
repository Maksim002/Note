package com.example.note;

import android.app.Application;

import com.example.note.db.DatabeseManadjer;
import com.example.note.db.DatabeseServise;

public class NoteAplication extends Application {
    private static NoteAplication INSTANCE;
    private static DatabeseManadjer databeseManadjer;
    private static DatabeseServise servise;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
    public static DatabeseManadjer getDatabeseManadjer(){
        if (databeseManadjer == null){
            databeseManadjer = new DatabeseManadjer(INSTANCE);
        }
        return databeseManadjer;
    }

    public static DatabeseServise getServise(){
        if (servise == null){
            servise = new DatabeseServise(getDatabeseManadjer().getDatabase());
        }
        return servise;
    }
}
