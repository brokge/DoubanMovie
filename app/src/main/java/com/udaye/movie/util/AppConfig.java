package com.udaye.movie.util;

import android.content.Context;

/**
 * 应用配置
 * <p/>
 * Created  on 16/7/4.
 */
public class AppConfig {

    private static String KEY_IS_SEE = "key_is_see";
    private static String KEY_IS_Cache = "key_is_cache";

    /**
     * 设置是否只看女明星
     *
     * @param context
     * @param isSee
     */
    public static void setIsSee(Context context, boolean isSee) {
        SPUtils.put(context, KEY_IS_SEE, isSee);
    }

    /**
     * 获取是否只看女明星
     *
     * @param context
     * @return
     */
    public static boolean getIsSee(Context context) {
        return (boolean) SPUtils.get(context, KEY_IS_SEE, false);
    }

    /**
     * 设置是否缓存数据
     *
     * @param context
     * @param isSee
     */
    public static void setIsCache(Context context, boolean isSee) {
        SPUtils.put(context, KEY_IS_Cache, isSee);
    }

    /**
     * 获取是否缓存数据
     *
     * @param context
     * @return
     */
    public static boolean getIsCache(Context context) {
        return (boolean) SPUtils.get(context, KEY_IS_Cache, true);
    }

}
