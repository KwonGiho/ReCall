package com.example.kwongyo.recall.interfaceOfRECALL;

import com.example.kwongyo.recall.model.DTO.MarkerDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by kwongyo on 2016-05-29.
 */
public interface MarkerInterface {
    @FormUrlEncoded
    @POST("marker.do")
    Call<MarkerDTO> insertMarker(
            @Field("service") String service,
            @Field("uId") String uId,
            @Field("markers") String markers
    );


}
