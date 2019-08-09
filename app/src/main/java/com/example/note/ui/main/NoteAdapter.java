package com.example.note.ui.main;

import android.view.View;

import com.example.note.R;
import com.example.note.model.Note;
import com.example.note.ui.Base.BeseRecyclerAdapter;

public class NoteAdapter extends BeseRecyclerAdapter<NoteViewHolder, Note> {

    @Override
    protected int getLaioutRes() {
        return R.layout.item_note;
    }

    @Override
    protected NoteViewHolder getViewHolder(View view) {
        return new NoteViewHolder(view);

    }

}
