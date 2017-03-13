package com.example.yuhui.ipceventbus;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import com.example.yuhui.ipceventbus.aidl.IEventChanel;
import com.example.yuhui.ipceventbus.aidl.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends Activity {
    IEventChanel iEventChanel;

    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iEventChanel = IEventChanel.Stub.asInterface(service);
            MessageEvent messageEvent = new MessageEvent("16", "hello");
            EventBus.getDefault().post(service, messageEvent);
//            try {
//                iEventChanel.postEvent(messageEvent);
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        Intent intent = new Intent();
        intent.setClass(this, RemoteService.class);
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        unbindService(conn);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        Toast.makeText(this, "Client Activity " + event.toString(), Toast.LENGTH_SHORT).show();
    }
}
