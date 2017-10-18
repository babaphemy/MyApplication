package myeverlasting.net.essl;

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
import myeverlasting.net.essl.model.Support;
import myeverlasting.net.essl.rest.ApiClient;
import myeverlasting.net.essl.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactActivity extends AppCompatActivity {
    private static final String LOG_TAG = "ContactActivity";
    private ProgressBar progressBar;
    private TextView name,email,phone,msg;
    private Button supportSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        name = (TextView) findViewById(R.id.txtSupportName);
        email = (TextView) findViewById(R.id.txtSupportEmail);
        phone = (TextView) findViewById(R.id.txtSupportPhone);
        msg = (TextView) findViewById(R.id.txtSupportMsg);
        progressBar = (ProgressBar) findViewById(R.id.contactProgressbar);
        supportSubmit = (Button) findViewById(R.id.btnLead);

        supportSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Myutils.checkNetwork(getApplicationContext())){
                    progressBar.setVisibility(View.VISIBLE);
                    Support ss = new Support();
                    ss.setName(name.getText().toString());
                    ss.setEmail(email.getText().toString());
                    ss.setMessage(msg.getText().toString());
                    ss.setContactmeans(phone.getText().toString());
                    addSupport(ss);

                } else {
                    Toast.makeText(ContactActivity.this, "Poor or No Internet", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }

            }
        });


    }

    public void addSupport(Support support){
        ApiInterface apiServices = ApiClient.getClient().create(ApiInterface.class);
        Call<String> res = apiServices.addSupport(support);
        res.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(ContactActivity.this, response.body(), Toast.LENGTH_SHORT).show();
                Intent in = new Intent(getApplicationContext(), BlogActivity.class);
                startActivity(in);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e(LOG_TAG, t.toString());
                progressBar.setVisibility(View.INVISIBLE);

            }
        });

    }
}
