package vn.harry.callrecorder.util;

import android.content.Context;

import com.github.pwittchen.prefser.library.rx2.Prefser;
import com.github.pwittchen.prefser.library.rx2.TypeToken;

import java.util.ArrayList;
import java.util.List;

import vn.harry.callrecorder.response.ClientList.ResponseObjectItem;

public class RecordingUtils {

    public static void addAllClinetList(Context context, List<ResponseObjectItem> responseObjectItems) {
        clearClientList(context);
        Prefser prefser = new Prefser(context);
        prefser.put(ConstantUtils.PREF_CLIENT_LIST, responseObjectItems);
    }

    public static List<ResponseObjectItem> getClientsList(Context context) {
        Prefser prefser = new Prefser(context);
        TypeToken<List<ResponseObjectItem>> typeToken = new TypeToken<List<ResponseObjectItem>>() {
        };
        if (prefser.contains(ConstantUtils.PREF_CLIENT_LIST)) {
            return prefser.get(ConstantUtils.PREF_CLIENT_LIST, typeToken, new ArrayList<>());
        } else {
            return new ArrayList<>();
        }
    }

    public static void clearClientList(Context context) {
        Prefser prefser = new Prefser(context);
        prefser.remove(ConstantUtils.PREF_CLIENT_LIST);
    }

    public static int clientListSize(Context context) {
        Prefser prefser = new Prefser(context);
        TypeToken<List<ResponseObjectItem>> typeToken = new TypeToken<List<ResponseObjectItem>>() {
        };
        if (prefser.contains(ConstantUtils.PREF_CLIENT_LIST)) {
            return prefser.get(ConstantUtils.PREF_CLIENT_LIST, typeToken, new ArrayList<>()).size();
        } else {
            return 0;
        }
    }
}