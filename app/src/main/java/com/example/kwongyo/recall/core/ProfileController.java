package com.example.kwongyo.recall.core;

import android.content.Context;
import android.util.Log;

import com.example.kwongyo.recall.StaticInfomation;
import com.example.kwongyo.recall.interfaceOfRECALL.MarkerInterface;
import com.example.kwongyo.recall.model.CustomPreference;
import com.example.kwongyo.recall.model.DTO.MarkerDTO;
import com.example.kwongyo.recall.model.DTO.UserDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kwongyo on 2016-05-30.
 */
public class ProfileController {
    private static final ProfileController profileController;
    static {
        profileController = new ProfileController();
    }
    private ProfileController() {

    }
    public static ProfileController getInstance() {
        return profileController;
    }

    Retrofit retrofit;
    public boolean insertMarker(Context context , String markers) {
        retrofit = new Retrofit.Builder().baseUrl(StaticInfomation.RECALL_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        MarkerInterface markerInterface = retrofit.create(MarkerInterface.class);
        CustomPreference customPreference = CustomPreference.getInstance(context);
        Call<MarkerDTO> call = markerInterface.insertMarker("insert",customPreference.getValue("uId",""),markers);

        call.clone().enqueue(new Callback<MarkerDTO>(){
            @Override
            public void onResponse(Call<MarkerDTO> call, Response<MarkerDTO> response) {
                if(!response.isSuccess())
                    return ;
                MarkerDTO markerDTO = response.body();
                Log.e("marker됬음?", "응됬음");

            }

            @Override
            public void onFailure(Call<MarkerDTO> call, Throwable t) {
                Log.e("marker됬음???","안됐음");
            }
        });

        return false;
    }

}
