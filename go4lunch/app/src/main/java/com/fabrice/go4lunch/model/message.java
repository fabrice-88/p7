package com.fabrice.go4lunch.model;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class message {

    private String message;
    private String mateName;
    private String matePhotoUrl;
    private String mateUid;
    private @ServerTimestamp
    Date timestamp;


    public void Message(String message, String mateName, String matePhotoUrl, String mateUid, Date timestamp) {
        this.message = message;
        this.mateName = mateName;
        this.matePhotoUrl = matePhotoUrl;
        this.mateUid = mateUid;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMateName() {
        return mateName;
    }

    public void setMateName(String mateName) {
        this.mateName = mateName;
    }

    public String getMatePhotoUrl() {
        return matePhotoUrl;
    }

    public void setMatePhotoUrl(String matePhotoUrl) {
        this.matePhotoUrl = matePhotoUrl;
    }

    public String getMateUid() {
        return mateUid;
    }

    public void setMateUid(String mateUid) {
        this.mateUid = mateUid;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
