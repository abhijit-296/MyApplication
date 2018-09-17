package com.example.mylibrary;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {
    public MyService() {
    }

    MyImpl impl = new MyImpl();


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
      //  throw new UnsupportedOperationException("Not yet implemented");
        return impl;
    }

    class MyImpl extends IMyAidlInterface.Stub {

        @Override
        public int calculate(int num1, int num2) throws RemoteException {
            return num1 + num2;
        }
    }
}
