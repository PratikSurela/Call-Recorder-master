package vn.harry.callrecorder.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import vn.harry.callrecorder.R;

/**
 * Created by pratik on 10-May-16.
 */
public class PrefsUtil {

    private static final int DEFAULT_INT = 0;
    private static final String DEFAULT_STRING = "";
    private static final float DEFAULT_FLOAT = -1f;
    private static final boolean DEFAULT_BOOLEAN = false;

    private static SharedPreferences sharedPreferences;
    private static PrefsUtil prefsUtil;

    private PrefsUtil(@NonNull Context mContext) {
        if (sharedPreferences == null) {
            sharedPreferences = mContext.getApplicationContext().getSharedPreferences(mContext.getString(R.string.app_name), Context.MODE_PRIVATE);
        }
    }

    /**
     * With prefs util.
     *
     * @param context the context
     * @return the prefs util
     */
    public static PrefsUtil with(@NonNull Context context) {
        if (prefsUtil == null) {
            prefsUtil = new PrefsUtil(context);
        }
        return prefsUtil;
    }

    /**
     * Write.
     *
     * @param name   the name
     * @param number the number
     */
    public void write(String name, int number) {
        sharedPreferences.edit().putInt(name, number).apply();
    }

    /**
     * Write.
     *
     * @param name the name
     * @param str  the str
     */
    public void write(String name, String str) {
        sharedPreferences.edit().putString(name, str).apply();
    }

    /**
     * Write.
     *
     * @param name   the name
     * @param number the number
     */
    public void write(String name, float number) {
        sharedPreferences.edit().putFloat(name, number).apply();
    }

    /**
     * Write.
     *
     * @param name the name
     * @param bool the bool
     */
    public void write(String name, boolean bool) {
        sharedPreferences.edit().putBoolean(name, bool).apply();
    }

    /**
     * Read int int.
     *
     * @param name the name
     * @return the int
     */
    public int readInt(String name) {
        return sharedPreferences.getInt(name, DEFAULT_INT);
    }

    /**
     * Read string string.
     *
     * @param name the name
     * @return the string
     */
    public String readString(String name) {
        return sharedPreferences.getString(name, DEFAULT_STRING);
    }

    /**
     * Read float float.
     *
     * @param name the name
     * @return the float
     */
    public float readFloat(String name) {
        return sharedPreferences.getFloat(name, DEFAULT_FLOAT);
    }

    /**
     * Read boolean boolean.
     *
     * @param name the name
     * @return the boolean
     */
    public boolean readBoolean(String name) {
        return sharedPreferences.getBoolean(name, DEFAULT_BOOLEAN);
    }

    /**
     * Clear preferences.
     */
    public void clearPreferences() {
        sharedPreferences.edit().clear().commit();
    }
}