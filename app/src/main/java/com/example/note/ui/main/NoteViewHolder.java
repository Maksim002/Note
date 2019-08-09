package com.example.note.ui.main;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.note.R;
import com.example.note.model.Note;
import com.example.note.ui.Base.BeseViewHolder;

public class NoteViewHolder extends BeseViewHolder<Note> {
    private TextView textView;

    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
    }

    @Override
    protected void bind(Note value) {
        textView.setText(value.getNote());
    }

    @Override
    protected void unbind() {
        textView.setText(null);
    }
}
