package com.example.note.db;

import com.example.note.model.Note;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class DatabeseServise {
    private Realm realm;

    public DatabeseServise(Realm database) {
        this.realm = database;
    }

    public void saveNotes(final List<Note> list) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(Note.class).findAll();
                realm.copyToRealmOrUpdate(list);
            }
        });
    }
    public List<Note> getNotes() {
       RealmResults<Note> results = realm.where(Note.class).findAllSorted("data", Sort.DESCENDING);
       if (results == null){
           return new ArrayList<>();
       }
       return realm.copyFromRealm(results);
    }
}
