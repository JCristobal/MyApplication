package com.example.jcristobal.myapplication;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by JCristobal on 05/05/2015.
 */
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        /* Setting the alarm here */

        // For our recurring task, we'll just display a message
        //Toast.makeText(context, "I'm running", Toast.LENGTH_SHORT).show();
        Toast toast2 =
                Toast.makeText(context,
                        "I'm running", Toast.LENGTH_SHORT);

        toast2.setGravity(Gravity.LEFT, (int) (Math.random() * (350)), (int) (Math.random() * (350)));
        toast2.show();


    }


}