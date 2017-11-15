package dev.uublabs.multithreading;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by Admin on 11/14/2017.
 */

public class MyThread extends Thread implements Runnable
{
    public static final String TAG = "MyThread";
    android.os.Handler handler;

    public MyThread(android.os.Handler handler)
    {
        this.handler = handler;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5; i++)
        {
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            Log.d(TAG, "run: " + Thread.currentThread() + " : " + i);
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putInt("value", i);
            message.setData(bundle);
            handler.sendMessage(message);
        }


    }
}
