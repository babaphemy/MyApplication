package myeverlasting.net.essl;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.File;

public class AblogActivity extends AppCompatActivity {
    private static String LOG_TAG="Ablog ACtivity";
    private TextView title,msg;
    public ImageView ivr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ablog);

        title = (TextView) findViewById(R.id.lblablogTitle);
        ivr = (ImageView) findViewById(R.id.ablog_img);
        msg = (TextView) findViewById(R.id.lblBlogText);

        Bundle bn = getIntent().getExtras();
        String tit = bn.getString("blog");
        String msgg = bn.getString("btext");
        String thumb = bn.getString("bfile");
        title.setText(tit);
        msg.setText(msgg);
        //Glide.with(getApplicationContext()).load(new File("https://myeverlasting.net/img/logo.png")).into(iv);
        //Glide.with(this).load(new File("https://myeverlasting.net/img/logo.png")).into(iv);
        Glide.with(getApplicationContext()).load(thumb).into(ivr);
        Log.i(LOG_TAG, "the image" + thumb);

    }
}
