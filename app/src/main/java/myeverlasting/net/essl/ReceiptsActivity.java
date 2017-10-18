package myeverlasting.net.essl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import myeverlasting.net.essl.Adapter.ReceiptsAdapter;
import myeverlasting.net.essl.model.*;

public class ReceiptsActivity extends AppCompatActivity {
    private static String LOG_TAG="ReceiptsActivity";
    private RecyclerView rRecyclerView;
    private RecyclerView.Adapter rAdapter;
    private RecyclerView.LayoutManager rLayoutMgr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipts);

        rRecyclerView = (RecyclerView) findViewById(R.id.receipt_recycler);
        rRecyclerView.setHasFixedSize(true);

        rLayoutMgr = new LinearLayoutManager(this);
        rRecyclerView.setLayoutManager(rLayoutMgr);

        rAdapter = new ReceiptsAdapter(getData());
        rRecyclerView.setAdapter(rAdapter);

    }

    public void onResume(){
        super.onResume();
        ((ReceiptsAdapter) rAdapter).setOnItemClickListener(new ReceiptsAdapter.MyClickListener(){

            @Override
            public void onItemClick(int position, View v) {
                Toast.makeText(ReceiptsActivity.this, "Clicked guy is " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<Receipt> getData(){
        ArrayList<Receipt> recs = new ArrayList<Receipt>();
        Receipt rr = new Receipt("Domain Name","Domain Name Payment for Prestige-ipc.com","21-12-2017","N5000");
        recs.add(rr);
        Receipt rr1 = new Receipt("Domain reg", "Domain registration for Latito.com", "22-12-2017", "N5,000");
        recs.add(rr1);
        Receipt rr2 = new Receipt("Wenhosting latito", "Webhosting payment for latito,com", "22-12-2017", "N20,000");
        recs.add(rr2);
        return recs;
    }

}
