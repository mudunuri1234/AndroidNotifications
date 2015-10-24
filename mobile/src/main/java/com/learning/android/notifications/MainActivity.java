package com.learning.android.notifications;

import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotifications();
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
