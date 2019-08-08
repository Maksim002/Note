package com.example.note.ui.Base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BeseViewHolder<T> extends RecyclerView.ViewHolder {
    public BeseViewHolder(@NonNull View itemView) {
        super(itemView);
    }
    protected abstract void bind(T value);

    protected abstract void unbind();
}
