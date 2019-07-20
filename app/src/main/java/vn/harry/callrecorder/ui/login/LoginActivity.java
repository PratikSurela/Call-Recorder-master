package vn.harry.callrecorder.ui.login;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import vn.harry.callrecorder.R;
import vn.harry.callrecorder.ServiceCall.OnServiceCallResponse;
import vn.harry.callrecorder.ServiceCall.ServiceCallUtils;
import vn.harry.callrecorder.response.login.LoginResponse;
import vn.harry.callrecorder.ui.MainActivity;
import vn.harry.callrecorder.util.ConstantUtils;
import vn.harry.callrecorder.util.PrefsUtil;


public class LoginActivity extends AppCompatActivity implements OnServiceCallResponse {

    private String TAG = "";
    private Context context;
    private EditText edtUsername, edtPassword;
    private Button btnLogin;
    private String strUsername = "", strPassword = "";
    private boolean isLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateViews()) {
/*                    if (strUsername.equals("admin") && strPassword.equals("admin")) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(context, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    }*/

                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("grant_type", "password");
                    hashMap.put("username", strUsername);
                    hashMap.put("password", strPassword);

                    new ServiceCallUtils(context, "token", hashMap, LoginResponse.class, ServiceCallUtils.POST_TOKEN_URL_ENCODED, LoginActivity.this);
                }
            }
        });
    }

    private boolean validateViews() {

        strUsername = edtUsername.getText().toString().trim();
        strPassword = edtPassword.getText().toString().trim();

        if (strUsername.length() == 0) {
            edtUsername.setError("Enter Username");
            edtUsername.requestFocus();
            return false;
        } else if (strPassword.length() == 0) {
            edtPassword.setError("Enter Password");
            edtPassword.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    private void initViews() {
        context = this;

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        isLogin = PrefsUtil.with(context).readBoolean(ConstantUtils.IS_LOGIN);
        if (isLogin) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
/*      edtUsername.setText("ODIN001");
        edtPassword.setText("9825098250");*/
    }

    @Override
    public void onBackPressed() {
        showConfirmDialog();
    }

    private void showConfirmDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(getString(R.string.txt_comfirm));
        alertDialog.setPositiveButton(getString(R.string.dialog_ok),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                    }
                });
        alertDialog.setNegativeButton(getString(R.string.dialog_cancel),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    @Override
    public void onResponseSuccess(Object response) {
        LoginResponse loginResponse = (LoginResponse) response;
        if (loginResponse.getAccessToken().length() > 0) {
            PrefsUtil.with(context).write(ConstantUtils.IS_LOGIN, true);
            PrefsUtil.with(context).write(ConstantUtils.TOKEN, loginResponse.getAccessToken());
            PrefsUtil.with(context).write(ConstantUtils.TOKEN_TYPE, loginResponse.getTokenType());
            PrefsUtil.with(context).write(ConstantUtils.USERNAME, loginResponse.getUserName());

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onResponseFail(String strErrorMessage) {
        if (strErrorMessage.length() == 0) {
            Toast.makeText(context, "Username or Password invalid", Toast.LENGTH_SHORT).show();
        }
    }
}