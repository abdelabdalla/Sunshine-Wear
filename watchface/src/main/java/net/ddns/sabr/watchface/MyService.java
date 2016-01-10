package net.ddns.sabr.watchface;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

public class MyService extends WearableListenerService {

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        if(messageEvent.getData().equals("/weather")){
            String m = new String(messageEvent.getData());

            String[] split = m.split("\n");


            Intent WeatherIntent = new Intent();
            WeatherIntent.setAction(Intent.ACTION_SEND);
            WeatherIntent.putExtra("high", split[0]);
            WeatherIntent.putExtra("low", split[1]);
            WeatherIntent.putExtra("icon", split[3]);
            LocalBroadcastManager.getInstance(this).sendBroadcast(WeatherIntent);
        }
    }
}
