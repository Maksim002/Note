package com.example.note.db;

import com.example.note.model.Note;


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
       RealmResults<Note> results = realm.where(Note.class).findAllSorted("date", Sort.DESCENDING);
       if (results == null){
           return new ArrayList<>();
       }
       return realm.copyFromRealm(results);
    }

    public void saveNote(final Note note) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(note);
            }
        });
    }

    public void deleteNote(final Note note) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Note result = realm.where(Note.class).equalTo("id", note.getId()).findFirst();
                if (result != null) {
                    result.deleteFromRealm();
                }
            }
        });

    }
}
