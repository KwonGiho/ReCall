package com.example.kwongyo.recall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.kwongyo.recall.R;
import com.example.kwongyo.recall.activitySupport.Image;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by kwongyo on 2016-05-20.
 */
public class ReCallAdapter extends CustomAdapter<Image, ReCallAdapter.RecallViewHolder> {
    public ReCallAdapter(Context context,List<Image> data) { super(context,data);}
   @Override
   public RecallViewHolder onCreateViewHolder(ViewGroup parent , int viewType ) {
       RecallViewHolder viewHolder;
       LayoutInflater inflater = LayoutInflater.from(parent.getContext());

       viewHolder = new RecallViewHolder(
               inflater.inflate(R.layout.item_recall,parent,false)
       );
       return viewHolder;
   }
    @Override
    public void onBindViewHolder(RecallViewHolder holder,int position) {
        Image Image = mItems.get(position);
        Glide.with(context)
                .load(Image.getUrl())
                .into(holder.imgvRecall);


    }

    public static class RecallViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        @Bind(R.id.imgvRecall)
        ImageView imgvRecall;

        public RecallViewHolder(View v) {
            super(v);
            mView = itemView;
            imgvRecall = (ImageView) v.findViewById(R.id.imgvRecall);
        }

    }

}
