package com.example.kwongyo.recall.interfaceOfRECALL;


import com.example.kwongyo.recall.model.DTO.UserDTO;
import com.example.kwongyo.recall.model.VO.UserVO;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by kwongyo on 2016-05-03.
 * https://www.metachris.com/2015/10/retrofit-2-samples/
 */
public interface LoginInterface {
    @FormUrlEncoded
    @POST("login.do")
    Call<UserVO> requestLogin(
            @Field("loginId") String loginId,
            @Field("loginPwd") String loginPwd
    );
}