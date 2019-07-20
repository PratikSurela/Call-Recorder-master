package vn.harry.callrecorder.ServiceCall;

public interface OnServiceCallResponse {
    void onResponseSuccess(Object response);
    void onResponseFail(String strErrorMessage);
}
