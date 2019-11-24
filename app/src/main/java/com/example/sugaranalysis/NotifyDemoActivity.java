package com.example.sugaranalysis;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.app.NotificationManager;
import android.app.NotificationChannel;
import android.content.Context;
import android.graphics.Color;
import android.app.Notification;
import android.view.View;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.Icon;


public class NotifyDemoActivity extends AppCompatActivity {

    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify_demo);

        notificationManager =
                (NotificationManager)
                        getSystemService(Context.NOTIFICATION_SERVICE);

        createNotificationChannel(
                "com.example.sugaranalysis",
                "NotifyDemo News",
                "Example News Channel");
    }

    protected void createNotificationChannel(String id, String name,
                                             String description) {

        int importance = NotificationManager.IMPORTANCE_LOW;
        NotificationChannel channel =
                new NotificationChannel(id, name, importance);

        channel.setDescription(description);
        channel.enableLights(true);
        channel.setLightColor(Color.RED);
        channel.enableVibration(true);
        channel.setVibrationPattern(
                new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
        notificationManager.createNotificationChannel(channel);
    }

    protected void sendNotification(View view) {

        int notificationId = 101;

        Intent resultIntent = new Intent(this, ResultActivity.class);

        PendingIntent pendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        String CHANNEL_ID = "com.example.sugaranalysis";

        Notification notification = new Notification.Builder(NotifyDemoActivity.this, CHANNEL_ID)
                .setContentTitle("Example Notification")
                .setContentText("This is an  example notification.")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setChannelId(CHANNEL_ID)
                .setContentIntent(pendingIntent)
                .build();

        notificationManager.notify(notificationId, notification);


    }
}
