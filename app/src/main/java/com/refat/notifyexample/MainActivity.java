package com.refat.notifyexample;


public class MainActivity extends AppCompatActivity {
    private NotificationCompat.Builder nb;
    private static final int notificationID=501;
    private NotificationManager nm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnNotify = (Button) findViewById(R.id.btnNotify);
        nb = new NotificationCompat.Builder(this);
        nb.setAutoCancel(true);
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        btnNotify.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                nb.setTicker("This is the ticker text");
                nb.setContentTitle("The Title");
                nb.setContentText("This is the main body of the notification. many lines of code can be viewed here.");
                nb.setWhen(System.currentTimeMillis());

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                nb.setContentIntent(pendingIntent);
                nm.notify(notificationID,nb.build());
            }
        });
    }
}
