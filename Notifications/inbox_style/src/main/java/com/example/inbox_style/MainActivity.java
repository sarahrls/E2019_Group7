package com.example.inbox_style;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
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
//Implement inbox style notification
                NotificationCompat.InboxStyle iStyle
                        = new NotificationCompat.InboxStyle();
                iStyle.addLine("Message 1.");
                iStyle.addLine("Message 2.");
                iStyle.addLine("Message 3.");
                iStyle.addLine("Message 4.");
                iStyle.addLine("Message 5.");
                iStyle.setSummaryText("+2 more");
                NotificationCompat.Builder mBuilder
                        = new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.drawable.ic_notification)
                        .setContentTitle("Inbox Style Notification Example")
                                        .setStyle(iStyle);
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