package com.example.anime;

import android.content.Context;

import com.android.volley.*;
import com.android.volley.toolbox.Volley;

public class SingletonClass {
    private static SingletonClass singletonClass;
    private RequestQueue requestQueue;
    private Context mContext;

    private SingletonClass(Context context) {
        mContext = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(mContext);
        return requestQueue;
    }

    public static SingletonClass getInstance(Context context) {
        if (singletonClass == null)
            singletonClass = new SingletonClass(context);
        return singletonClass;
    }

    public <T> void addToRequestQueue(Request<T> request) {

        requestQueue.add(request);
    }

}
