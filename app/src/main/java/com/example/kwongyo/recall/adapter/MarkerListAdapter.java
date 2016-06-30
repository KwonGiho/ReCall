package com.example.kwongyo.recall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kwongyo.recall.R;
import com.example.kwongyo.recall.activitySupport.MarkerListItem;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Daesub on 2016-06-30.
 */
public class MarkerListAdapter extends RecyclerView.Adapter<MarkerListAdapter.MarkerListViewHolder> {

    private List<MarkerListItem> itemSet;
    private Context context;

    public static class MarkerListViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.markerEventImgv)
        ImageView markerEventImgv;

        @Bind(R.id.markerEventText)
        TextView markerEventText;

        @Bind(R.id.markerCity)
        TextView markerCity;

        @Bind(R.id.markerDate)
        TextView markerDate;


        public MarkerListViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

    }

    public MarkerListAdapter(Context context, List<MarkerListItem> itemSet) {
        this.itemSet = itemSet;
        this.context = context;
    }

    public MarkerListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MarkerListViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        viewHolder = new MarkerListViewHolder(
                inflater.inflate(R.layout.marker_list_item, parent, false)
        );
        return viewHolder;
    }

    public void onBindViewHolder( MarkerListViewHolder holder, int position ) {
        MarkerListItem item = itemSet.get(position);

        /*Glide.with(context)
                .load("R.drawable." + item.getImgUrl())
                .into(holder.markerEventImgv);*/

        holder.markerEventText.setText(item.getEvent());
        holder.markerCity.setText(item.getCity());
        holder.markerDate.setText(item.getDate());

    }

    public int getItemCount() {
        return itemSet.size();
    }

}
