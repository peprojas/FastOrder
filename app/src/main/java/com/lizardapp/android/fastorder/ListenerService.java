package com.lizardapp.android.fastorder;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by joserojas on 29/9/16.
 */

public class ListenerService extends InstanceIDListenerService {
    public ListenerService() {
    }

    @Override
    public void onTokenRefresh() {
        Intent intent = new Intent(this, RegistrationIntentService.class);
        startService(intent);
    }


}
