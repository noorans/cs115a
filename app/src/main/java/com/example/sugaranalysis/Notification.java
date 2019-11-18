package com.example.sugaranalysis;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import androidx.core.app.NotificationCompat;


public class Notification extends ActionBarActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueID = 45612;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);


    }

    public void buttonClicked(View view) {
        //Builds the notification
        notification.setSmallIcon(R.drawable.id.ic_launcher);
        notification.setTicker("This is the ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Here is the title");
        notification.setContentTitle("Here is an alert");

        Intent intent = newIntent(this. MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, Intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //Build the notification and will issue it
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());

    }
}
