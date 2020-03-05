package com.example.softwareen.api;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class SubstanceRetrieverFactory {

    public static SubstanceRetriever getInstance(Context context) {
        return null;
    }

    private static boolean isConnected(Context context) {
        boolean connected = false;
        //ensure we are connected to the internet
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            connected = true;
        }
        return connected;
    }

}