package org.greenrobot.eventbus.IPC;

import android.os.IBinder;

/**
 * Created by yuhui on 2017-3-13.
 */
public class RemoteBinderWrapper {
    private String interfaceName;
    private IBinder iBinder;

    public RemoteBinderWrapper(String interfaceName, IBinder iBinder) {
        this.interfaceName = interfaceName;
        this.iBinder = iBinder;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public IBinder getiBinder() {
        return iBinder;
    }
}
