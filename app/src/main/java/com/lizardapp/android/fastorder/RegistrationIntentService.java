package com.lizardapp.android.fastorder;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;

import fastorder.data.UpdateToken;

/**
 * Created by joserojas on 29/9/16.
 */

public class RegistrationIntentService extends IntentService {
    public RegistrationIntentService() {
        super("RegistrationIntentService");
    }


    @Override
    public void onHandleIntent(Intent intent) {

        InstanceID myinstancia = InstanceID.getInstance(this);

        String token = "";
        try {
             token = myinstancia.getToken(getString(R.string.gcm_defaultSenderId),
              GoogleCloudMessaging.INSTANCE_ID_SCOPE,null);

            Log.d("idgmc","id "+token);





        } catch (IOException e) {
            e.printStackTrace();
            Log.d("idgmc","id "+e);
        }


        String id=intent.getStringExtra("iduser");
        Log.d("idgmc","id "+id);
        UpdateToken tk = new UpdateToken();

        tk.execute(id,token);


        Log.d("token cms","tk "+token) ;

    }





}



