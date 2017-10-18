package myeverlasting.net.essl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import myeverlasting.net.essl.Adapter.MyRecyclerViewAdapter;
import myeverlasting.net.essl.model.CardviewData;

public class Dashboard extends AppCompatActivity {
    private RecyclerView mrecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutMgr;
    private static String LOG_TAG = "Dashboard Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mrecycler = (RecyclerView) findViewById(R.id.dsh_recycler);
        mrecycler.setHasFixedSize(true);

        mLayoutMgr = new LinearLayoutManager(this);
        mrecycler.setLayoutManager(mLayoutMgr);
        mAdapter = new MyRecyclerViewAdapter(getDataSets());
        mrecycler.setAdapter(mAdapter);




    }

    public void onResume(){
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter.MyClickListener(){
            @Override
            public void onItemClick(int position, View v) {
                //Log.i(LOG_TAG, " Clicked on Item " + position);
                if(position == 0){
                    //Intent in = new Intent(this, Notification)
                    Toast.makeText(Dashboard.this, "Fetch notifications", Toast.LENGTH_SHORT).show();
                } else if(position == 1){
                    Intent inte = new Intent(Dashboard.this, Invoices.class);
                    startActivity(inte);
                } else if(position == 2){
                    Intent inte = new Intent(Dashboard.this, ReceiptsActivity.class);
                    startActivity(inte);
                }
            }
        });

    }

    public ArrayList<CardviewData> getDataSets(){
        ArrayList res = new ArrayList<CardviewData>();
        CardviewData cd = new CardviewData("Notifications", "You have (12) messages");
        res.add(cd);
        CardviewData cd1 = new CardviewData("Invoices", "(10) invoices prepared");
        res.add(cd1);
        CardviewData cd2 = new CardviewData("Transactions", "(39) transactions in total" );
        res.add(cd2);
        //for(int index=0; index < res.size(); index ++){
            //CardviewData obj = new CardviewData("Some text here " + index, "secondary text here " + index);
            //res.add(index,obj);

        //}
        return res;

    }
}
