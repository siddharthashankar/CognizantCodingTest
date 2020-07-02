package com.sid.cognizantcodingtest.requests;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AppExecutor {
    private static AppExecutor mInstance = null;
    public static AppExecutor getInstance(){
        if(mInstance == null){
            mInstance = new AppExecutor();
        }
        return mInstance;
    }

    private final ScheduledExecutorService mNetworkIO = Executors.newScheduledThreadPool(3);

    public ScheduledExecutorService networkIO(){
        return mNetworkIO;
    }

}
