package com.example.kwongyo.recall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kwongyo.recall.activitySupport.MarkerListItem;
import com.example.kwongyo.recall.adapter.MarkerListAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Daesub on 2016-06-30.
 */
public class MarkerListActivity extends AppCompatActivity {
    @Bind(R.id.markerRecyclerView)
    RecyclerView markerRecyclerView;
    private MarkerListAdapter markerListAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marker_list_activity);
        ButterKnife.bind(this);


        markerRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        /* 아래 부분은 DB나 서버에서 Marker 정보를 가져와서 진행 해야함. */
        ArrayList<MarkerListItem> items = new ArrayList<MarkerListItem>();
        for(int i=0; i<10; i++ ) {
            items.add(new MarkerListItem("recall_logo.png", "사진 찰칵", "Busan, Republic of Korea", "6월 29일"));
        }

        markerListAdapter = new MarkerListAdapter(getApplicationContext(), items);

        markerRecyclerView.setAdapter(markerListAdapter);

    }

}
