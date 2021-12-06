package com.example.bigtext;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnNotify = (Button)findViewById(R.id.btnShow);
        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//To set large icon in notification
                Bitmap licon = BitmapFactory.decodeResource(getResources(),
                                R.drawable.ic_baseline_notifications_24);
//Assign BigText style notification
                NotificationCompat.BigTextStyle bigText
                        = new NotificationCompat.BigTextStyle();
                bigText.bigText("Welcome to tutlane, it provides a tutorials related to all technologies in software industry. Here we covered complete tutorials from basic to adavanced topics from all technologies");
                        bigText.setSummaryText("By: Tutlane");
                NotificationCompat.Builder mBuilder
                        = new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.drawable.ic_notification)
                        .setContentTitle("Big Text Notification Example")

                                        .setLargeIcon(licon)
                                        .setStyle(bigText);
// Set the intent to fire when the user taps on notification.
                        Intent resultIntent = new Intent(MainActivity.this,
                        MainActivity.class);
                PendingIntent pendingIntent =
                        PendingIntent.getActivity(MainActivity.this, 0, resultIntent, 0);
                mBuilder.setContentIntent(pendingIntent);
// Sets an ID for the notification
                int mNotificationId = 001;
                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
// It will display the notification in notification bar
                notificationManager.notify(mNotificationId,
                        mBuilder.build());
            }
        });
    }
}