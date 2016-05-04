package com.example.kwongyo.recall.model;

import java.io.Serializable;

/**
 * Created by kwongyo on 2016-05-03.
 */
public class UserDTO implements Serializable {
    private String email;
    private String password;

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
