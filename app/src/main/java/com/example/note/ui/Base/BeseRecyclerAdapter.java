package com.example.note.ui.Base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BeseRecyclerAdapter<V extends BeseViewHolder, T> extends RecyclerView.Adapter<V> {
    private List<T> list = new ArrayList<>();

    @NonNull
    @Override
    public V onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(getLaioutRes(), parent, false);
        return getViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull V holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public void onViewRecycled(@NonNull V holder) {
        super.onViewRecycled(holder);
        holder.unbind();
    }

    public void undate(List<T> newDate) {
            this.list = newDate;
            notifyDataSetChanged();
    }

    public void addItem(T data){
        this.list.add(0, data);
        notifyItemInserted(0);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    @LayoutRes
    protected abstract int getLaioutRes();

    protected abstract V getViewHolder(View view);

    public List<T> getList(){
        return list;
    }

    public void deleteItem(int adapterPosition) {
            list.remove(adapterPosition);
            notifyItemRemoved(adapterPosition);
    }
}
