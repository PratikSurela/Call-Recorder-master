package vn.harry.callrecorder.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * The type Connection check.
 */
public class ConnectionCheck {

    /**
     * Is network connected boolean.
     *
     * @param context the context
     * @return the boolean
     */
    public boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null) {
            // There are no active networks.
            return false;
        } else
            return true;
    }


    /**
     * Showconnectiondialog alert dialog . builder.
     *
     * @param context the context
     * @return the alert dialog . builder
     */
    /*public AlertDialog.Builder showconnectiondialog(Context context) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setIcon(R.drawable.ic_internet_off)
                .setTitle("Error!")
                .setCancelable(false)
                .setMessage("No Internet Connection.")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

        builder.show();
        return builder;
    }*/
    public void showconnectiondialog(Context context) {
        Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
    }

    /**
     * Show message dialog alert dialog . builder.
     *
     * @param context the context
     * @param message the message
     * @return the alert dialog . builder
     */
    public static AlertDialog.Builder showMessageDialog(Context context, String message) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(context)
                //.setIcon(R.drawable.ic_internet_off)
                //.setTitle("Error!")
                .setCancelable(false)
                .setMessage(message)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

        builder.show();
        return builder;
    }
}