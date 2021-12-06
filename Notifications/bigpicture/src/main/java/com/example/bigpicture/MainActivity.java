package com.example.bigpicture;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
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
// Assign big picture notification
                NotificationCompat.BigPictureStyle bpStyle
                        = new NotificationCompat.BigPictureStyle();
                bpStyle.bigPicture(BitmapFactory.decodeResource(getResources(),
                        R.drawable.beach_resorts_batangas)).build();
// Set the intent to fire when the user taps on notification.
                        Intent rIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://tutlane.com/"));
                PendingIntent pendingIntent =
                        PendingIntent.getActivity(MainActivity.this, 0, rIntent, 0);
                NotificationCompat.Builder mBuilder
                        = new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.drawable.ic_notification)
                        .setContentTitle("Big Picture Notification Example")
                                        .addAction(R.drawable.ic_share, "Share",
                                                pendingIntent)
                                        .setStyle(bpStyle);
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