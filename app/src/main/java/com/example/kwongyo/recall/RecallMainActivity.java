package com.example.kwongyo.recall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.kwongyo.recall.adapter.ReCallAdapter;
import com.example.kwongyo.recall.core.RecallMainController;
import com.example.kwongyo.recall.model.GpsInfo;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

/**
 * Created by kwongyo on 2016-05-20.
 */
public class RecallMainActivity extends AppCompatActivity{
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    ReCallAdapter reCallAdapter;

    @Bind(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @Bind(R.id.navigation_drawer)
    View drawerView;
    private int isOpened=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recall_main_activity);
        ButterKnife.bind(this);

        gridLayoutManager = new GridLayoutManager(this,2);

        recyclerView.setLayoutManager(gridLayoutManager);

        reCallAdapter = new ReCallAdapter(getApplicationContext(),null);

        recyclerView.setAdapter(reCallAdapter);

        RecallMainController.getInstance().setImage(this, reCallAdapter);
        initForDrawer();
        /*GpsInfo gpsInfo = new GpsInfo(this);
        if(!gpsInfo.isGetLocation()) {
            gpsInfo.showSettingsAlert();
        }*/
    }

    @OnClick(R.id.menuBtn)
    public void menuBtnClick(View v) {
        drawerLayout.openDrawer(drawerView);
    }
    @OnTouch(R.id.navigation_drawer)
    public boolean onTouchDrawer(View v, MotionEvent event) {
        return true;
    }
    private void initForDrawer ( ) {
        DrawerLayout.DrawerListener myDrawerListner = new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                isOpened=-1;
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                switch (newState) {
                    case 2 :
                        isOpened=2;
                        break;
                }
            }
        };
        drawerLayout.setDrawerListener(myDrawerListner);
    }

    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
    private long mBackPressed;
    @Override
    public void onBackPressed(){
        if( isOpened==2 ) {
            drawerLayout.closeDrawer(drawerView);
            return;
        }
        else if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
        {
            isOpened=0;
            super.onBackPressed();
            return;
        }
        else { Toast.makeText(getBaseContext(), "뒤로 버튼을 한번 더 누르면 앱을 종료합니다.", Toast.LENGTH_SHORT).show(); }

        mBackPressed = System.currentTimeMillis();
    }
    //@OnClick(R.id.profile)
    public void profileBtnClick(View v) {
        Toast.makeText(getApplicationContext(),"profileBtn CLick",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);

    }
   // @OnClick(R.id.searchBtn)
    public void searchBtnClick(View v) {
        Toast.makeText(getApplicationContext(),"searchBtn CLick",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), MarkerMapActivity.class);
        startActivity(intent);

    }
}
