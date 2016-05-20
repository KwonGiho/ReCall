package com.example.kwongyo.recall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kwongyo on 2016-05-20.
 */
public abstract class CustomAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    protected final Context context;
    protected List<T> mItems;

    public void add(T item) {
        int position = getItemCount();
        mItems.add(item);
        notifyDataSetChanged();
    }
    public void remove(int position) {
        if(position<getItemCount()) {
            mItems.remove(position);
            notifyDataSetChanged();
        }
    }
    public void remove(T item) {
        int position = mItems.indexOf(item);
    }
    public void clear() {
        int count = mItems.size();
        if( count > 0 ) {
            mItems.clear();
            notifyDataSetChanged();
        }
    }
    public CustomAdapter(Context context,List<T> data) {
        this.context=context;
        if(data!=null) {
            mItems= data;
        }
        else
            mItems = new ArrayList<T>();
    }
    @Override
    public int getItemCount(){return this.mItems.size();}
    public List<T> getItems(){return mItems;}
}
