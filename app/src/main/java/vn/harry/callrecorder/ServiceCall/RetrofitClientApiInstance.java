package vn.harry.callrecorder.ServiceCall;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientApiInstance {

    private static String TAG = "RetrofitClientInstance";
    private static Retrofit retrofit1;
    //private static final String BASE_URL = "http://mvcdemo.dcodesoftware.com/api/";
    private static final String BASE_URL = "http://matalia.truesys.co.in/api/";


    public static Retrofit getRetrofitInstance() {
        if (retrofit1 == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .build();

            retrofit1 = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit1;
    }
}