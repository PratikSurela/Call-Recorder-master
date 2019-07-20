package vn.harry.callrecorder.ServiceCall;

import android.content.Context;

import java.io.File;
import java.util.HashMap;

public class ServiceCallUtils extends ServiceCallHandler {

    private String TAG = "ServiceCallUtils";
    private OnServiceCallResponse onServiceCallResponse;
    public final static String POST_NO_HEADER = "POST_NO_HEADER", POST_WITH_HEADER = "POST_WITH_HEADER",
            GET_NO_HEADER = "GET_NO_HEADER", GET_WITH_HEADER = "GET_WITH_HEADER", POST_TOKEN_URL_ENCODED = "POST_TOKEN_URL_ENCODED", POST_STRING_PARAMS = "POST_STRING_PARAMS",
            POST_NO_HEADER_FILE = "POST_NO_HEADER_FILE";

    public ServiceCallUtils(Context context, String strURL, HashMap<String, String> paramsMap, Object model, String requestType, OnServiceCallResponse onServiceCallResponse) {
        super(context, strURL, paramsMap, model, requestType);
        this.onServiceCallResponse = onServiceCallResponse;
    }

    public ServiceCallUtils(Context context, String strURL, HashMap<String, String> paramsMap, Object model, String requestType, OnServiceCallResponse onServiceCallResponse, boolean isLoadingShow) {
        super(context, strURL, paramsMap, model, requestType, isLoadingShow);
        this.onServiceCallResponse = onServiceCallResponse;
    }

    public ServiceCallUtils(Context context, String strURL, HashMap<String, Object> paramsMap, Object model, String requestType, OnServiceCallResponse onServiceCallResponse, boolean isLoadingShow, String string) {
        super(context, strURL, paramsMap, model, requestType, isLoadingShow, string);
        this.onServiceCallResponse = onServiceCallResponse;
    }

    public ServiceCallUtils(Context context, String strURL, String strParams, Object model, String requestType, OnServiceCallResponse onServiceCallResponse, boolean isLoadingShow) {
        super(context, strURL, strParams, model, requestType, isLoadingShow);
        this.onServiceCallResponse = onServiceCallResponse;
    }

    public ServiceCallUtils(Context context, String strURL, File file, HashMap<String, String> paramsMap, Object model, String requestType, OnServiceCallResponse onServiceCallResponse, boolean isLoadingShow) {
        super(context, strURL, file, paramsMap, model, requestType, isLoadingShow);
        this.onServiceCallResponse = onServiceCallResponse;
    }


    @Override
    protected void onServiceCallSuccessResponse(Object response) {
        onServiceCallResponse.onResponseSuccess(response);
    }

    @Override
    protected void onServiceCallFailResponse(String strErrorMessage) {
        onServiceCallResponse.onResponseFail(strErrorMessage);
    }
}
