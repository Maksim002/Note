package com.example.note.ui.main;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.note.R;
import com.example.note.ui.Base.BeseViewHolder;

public class NoteViewHolder extends BeseViewHolder<String> {
    private TextView textView;

    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
    }

    @Override
    protected void bind(String value) {
        textView.setText(value);
    }

    @Override
    protected void unbind() {
        textView.setText(null);
    }
}
