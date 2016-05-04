package com.example.kwongyo.recall.interfaceOfRECALL;

import com.example.kwongyo.recall.model.UserDTO;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by kwongyo on 2016-05-04.
 */
public interface RegisterInterface {
    @FormUrlEncoded
    @POST("register.do")
    Call<UserDTO> requestRegister(
            @Field("email") String email,
            @Field("name") String name,
            @Field("password") String password
    );
}
