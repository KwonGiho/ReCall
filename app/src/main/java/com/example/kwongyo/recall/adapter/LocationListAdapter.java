package com.example.kwongyo.recall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kwongyo.recall.R;
import com.example.kwongyo.recall.model.LocationInfo;

import java.util.List;

import butterknife.Bind;

/**
 * Created by kwongyo on 2016-05-29.
 */
public class LocationListAdapter extends CustomAdapter<LocationInfo,LocationListAdapter.ViewHolder>{
    public LocationListAdapter(Context context,List<LocationInfo> data) {
        super(context,data);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        viewHolder = new ViewHolder(
                inflater.inflate(R.layout.item_location,parent,false)
        );
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LocationInfo locationInfo = mItems.get(position);
        holder.mid.setText(Integer.toString(locationInfo.getMid()));
        holder.lat.setText(Double.toString(locationInfo.getLat()));
        holder.lon.setText(Double.toString(locationInfo.getLon()));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        @Bind(R.id.m_id)
        TextView mid;
        @Bind(R.id.lat)
        TextView lat;
        @Bind(R.id.lon)
        TextView lon;
        public ViewHolder(View v) {
            super(v);
            mView = itemView;
            mid = (TextView)v.findViewById(R.id.m_id);
            lat = (TextView)v.findViewById(R.id.lat);
            lon = (TextView)v.findViewById(R.id.lon);
        }
    }
}
