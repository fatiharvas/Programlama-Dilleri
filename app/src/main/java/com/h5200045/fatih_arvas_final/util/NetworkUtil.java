package com.h5200045.fatih_arvas_final.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// NetworkUtil classı internet kontrolünün yapılması için oluşturulmuştur.
public class NetworkUtil {

    /*İnternet kontrolü için boolean değer dönen isInternetConnection fonksiyonu oluşturulmuştur.
     *Bu fonksiyon Context türünde bir context parametresi alır.
     *True değer dönmesi internetin bağlı olduğunu, False değer dönmesi internetin bağlı olmadığını gösterir.
     */
    public static boolean isInternetConnection(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();

        return netInfo != null && netInfo.isAvailable() && netInfo.isConnected();

    }
}
