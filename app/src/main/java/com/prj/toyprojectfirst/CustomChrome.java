package com.prj.toyprojectfirst;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class CustomChrome extends WebChromeClient {
    private Context mContext;
    private AlertDialog mAlertDialog;
    private final String APP_NAME = "R.Space";

    public CustomChrome(Context context){
        mContext =context;
    }

    @Override
    public boolean onJsAlert(WebView view, String url, String message, final android.webkit.JsResult result){
        if(mAlertDialog == null){
            mAlertDialog = new AlertDialog.Builder(mContext)
                    .setTitle(APP_NAME)
                    .setMessage(message)
                    .setPositiveButton(android.R.string.ok, new AlertDialog.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            result.confirm();
                            mAlertDialog.dismiss();
                            mAlertDialog = null;
                        }
                    })
                    .setCancelable(false)
                    .create();
        }
        mAlertDialog.show();
        return true;
    }

    @Override
    public boolean onJsConfirm(final WebView view, final String url, final String message, final android.webkit.JsResult result){
        if(mAlertDialog == null){
            mAlertDialog = new AlertDialog.Builder(mContext)
                    .setTitle(APP_NAME)
                    .setMessage(message)
                    .setPositiveButton(android.R.string.ok, new AlertDialog.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            result.confirm();
                            mAlertDialog.dismiss();
                            mAlertDialog = null;
                        }
                    })
                    .setNegativeButton(android.R.string.cancel,new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which) {
                            result.cancel();
                            mAlertDialog.dismiss();
                            mAlertDialog = null;
                        }
                    })
                    .setCancelable(false)
                    .create();
        }
        mAlertDialog.show();
        return true;
    }
}
