package myeverlasting.net.essl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import myeverlasting.net.essl.Adapter.ProductAdapter;
import myeverlasting.net.essl.model.Product;

public class Products extends AppCompatActivity {
    private RecyclerView precyclerView;
    private RecyclerView.Adapter padapter;
    private RecyclerView.LayoutManager pLayoutMgr;
    private static String LOG_TAG = "Products Activity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        precyclerView = (RecyclerView) findViewById(R.id.pdt_recycler);
        precyclerView.setHasFixedSize(true);

        pLayoutMgr = new LinearLayoutManager(this);
        precyclerView.setLayoutManager(pLayoutMgr);
        padapter = new ProductAdapter(this,getPdts());
        precyclerView.setAdapter(padapter);


        
    }

    public ArrayList<Product> getPdts(){
        ArrayList<Product> pp = new ArrayList<Product>();
        Product pr = new Product("001","UI/UX","CALL","UI/UX Designs and Consulting","UI/UX Designs and Consulting",R.drawable.uiux);
        pp.add(pr);
        Product pr1 = new Product("002", "Software Devpt", "CALL", "Professional website development","Professional website development", R.drawable.soft);
        pp.add(pr1);

        return pp;
    }


    public void openQuote(){
        Intent it = new Intent(this,QuoteActivity.class);
        startActivity(it);
    }


}
