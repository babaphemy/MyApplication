package myeverlasting.net.essl;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import myeverlasting.net.essl.Utils.Myutils;
import myeverlasting.net.essl.model.Lead;
import myeverlasting.net.essl.rest.ApiClient;
import myeverlasting.net.essl.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuoteActivity extends AppCompatActivity {
    private static String LOG_TAG = "Quote Activity";
    private TextView email,phone,name,msg;
    private Button send;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        email = (TextView) findViewById(R.id.txtReq_email);
        phone = (TextView) findViewById(R.id.txtReq_phone);
        name = (TextView) findViewById(R.id.txtReq_name);
        msg = (TextView) findViewById(R.id.txtReq_message);
        send = (Button) findViewById(R.id.txtReq_submit);
        progressBar = (ProgressBar) findViewById(R.id.quoteProgressbar);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                Lead ld = new Lead();
                ld.setMessage(msg.getText().toString());
                ld.setEmail(email.getText().toString());
                ld.setMobile(phone.getText().toString());
                ld.setName(name.getText().toString());
                // get user location
                // get project type tooo
                if(Myutils.checkNetwork(getApplicationContext())){
                    addQuote(ld);
                } else {
                    Toast.makeText(QuoteActivity.this, "Poor or No Internet!", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }

    public void addQuote(Lead quote){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Lead> call = apiService.addLead(quote);
        call.enqueue(new Callback<Lead>() {
            @Override
            public void onResponse(Call<Lead> call, Response<Lead> response) {
                progressBar.setVisibility(View.INVISIBLE);
                Log.i(LOG_TAG, response.code() + " is the response code");
                Toast.makeText(QuoteActivity.this, "Dear " + response.body().getName() + ", we will contact you shortly!", Toast.LENGTH_LONG).show();
                Intent inte = new Intent(getApplicationContext(), BlogActivity.class);
                startActivity(inte);
            }

            @Override
            public void onFailure(Call<Lead> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Log.e(LOG_TAG, t.toString());
            }
        });
    }
}
