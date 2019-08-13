package com.example.note.ui.main;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.note.R;
import com.example.note.model.Note;
import com.example.note.ui.Base.BeseViewHolder;

public class NoteViewHolder extends BeseViewHolder<Note> {
    private TextView textView;
    private ImageButton deleteBtn;
    private Listener listener;

    public NoteViewHolder(@NonNull View itemView, Listener listener) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
        deleteBtn = itemView.findViewById(R.id.delete);
        this.listener = listener;
    }

    @Override
    protected void bind(final Note value) {
        textView.setText(value.getNote());
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDeliteItem(value, getAdapterPosition());
            }
        });
    }

    @Override
    protected void unbind() {
        textView.setText(null);
    }
}
