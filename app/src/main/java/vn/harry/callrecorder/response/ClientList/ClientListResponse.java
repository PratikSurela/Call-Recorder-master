package vn.harry.callrecorder.response.ClientList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClientListResponse {

    @SerializedName("IsSuccessStatusCode")
    private boolean isSuccessStatusCode;

    @SerializedName("ResponseCode")
    private int responseCode;

    @SerializedName("ResponseStatus")
    private boolean responseStatus;

    @SerializedName("Version")
    private Version version;

    @SerializedName("Content")
    private Object content;

    @SerializedName("Headers")
    private List<Object> headers;

    @SerializedName("RequestMessage")
    private Object requestMessage;

    @SerializedName("ReasonPhrase")
    private String reasonPhrase;

    @SerializedName("HttpResponse")
    private Object httpResponse;

    @SerializedName("ResponseObject")
    private List<ResponseObjectItem> responseObject;

    @SerializedName("ResponseMessage")
    private String responseMessage;

    @SerializedName("StatusCode")
    private int statusCode;

    public void setIsSuccessStatusCode(boolean isSuccessStatusCode) {
        this.isSuccessStatusCode = isSuccessStatusCode;
    }

    public boolean isIsSuccessStatusCode() {
        return isSuccessStatusCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseStatus(boolean responseStatus) {
        this.responseStatus = responseStatus;
    }

    public boolean isResponseStatus() {
        return responseStatus;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Version getVersion() {
        return version;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setHeaders(List<Object> headers) {
        this.headers = headers;
    }

    public List<Object> getHeaders() {
        return headers;
    }

    public void setRequestMessage(Object requestMessage) {
        this.requestMessage = requestMessage;
    }

    public Object getRequestMessage() {
        return requestMessage;
    }

    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public void setHttpResponse(Object httpResponse) {
        this.httpResponse = httpResponse;
    }

    public Object getHttpResponse() {
        return httpResponse;
    }

    public void setResponseObject(List<ResponseObjectItem> responseObject) {
        this.responseObject = responseObject;
    }

    public List<ResponseObjectItem> getResponseObject() {
        return responseObject;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return
                "ClientListResponse{" +
                        "isSuccessStatusCode = '" + isSuccessStatusCode + '\'' +
                        ",responseCode = '" + responseCode + '\'' +
                        ",responseStatus = '" + responseStatus + '\'' +
                        ",version = '" + version + '\'' +
                        ",content = '" + content + '\'' +
                        ",headers = '" + headers + '\'' +
                        ",requestMessage = '" + requestMessage + '\'' +
                        ",reasonPhrase = '" + reasonPhrase + '\'' +
                        ",httpResponse = '" + httpResponse + '\'' +
                        ",responseObject = '" + responseObject + '\'' +
                        ",responseMessage = '" + responseMessage + '\'' +
                        ",statusCode = '" + statusCode + '\'' +
                        "}";
    }
}