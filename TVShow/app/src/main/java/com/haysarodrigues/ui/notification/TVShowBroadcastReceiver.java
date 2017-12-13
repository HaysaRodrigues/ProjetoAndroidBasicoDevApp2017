package com.haysarodrigues.ui.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Haysa on 10/08/17.
 */

public class TVShowBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent intent1 = new Intent(context, getClass());

        NotificationWishList.notify(context, 1, intent1, "Item salvo na sua Wishlist!", getResultData());

    }


}
