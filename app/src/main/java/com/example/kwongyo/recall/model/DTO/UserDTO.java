package com.example.kwongyo.recall.model.DTO;

import java.io.Serializable;

/**
 * Created by kwongyo on 2016-05-03.
 */
public class UserDTO implements Serializable {
    private String loginId;
    private String loginPwd;

    public UserDTO(String loginId, String loginPwd) {
        this.loginId = loginId;
        this.loginPwd = loginPwd;
    }
}
