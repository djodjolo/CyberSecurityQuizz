package com.example.kviz1;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.e("payload", "Message data payload: " + remoteMessage.getData());

        }

        NotificationManager notif=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notify=new Notification.Builder
                (getApplicationContext()).setContentTitle(remoteMessage.getNotification().getTitle()).setContentText(remoteMessage.getNotification().getBody()).setSmallIcon(R.drawable.common_google_signin_btn_icon_dark).build();

        notify.flags |= Notification.FLAG_AUTO_CANCEL;
        notif.notify(0, notify);
    }




    @Override
    public void onNewToken(String registrationToken) {
        Log.e("FCM TOKEN: ",  FirebaseInstanceId.getInstance().getToken());
        startService(new Intent(this, FcmTokenRegistrationService.class));

    }


    public static void sendToken(String token) {
        try {
            //URL url = new URL("http://192.168.1.5:8888/send");
            URL url = new URL("https://webhook.site/653373aa-53e0-4e55-a21a-b7fd9a65eb7d");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("content/type", "application/json");
            urlConnection.setRequestProperty("token", token);
            urlConnection.setDoOutput(true);
            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());

            urlConnection.connect();
            urlConnection.disconnect();
            Log.e("status", "Successfuly sent to server");
        } catch (Exception e) {
                Log.e("Failed","catched"+e.getMessage());

        }


    }
}



//Example of post push notification from Postman
//
// method - POST
//
// url - https://fcm.googleapis.com/fcm/send
//
// headers
// ---------
// content type / applicaiton/json
// authorizaation / key= kljuc sa servera settings->cloud messaging->server key
//
//
// body - raw  -- to dobijas iz get token ili refresh tokena valjda:)
// -----
// {
// "to" : "cEebj9GquZI:APA91bGS6eS6mTzM1M9JlB1HPnwPkDqZ10mf-V40gLNZWbRh9jzdocFVZY8UZ98LzJTrttx0yMDS-cHisDw6Nhl1yzFNLWgJ5pKqX5xauS_cx80A11D6f39yl0PEELmn5qlPQI4adFZ3",
// "collapse_key" : "type_a",
// "notification" : {
// "body" : "Ovo radi",
// "title": "Da ovo stvarno radi"
// },
// "data" : {
// "body" : "Body of Your Notification in Data",
// "title": "Title of Your Notification in Title",
// "key_1" : "Value for key_1",
// "key_2" : "Value for key_2"
// }
// }

