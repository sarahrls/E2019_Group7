package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class SimpleNotif extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_notif);
        Button btnNotify = (Button)findViewById(R.id.btnShow);
        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder mBuilder
                        = new NotificationCompat.Builder(SimpleNotif.this)
                        .setSmallIcon(R.drawable.ic_notification)
                        .setContentTitle("GROUP7 Send New Message")
                        .setContentText("Hi,Welcome to BSCS E2019");
// Set the intent to fire when the user taps on notification.
                Intent resultIntent = new Intent(SimpleNotif.this, SimpleNotif.class);
                PendingIntent pendingIntent =
                        PendingIntent.getActivity(SimpleNotif.this, 0, resultIntent, 0);
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