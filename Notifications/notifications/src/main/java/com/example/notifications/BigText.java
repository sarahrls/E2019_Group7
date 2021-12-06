package com.example.notifications;

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

public class BigText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_text);
        Button btnNotify = (Button)findViewById(R.id.btnShow);
        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//To set large icon in notification
                Bitmap licon = BitmapFactory.decodeResource(getResources(),
                        R.drawable.ic_notification);
//Assign BigText style notification
                NotificationCompat.BigTextStyle bigText
                        = new NotificationCompat.BigTextStyle();
                bigText.bigText("Welcome to BSCS E2019,this provides about the activity in android studio and this activity is custom big text notification");
                bigText.setSummaryText("By: GROUP7");
                NotificationCompat.Builder mBuilder
                        = new NotificationCompat.Builder(BigText.this)
                        .setSmallIcon(R.drawable.ic_notification)
                        .setContentTitle("Big Text Notification Example")

                        .setLargeIcon(licon)
                        .setStyle(bigText);
// Set the intent to fire when the user taps on notification.
                Intent resultIntent = new Intent(BigText.this,
                        MainActivity.class);
                PendingIntent pendingIntent =
                        PendingIntent.getActivity(BigText.this, 0, resultIntent, 0);
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