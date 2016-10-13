package com.lizardapp.android.fastorder;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Created by joserojas on 28/9/16.
 */
public class MyFirebaseInstanceIDService extends MyFirebaseMessagingService{


    @Override
    public void onTokenRefresh() {


        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("TOKEN", "Refreshed token: " + refreshedToken);


        // TODO: Implement this method to send any registration to your app's servers.
        sendRegistrationToServer(refreshedToken);

        super.onTokenRefresh();
    }

    private void sendRegistrationToServer(String refreshedToken) {




    }
}

