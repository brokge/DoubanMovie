package com.udaye.movie.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created  on 16-6-6.
 * <p/>
 * Toast 工具类
 */
public class ToastUtil {

    public static void showShortMessage(Context context, String msg) {
        if (context != null) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }
}
