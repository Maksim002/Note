package com.example.note.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.note.NoteAplication;
import com.example.note.R;
import com.example.note.model.Note;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Listener {
    private RecyclerView recyclerView;
    private EditText editText;
    private ImageButton addButton;
    private NoteAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRecyclerView();
        setupNoteListener();
        getDataFromDB();
    }
    private void setupRecyclerView(){
        recyclerView  = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter = new NoteAdapter(this));
    }

    private void getDataFromDB(){
       List<Note> list = NoteAplication.getServise()
                .getNotes();
        adapter.undate(list);
    }

    private void setupNoteListener(){
        editText = findViewById(R.id.editText);
        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(listener);
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String message = editText.getText().toString();
            Note note = new Note(message);
            adapter.addItem(note);
            NoteAplication.getServise()
                    .saveNote(note);
        }
    };

    @Override
    public void onDeliteItem(Note note, int adapterPosition) {
        NoteAplication.getServise()
                .deleteNote(note);
        adapter.deleteItem(adapterPosition);
    }
}
