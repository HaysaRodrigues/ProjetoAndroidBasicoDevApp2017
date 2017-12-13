package com.haysarodrigues.ui.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.haysarodrigues.tvshow.R;

/**
 * Created by Haysa on 10/08/17.
 */

public class NotificationWishList {

    public static void notify(Context context, int id, Intent intent, String contentTitle, String contentText){

        NotificationManager nManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent pI = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context).
                setContentIntent(pI).
                setContentTitle(contentTitle).
                setContentText(contentText).
                setSmallIcon(R.mipmap.ic_live_tv_black_24dp).
                setAutoCancel(true);

        Notification n = builder.build();
        nManager.notify(id, n);

    }
}
