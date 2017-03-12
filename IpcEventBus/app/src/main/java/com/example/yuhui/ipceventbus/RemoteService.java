package com.example.yuhui.ipceventbus;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2017/3/12.
 */
public class RemoteService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
