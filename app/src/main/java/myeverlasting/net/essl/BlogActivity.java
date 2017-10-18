package myeverlasting.net.essl;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import myeverlasting.net.essl.Adapter.BlogAdapter;
import myeverlasting.net.essl.Utils.Myutils;
import myeverlasting.net.essl.model.Blog;
import myeverlasting.net.essl.rest.ApiClient;
import myeverlasting.net.essl.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlogActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView brecycler;
    private RecyclerView.Adapter badapter;
    private RecyclerView.LayoutManager blayoutMgr;
    private ProgressBar progressBar;
    private static String LOG_TAG = "Blogs Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        brecycler = (RecyclerView) findViewById(R.id.blog_recycler);
        brecycler.setHasFixedSize(true);



        //badapter = new BlogAdapter(this,getBlogs());
        //brecycler.setAdapter(badapter);
        progressBar = (ProgressBar) findViewById(R.id.blogProgressbar);
        progressBar.setVisibility(View.VISIBLE);
        if(Myutils.checkNetwork(getApplicationContext())){
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<ArrayList<Blog>> call = apiService.getBlogs();
            call.enqueue(new Callback<ArrayList<Blog>>() {
                @Override
                public void onResponse(Call<ArrayList<Blog>> call, Response<ArrayList<Blog>> response) {
                    int statusCode = response.code();
                    ArrayList<Blog> blogs = response.body();

                    blayoutMgr = new LinearLayoutManager(getApplicationContext());
                    brecycler.setLayoutManager(blayoutMgr);
                    badapter = new BlogAdapter(getApplicationContext(),blogs);
                    brecycler.setAdapter(badapter);
                    progressBar.setVisibility(View.INVISIBLE);
                    Log.i(LOG_TAG, "REST call completed: " + statusCode + " data: " + blogs.size());
                }

                @Override
                public void onFailure(Call<ArrayList<Blog>> call, Throwable t) {
                    Log.e(LOG_TAG, t.toString());
                    progressBar.setVisibility(View.INVISIBLE);
                }
            });
        } else {
            Toast.makeText(this, "No or Poor Internet", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.INVISIBLE);
        }


        /*call.enqueue(new Callback<Blog>() {
            @Override
            public void onResponse(Call<Blog> call, Response<Blog> response) {
                int statusCode = response.code();
                ArrayList<Blog> blogs = response;
                brecycler = (RecyclerView) findViewById(R.id.blog_recycler);
                brecycler.setHasFixedSize(true);

                blayoutMgr = new LinearLayoutManager(getApplicationContext());
                brecycler.setLayoutManager(blayoutMgr);
                badapter = new BlogAdapter(getApplicationContext(),blogs);
                brecycler.setAdapter(badapter);
                Log.i(LOG_TAG, "REST call completed: " + statusCode + " data: " + blogs.size());
            }

            @Override
            public void onFailure(Call<BlogResponse> call, Throwable t) {
                Log.e(LOG_TAG, t.toString());
            }
        });*/




    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Overridecd 
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.blog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } /*else if (id == R.id.nav_dashboard) {
            Intent it = new Intent(this, Dashboard.class);
            startActivity(it);

        } */else if (id == R.id.nav_blog) {
            Intent inte = new Intent(this,BlogActivity.class);
            startActivity(inte);

        } else if (id == R.id.nav_products) {
            Intent ip = new Intent(this, Products.class);
            startActivity(ip);

        } else if(id == R.id.nav_con){
            Intent in = new Intent(this,ContactActivity.class);
            startActivity(in);
        } else if (id == R.id.nav_view) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
