package com.learning.android.notifications;

import android.app.Activity;
import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);

                createNotifications();
            }
        });
    }

    private void createNotifications() {
        List<String> titles = new ArrayList<String>();
        titles.add("Hello Android Mobile");
        titles.add("Hello Android Wear");
        titles.add("Hello Android TV");
        titles.add("Hello Android Tablet");

        for (int i = 0; i < titles.size(); i++) {
            System.out.println("------- Create Notifications called in MainPhoneActivity -------" + i);
            // Shown in wear
            NotificationCompat.WearableExtender wearableExtender =
                    new NotificationCompat.WearableExtender()
                            .setHintShowBackgroundOnly(true);

            // Shown in Handheld
            Notification notification = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.ic_launcher)
                    .setContentTitle(titles.get(i))
                    .setContentText("Learning Wearable notification." + (i+1))
                    .extend(wearableExtender)
                    .build();

            // int notificationId = 1;
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(i + 1, notification);
        }
    }

}
