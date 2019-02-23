package com.fitple.fcmsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

public class MainActivity extends AppCompatActivity {
    Button send;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Bundle bundle = new Bundle();
        find();
        bundle.getString("ffff");
        FirebaseMessaging.getInstance().subscribeToTopic("notify");

        FirebaseMessagingService firebaseMessagingService = new FirebaseMessagingService();

        firebaseMessagingService.onMessageReceived(new RemoteMessage(bundle));

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textValue = editText.getText().toString();
                editText.setText("");
                Log.v("gettext", "text = " + textValue);

            }
        });

    }

    public void find(){
        send = (Button)findViewById(R.id.btn);
        editText = (EditText)findViewById(R.id.et);
    }
}
