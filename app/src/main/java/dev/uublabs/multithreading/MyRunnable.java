package dev.uublabs.multithreading;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Admin on 11/14/2017.
 */

public class MyRunnable implements Runnable
{
    private static final String TAG = "MyRunnable";
    TextView textView;
    private Handler handler = new Handler(Looper.getMainLooper());

    public MyRunnable(TextView tvMain)
    {
        this.textView = tvMain;
    }
    int i;
    @Override
    public void run()
    {
        for ( i = 0; i < 5; i++)
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

            handler.post(new Runnable()
            {
                @Override
                public void run()
                {
                    textView.setText("" + i + Thread.currentThread());
                }
            });
        }
    }
}
