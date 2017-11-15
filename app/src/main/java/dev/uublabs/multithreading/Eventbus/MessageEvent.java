package dev.uublabs.multithreading.Eventbus;

/**
 * Created by Admin on 11/15/2017.
 */

public class MessageEvent
{
    String data;

    public MessageEvent(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
