package vn.harry.callrecorder.response.login;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName(".expires")
    private String expires;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("userName")
    private String userName;

    @SerializedName("expires_in")
    private int expiresIn;

    @SerializedName(".issued")
    private String issued;

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getExpires() {
        return expires;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public String getIssued() {
        return issued;
    }

    @Override
    public String toString() {
        return
                "LoginResponse{" +
                        "access_token = '" + accessToken + '\'' +
                        ",.expires = '" + expires + '\'' +
                        ",token_type = '" + tokenType + '\'' +
                        ",userName = '" + userName + '\'' +
                        ",expires_in = '" + expiresIn + '\'' +
                        ",.issued = '" + issued + '\'' +
                        "}";
    }
}