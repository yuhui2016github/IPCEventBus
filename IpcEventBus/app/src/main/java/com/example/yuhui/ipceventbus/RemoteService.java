package com.example.yuhui.ipceventbus;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.yuhui.ipceventbus.aidl.IEventChanel;
import com.example.yuhui.ipceventbus.aidl.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Administrator on 2017/3/12.
 */
public class RemoteService extends Service {
    private LocalBinder localBinder = new LocalBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    class LocalBinder extends IEventChanel.Stub {
        @Override
        public void postEvent(MessageEvent messageEvent) throws RemoteException {
            EventBus.getDefault().post(messageEvent);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        Toast.makeText(this, "remote service " + event.toString(), Toast.LENGTH_SHORT).show();
    }
}
