package com.example.kwongyo.recall.model.VO;

import java.security.Timestamp;

/**
 * Created by kwongyo on 2016-05-20.
 */
public class UserVO {
    private String resultCode ;
    private Timestamp timestamp;
    private String uID;
    private String name;
    private String emailId;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "resultCode='" + resultCode + '\'' +
                ", timestamp=" + timestamp +
                ", uID='" + uID + '\'' +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
