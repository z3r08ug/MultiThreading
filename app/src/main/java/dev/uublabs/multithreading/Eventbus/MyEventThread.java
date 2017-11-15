package dev.uublabs.multithreading.Eventbus;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Admin on 11/15/2017.
 */

public class MyEventThread extends Thread
{
    @Override
    public void run()
    {
        super.run();

        //do the job
        MessageEvent messageEvent = new MessageEvent("This is the result");
        //post the result
        EventBus.getDefault().post(messageEvent);
    }
}
