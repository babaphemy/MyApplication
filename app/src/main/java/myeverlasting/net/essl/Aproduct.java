package myeverlasting.net.essl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Aproduct extends AppCompatActivity {
    private static String LOG_TAG="A Product Activity";
    private TextView pmsg,ptitle;
    private ImageView piv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aproduct);

        ptitle=(TextView) findViewById(R.id.lblapdtTitle);
        pmsg = (TextView) findViewById(R.id.lblPdtText);
        piv = (ImageView) findViewById(R.id.pdtImg);

        Bundle bp = getIntent().getExtras();
        String pt = bp.getString("ptitle");
        ptitle.setText(pt);
        pmsg.setText("Product details message");
    }
}
