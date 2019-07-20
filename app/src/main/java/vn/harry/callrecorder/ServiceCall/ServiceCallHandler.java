package vn.harry.callrecorder.ServiceCall;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.File;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.harry.callrecorder.R;
import vn.harry.callrecorder.response.login.ErrorResponse;
import vn.harry.callrecorder.util.ConnectionCheck;
import vn.harry.callrecorder.util.ConstantUtils;
import vn.harry.callrecorder.util.PrefsUtil;
import vn.harry.callrecorder.util.Utils;

public abstract class ServiceCallHandler {

    private String TAG = "ServiceCallHandler";
    private Context context;
    private String strURL = "", strHeader = "", strToken = "", strTokenType = "", strParams = "";
    private GetDataService service;
    private RequestBody requestBody;
    private Dialog dialog;
    public Object model;
    private ConnectionCheck connectionCheck;
    private boolean isLoadingShow = true;

    public ServiceCallHandler(Context context, String strURL, HashMap<String, String> paramsMap, Object model, String requestType) {
        this.context = context;
        this.strURL = strURL;
        this.model = model;

        //Check internet
        connectionCheck = new ConnectionCheck();
        //Get header from pref
        strToken = PrefsUtil.with(context).readString(ConstantUtils.TOKEN);
        strTokenType = PrefsUtil.with(context).readString(ConstantUtils.TOKEN_TYPE);
        strHeader = strTokenType + " " + strToken;

        strParams = new Gson().toJson(paramsMap);
        requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), strParams);
        if (connectionCheck.isNetworkConnected(context)) {
            if (requestType.equalsIgnoreCase(ServiceCallUtils.POST_NO_HEADER)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
                callSimpleServiceCall();
            } else if (requestType.equalsIgnoreCase(ServiceCallUtils.POST_WITH_HEADER)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
                callHeaderServiceCall();
            } else if (requestType.equalsIgnoreCase(ServiceCallUtils.GET_NO_HEADER)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
            } else if (requestType.equalsIgnoreCase(ServiceCallUtils.GET_WITH_HEADER)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
            } else if (requestType.equalsIgnoreCase(ServiceCallUtils.POST_TOKEN_URL_ENCODED)) {
                service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                callPostTokenServiceCall(paramsMap);
            }
        } else {
            connectionCheck.showconnectiondialog(context);
        }
    }

    public ServiceCallHandler(Context context, String strURL, String strParams, Object model, String requestType, boolean isLoadingShow) {
        this.context = context;
        this.strURL = strURL;
        this.model = model;
        this.isLoadingShow = isLoadingShow;

        //Check internet
        connectionCheck = new ConnectionCheck();
        //Get header from pref
        strToken = PrefsUtil.with(context).readString(ConstantUtils.TOKEN);
        strTokenType = PrefsUtil.with(context).readString(ConstantUtils.TOKEN_TYPE);
        strHeader = strTokenType + " " + strToken;

        requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), strParams);
        if (connectionCheck.isNetworkConnected(context)) {
            if (requestType.equalsIgnoreCase(ServiceCallUtils.POST_NO_HEADER)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
                callSimpleServiceCall();
            } else if (requestType.equalsIgnoreCase(ServiceCallUtils.POST_WITH_HEADER)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
                callHeaderServiceCall();
            } else if (requestType.equalsIgnoreCase(ServiceCallUtils.GET_NO_HEADER)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
            } else if (requestType.equalsIgnoreCase(ServiceCallUtils.GET_WITH_HEADER)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
            } else if (requestType.equalsIgnoreCase(ServiceCallUtils.POST_STRING_PARAMS)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
                callHeaderStringParamsServiceCall();
            }
        } else {
            connectionCheck.showconnectiondialog(context);
        }
    }

    public ServiceCallHandler(Context context, String strURL, HashMap<String, String> paramsMap, Object model, String requestType, boolean isLoadingShow) {
        this.context = context;
        this.strURL = strURL;
        this.model = model;
        this.isLoadingShow = isLoadingShow;

        //Check internet
        connectionCheck = new ConnectionCheck();
        //Get header from pref
        strToken = PrefsUtil.with(context).readString(ConstantUtils.TOKEN);
        strTokenType = PrefsUtil.with(context).readString(ConstantUtils.TOKEN_TYPE);
        strHeader = strTokenType + " " + strToken;

        strParams = new Gson().toJson(paramsMap);
        requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), strParams);
        if (connectionCheck.isNetworkConnected(context)) {
            if (requestType.equalsIgnoreCase(ServiceCallUtils.POST_NO_HEADER)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
                callSimpleServiceCall();
            } else if (requestType.equalsIgnoreCase(ServiceCallUtils.POST_WITH_HEADER)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
                callHeaderServiceCall();
            } else if (requestType.equalsIgnoreCase(ServiceCallUtils.GET_NO_HEADER)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
            } else if (requestType.equalsIgnoreCase(ServiceCallUtils.GET_WITH_HEADER)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
            } else if (requestType.equalsIgnoreCase(ServiceCallUtils.POST_TOKEN_URL_ENCODED)) {
                service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                callPostTokenServiceCall(paramsMap);
            }
        } else {
            connectionCheck.showconnectiondialog(context);
        }
    }

    public ServiceCallHandler(Context context, String strURL, File file, HashMap<String, String> paramsMap, Object model, String requestType, boolean isLoadingShow) {
        this.context = context;
        this.strURL = strURL;
        this.model = model;
        this.isLoadingShow = isLoadingShow;

        //Check internet
        connectionCheck = new ConnectionCheck();
        //Get header from pref
        strToken = PrefsUtil.with(context).readString(ConstantUtils.TOKEN);
        strTokenType = PrefsUtil.with(context).readString(ConstantUtils.TOKEN_TYPE);
        strHeader = strTokenType + " " + strToken;

        strParams = new Gson().toJson(paramsMap);
        requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), strParams);
        if (connectionCheck.isNetworkConnected(context)) {
            if (requestType.equalsIgnoreCase(ServiceCallUtils.POST_NO_HEADER)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
                callSimpleServiceCall();
            } else if (requestType.equalsIgnoreCase(ServiceCallUtils.POST_NO_HEADER_FILE)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
                //callFileUploadServiceCall(file, paramsMap);
            } else if (requestType.equalsIgnoreCase(ServiceCallUtils.POST_WITH_HEADER)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
                callHeaderServiceCall();
            } else if (requestType.equalsIgnoreCase(ServiceCallUtils.GET_NO_HEADER)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
            } else if (requestType.equalsIgnoreCase(ServiceCallUtils.GET_WITH_HEADER)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
            } else if (requestType.equalsIgnoreCase(ServiceCallUtils.POST_TOKEN_URL_ENCODED)) {
                service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                callPostTokenServiceCall(paramsMap);
            }
        } else {
            connectionCheck.showconnectiondialog(context);
        }
    }

    public ServiceCallHandler(Context context, String strURL, HashMap<String, Object> paramsMap, Object model, String requestType, boolean isLoadingShow, String str) {
        this.context = context;
        this.strURL = strURL;
        this.model = model;
        this.isLoadingShow = isLoadingShow;

        //Check internet
        connectionCheck = new ConnectionCheck();
        //Get header from pref
        strToken = PrefsUtil.with(context).readString(ConstantUtils.TOKEN);
        strTokenType = PrefsUtil.with(context).readString(ConstantUtils.TOKEN_TYPE);
        strHeader = strTokenType + " " + strToken;

        strParams = new Gson().toJson(paramsMap);
        requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), strParams);
        if (connectionCheck.isNetworkConnected(context)) {
            if (requestType.equalsIgnoreCase(ServiceCallUtils.POST_NO_HEADER)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
                callSimpleServiceCall();
            } else if (requestType.equalsIgnoreCase(ServiceCallUtils.POST_WITH_HEADER)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
                callHeaderServiceCall();
            } else if (requestType.equalsIgnoreCase(ServiceCallUtils.GET_NO_HEADER)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
            } else if (requestType.equalsIgnoreCase(ServiceCallUtils.GET_WITH_HEADER)) {
                service = RetrofitClientApiInstance.getRetrofitInstance().create(GetDataService.class);
            }
        } else {
            connectionCheck.showconnectiondialog(context);
        }
    }

    private void callSimpleServiceCall() {
        try {
            if (isLoadingShow) {
                dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_loading);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.setCancelable(false);
                dialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        service.CallSimplePostServiceCall(strURL, requestBody).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                try {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    if (response.body() != null) {
                        Gson gson = new Gson();
                        String json = gson.toJson(response.body());
                        Log.d(TAG, "onResponse: prettyStaff1 : " + json);
                        onServiceCallSuccessResponse(gson.fromJson(json, (Class) model));
                    } else {
                        if (response.message().length() == 0) {
                            Utils.showErrorMessage(context);
                        } else {
                            Utils.showErrorMessage(context);
                        }
                    }
                } catch (Exception e) {
                    Utils.showErrorMessage(context);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                try {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    Utils.showErrorMessage(context);
                    onServiceCallFailResponse(t.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                    Utils.showErrorMessage(context);
                }
            }
        });
    }

    private void callHeaderServiceCall() {
        try {
            if (isLoadingShow) {
                dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_loading);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.setCancelable(false);
                dialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        service.CallHeaderPostServiceCall(strURL, strHeader, requestBody).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                try {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    if (response.body() != null) {
                        Gson gson = new Gson();
                        String json = gson.toJson(response.body());
                        Log.d(TAG, "onResponse: prettyStaff1 : " + json);
                        onServiceCallSuccessResponse(gson.fromJson(json, (Class) model));
                    } else {
                        if (response.message().length() == 0) {
                            Log.e(TAG, "onResponse: " + "response.message().length() == 0");
                        } else {
                            Log.d(TAG, "onResponse: " + response.message());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d(TAG, "onResponse: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                try {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    Log.d(TAG, "onFailure: " + t.getMessage());
                    onServiceCallFailResponse(t.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void callHeaderStringParamsServiceCall() {
        try {
            if (isLoadingShow) {
                dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_loading);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.setCancelable(false);
                dialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Utils.showErrorMessage(context);
        }

        service.CallHeaderPostServiceCall(strURL, strHeader, requestBody).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                try {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    if (response.body() != null) {
                        Gson gson = new Gson();
                        String json = gson.toJson(response.body());
                        Log.d(TAG, "onResponse: prettyStaff1 : " + json);
                        onServiceCallSuccessResponse(gson.fromJson(json, (Class) model));
                    } else {
                        if (response.message().length() == 0) {
                            Utils.showErrorMessage(context);
                        } else {
                            Utils.showErrorMessage(context);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Utils.showErrorMessage(context);
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                try {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    Utils.showErrorMessage(context);
                    onServiceCallFailResponse(t.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                    Utils.showErrorMessage(context);
                }
            }
        });
    }

    private void callPostTokenServiceCall(HashMap<String, String> paramsMap) {
        try {
            if (isLoadingShow) {
                dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_loading);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.setCancelable(false);
                dialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        service.CallPostTokenServiceCall(strURL, paramsMap).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                try {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    if (response.body() != null) {
                        Gson gson = new Gson();
                        String json = gson.toJson(response.body());
                        Log.d(TAG, "onResponse: prettyStaff1 : " + json);
                        onServiceCallSuccessResponse(gson.fromJson(json, (Class) model));
                    } else {
                        Gson gson = new Gson();
                        String json = response.errorBody().string();
                        Log.d(TAG, "onResponse: prettyStaff1 : " + json);
                        ErrorResponse errorResponse = gson.fromJson(json, ErrorResponse.class);
                        Toast.makeText(context, errorResponse.getErrorDescription(), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                try {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
                    onServiceCallFailResponse(t.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, "Sorry! we're unable to get data, please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /*private void callFileUploadServiceCall(File file, HashMap<String, String> paramsMap) {
        try {
            if (isLoadingShow) {
                dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_loading);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.setCancelable(false);
                dialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Utils.showErrorMessage(context);
        }
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("", Calendar.getInstance().getTime().toString() + ".jpg", requestFile);
        //MultipartBody.Part body1 = MultipartBody.Part.createFormData("", "");
        service.CallFileUploadServiceCall(strURL, body).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                try {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    if (response.body() != null) {
                        Gson gson = new Gson();
                        String json = gson.toJson(response.body());
                        Log.d(TAG, "onResponse: CallFileUploadServiceCall : " + json);
                        onServiceCallSuccessResponse(gson.fromJson(json, (Class) model));
                    } else {
                        onServiceCallFailResponse(response.message());
                        Utils.showErrorMessage(context);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Utils.showErrorMessage(context);
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                try {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    Utils.showErrorMessage(context);
                    onServiceCallFailResponse(t.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                    Utils.showErrorMessage(context);
                }
            }
        });
    }*/

    protected abstract void onServiceCallSuccessResponse(Object response);

    protected abstract void onServiceCallFailResponse(String strErrorMessage);
}