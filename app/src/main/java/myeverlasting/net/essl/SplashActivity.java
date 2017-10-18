package myeverlasting.net.essl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this,BlogActivity.class);
        startActivity(intent);
        finish();

        //setContentView(R.layout.activity_splash);
    }
}
