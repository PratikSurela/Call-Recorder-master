package vn.harry.callrecorder.ServiceCall;

import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WebService {

    private static WebService webService;
    private OkHttpClient client;

    public WebService() {
        try {
            client = new OkHttpClient.Builder()
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(40, TimeUnit.SECONDS)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebService getInstance() {
        if (webService == null)
            webService = new WebService();
        return webService;
    }

    public String CallURLWebServiceToken(String webServiceName, String req) {
        Log.v("webServiceName", webServiceName);
        try {

            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
            RequestBody body = RequestBody.create(mediaType, req);
            Request request = new Request.Builder()
                    .url(webServiceName)
                    .post(body)
                    .addHeader("content-type", "application/x-www-form-urlencoded")
                    .addHeader("cache-control", "no-cache")
                    .build();


            Response response = client.newCall(request).execute();
            String loginResponse = response.body().string();
            Log.d("ResponseLogin", loginResponse);

            return loginResponse;

        } catch (IOException ex) {
            ex.printStackTrace();
            if (ex.toString().contains("java.net.SocketTimeoutException")) {
                return "SocketTimeoutException";
            }
            return "0";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    public String CallWebService(String webServiceName, String params, String token) {
        try {
            Request request = new Request.Builder()
                    .url(webServiceName)
                    .post(RequestBody.create(MediaType.parse("application/json"), params))
                    .addHeader("authorization", "Bearer " + token)
                    .addHeader("content-type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();
            String loginResponse = response.body().string();
            Log.d("ResponseLogin", loginResponse);

            return loginResponse;

        } catch (IOException ex) {
            Log.e("Vendor Type", ex.toString());
            if (ex.toString().contains("java.net.SocketTimeoutException")) {
                return "SocketTimeoutException";
            }
            return "0";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    public String CallGetWebService(String webServiceName, String token) {
        try {

            Request request = new Request.Builder()
                    .url(webServiceName)
                    .get()
                    .addHeader("authorization", "Bearer " + token)
                    .build();
            Response response = client.newCall(request).execute();
            String getResponse = response.body().string();
            Log.d("Response Get", getResponse);

            return getResponse;

        } catch (IOException ex) {
            Log.e("getResponse", ex.toString());
            if (ex.toString().contains("java.net.SocketTimeoutException")) {
                return "SocketTimeoutException";
            }
            return "0";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    public String CallURIGetWebService(String webServiceName, String req, String token) {
        try {
            Request request = new Request.Builder()
                    .url(webServiceName + "?" + req)
                    .get()
                    .addHeader("authorization", "Bearer " + token)
                    .build();

            Log.d("WebService", "CallURIGetWebService: request: " + request);

            Response response = client.newCall(request).execute();
            String getResponse = response.body().string();
            Log.d("Response Get", getResponse);

            return getResponse;

        } catch (IOException ex) {
            Log.e("getResponse", ex.toString());
            if (ex.toString().contains("java.net.SocketTimeoutException")) {
                return "SocketTimeoutException";
            }
            return "0";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    public String CallURIPostWebService(String webServiceName, String req, String token) {
        try {
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url(webServiceName + "?" + req)
                    .post(body)
                    .addHeader("authorization", "Bearer " + token)
                    .build();
            Response response = client.newCall(request).execute();
            String loginResponse = response.body().string();
            Log.d("Response-" + webServiceName, loginResponse);
            return loginResponse;

        } catch (IOException ex) {
            ex.printStackTrace();
            if (ex.toString().contains("java.net.SocketTimeoutException")) {
                return "SocketTimeoutException";
            }
            return "0";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    public String CallGetHeaderWebService(String webServiceName, String token) {
        try {
            Request request = new Request.Builder()
                    .url(webServiceName)
                    //.url(webServiceName + "?" + req)
                    .get()
                    .addHeader("authorization", "Bearer " + token)
                    .addHeader("content-type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();
            String getResponse = response.body().string();
            Log.d("Response Get", getResponse);

            return getResponse;

        } catch (IOException ex) {
            Log.e("getResponse", ex.toString());
            if (ex.toString().contains("java.net.SocketTimeoutException")) {
                return "SocketTimeoutException";
            }
            return "0";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    public String CallHeaderWebService(String webServiceName, String params, String token) {
        try {
            Request request = new Request.Builder()
                    .url(webServiceName)
                    .post(RequestBody.create(MediaType.parse("application/json"), params))
                    .addHeader("authorization", "Bearer " + token)
                    .addHeader("content-type", "application/json")
                    .build();

            Response response = client.newCall(request).execute();
            String loginResponse = response.body().string();

            Log.d("ResponseLogin", loginResponse);
            return loginResponse;

        } catch (IOException ex) {
            Log.e("post Response", ex.toString());
            if (ex.toString().contains("java.net.SocketTimeoutException")) {
                return "SocketTimeoutException";
            }
            return "0";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    public String CallHeaderUploadWebService(String webServiceName, List<File> params) {
        try {
            MultipartBody.Builder multipartBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
            for (File file : params) {
                if (file != null && file.exists())
                    multipartBuilder.addFormDataPart(file.getName(), file.getName(), RequestBody.create(MediaType.parse("image/jpeg"), file));
            }

            RequestBody body = multipartBuilder
                    .addFormDataPart("", "")
                    .build();

            Request request = new Request.Builder()
                    .url(webServiceName)
                    .post(body)
                    .build();

            Response response = client.newCall(request).execute();
            String loginResponse = response.body().string();
            Log.d("Image", loginResponse);

            return loginResponse;

        } catch (IOException ex) {
            Log.e("UploadData", ex.toString());
            if (ex.toString().contains("java.net.SocketTimeoutException")) {
                return "SocketTimeoutException";
            }
            return "0";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

}
