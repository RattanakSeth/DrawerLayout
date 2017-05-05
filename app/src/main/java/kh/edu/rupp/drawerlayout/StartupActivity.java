package kh.edu.rupp.drawerlayout;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartupActivity extends AppCompatActivity {

    private int timeDalay = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startNextActivtiy();
                finish();
            }
        },timeDalay);

    }


    void startNextActivtiy()
    {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
