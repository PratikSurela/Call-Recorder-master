package vn.harry.callrecorder.util;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vn.harry.callrecorder.R;

/**
 * Created by web on 3/3/2018.
 */
public class Utils {

    /**
     * The Alarm manager.
     */
    //Location Manager
    private static AlarmManager alarmManager;
    /**
     * The Pending intent.
     */
    private static PendingIntent pendingIntent;

    private static final String TAG = Utils.class.getSimpleName();
    private static Calendar calendar = Calendar.getInstance();
    /**
     * The constant strDisplayDate.
     */
    public static String strDisplayDate = "", /**
     * The Str send date.
     */
    strSendDate = "";
    /**
     * The Is granted.
     */
    static boolean isGranted = false;

   /* private Context context;

    public Utils(Context context){
        this.context = context;
    }
*/

    /**
     * Gets the version name of the application. For e.g. 1.0
     *
     * @param context the context
     * @return the application version number
     */
    public static String getApplicationVersionNumber(Context context) {

        String versionName = null;

        if (context == null) {
            return versionName;
        }

        try {
            versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return versionName;
    }

    /**
     * Checks if the input parameter is a valid email.
     *
     * @param email
     * @return
     */
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        } else {
            final String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            Matcher matcher;
            Pattern pattern = Pattern.compile(emailPattern);
            matcher = pattern.matcher(email);

            return matcher.matches() && matcher.matches();
        }
    }

    public static boolean isValueNull(Object object) {
        if (object != null) {
            return false;
        } else {
            return true;
        }
    }

    public static void makeEnableDisableView(View view, boolean isEnable) {
        if (isEnable) {
            view.setEnabled(true);
            view.setClickable(true);
            view.setLongClickable(true);
        } else {
            view.setEnabled(false);
            view.setClickable(false);
            view.setLongClickable(false);
        }
    }

    public static void hideKeyboard(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

    public static void makeLinks(TextView textView, String[] links, ClickableSpan[] clickableSpans, Context context) {
        SpannableString spannableString = new SpannableString(textView.getText().toString());
        for (int i = 0; i < links.length; i++) {
            ClickableSpan clickableSpan = clickableSpans[i];
            String link = links[i];

            int startIndexOfLink = textView.getText().toString().indexOf(link);
            spannableString.setSpan(clickableSpan, startIndexOfLink,
                    startIndexOfLink + link.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        textView.setHighlightColor(Color.TRANSPARENT); // prevent TextView change background when highlight
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setLinkTextColor(context.getResources().getColor(R.color.material_blue_500));
        textView.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    public static void sendSMS(Context context, String phoneNo, String msg) {
        try {
            SmsManager sms = SmsManager.getDefault();
            PendingIntent sentPI;
            String SENT = "SMS_SENT";
            sentPI = PendingIntent.getBroadcast(context, 0, new Intent(SENT), 0);
            sms.sendTextMessage(phoneNo, null, msg, sentPI, null);
            Log.d(TAG, "sendSMS: " + "SMS sent successfully for: 1");
        } catch (Exception ex) {
            Log.d(TAG, "sendSMS: Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void sendSMS(Context context, String phoneNo, String msg, String strCheckedSMSType) {
        try {
            SmsManager sms = SmsManager.getDefault();
            PendingIntent sentPI;
            String SENT = "SMS_SENT";
            sentPI = PendingIntent.getBroadcast(context, 0, new Intent(SENT), 0);
            sms.sendTextMessage(phoneNo, null, msg, sentPI, null);
            Log.d(TAG, "sendSMS: " + "SMS sent successfully for: 2");
            Toast.makeText(context, "SMS sent successfully for " + strCheckedSMSType, Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Log.d(TAG, "sendSMS: Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static String getCompleteAddress(Context context, double LATITUDE, double LONGITUDE) {
        String strAdd = "";
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1);
            if (addresses != null) {
                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");
                if (returnedAddress != null) {
                    for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
                        strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
                    }
                    strAdd = strReturnedAddress.toString();
                    Log.w(TAG, strReturnedAddress.toString());
                }
            } else {
                Log.w(TAG, "No Address returned!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.w(TAG, "Canont get Address!");
        }
        return strAdd;
    }

    public static void showErrorMessage(Context context) {
        Toast.makeText(context, "Sorry! We're Unable to process on your request", Toast.LENGTH_LONG).show();
    }

    @SuppressLint("HardwareIds")
    public static String getAndroidId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static boolean isInternetAvailable(Context context) {
        ConnectionCheck connectionCheck = new ConnectionCheck();
        if (connectionCheck.isNetworkConnected(context)) {
            return true;
        } else {
            return false;
        }
    }
}