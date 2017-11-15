package dev.uublabs.multithreading;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Admin on 11/15/2017.
 */

public class MyAsyncTask extends AsyncTask<String, Integer, String>
{
    public static final String TAG = "AsyncTask";
    TextView textView;

    public MyAsyncTask(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: "+Thread.currentThread());

        textView.setText("Preparing the job");
    }

    @Override
    protected String doInBackground(String... strings)
    {
        Log.d(TAG, "doInBackground: "+Thread.currentThread());

        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        for (int i = 1; i < 5; i++)
        {

            publishProgress(i);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        return "Job completed";
    }

    @Override
    protected void onProgressUpdate(Integer... values)
    {
        super.onProgressUpdate(values);
        Log.d(TAG, "onProgressUpdate: "+values[0]+Thread.currentThread());

        textView.setText("Executing job: "+values[0]);
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        Log.d(TAG, "onPostExecute: "+Thread.currentThread());

        textView.setText(s);
    }

}
