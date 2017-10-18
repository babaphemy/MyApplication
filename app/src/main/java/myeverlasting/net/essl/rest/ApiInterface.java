package myeverlasting.net.essl.rest;

import java.util.ArrayList;

import myeverlasting.net.essl.model.Blog;
import myeverlasting.net.essl.model.Lead;
import myeverlasting.net.essl.model.Support;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by babafemi on 10/14/2017.
 */

public interface ApiInterface {
    @POST("api/support/add")
    Call<String> addSupport(@Body Support support);
    @POST("api/quote/new")
    Call<Lead> addLead(@Body Lead lead);

    @GET("api/blog/all")
    Call<ArrayList<Blog>> getBlogs();
}
