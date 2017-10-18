package myeverlasting.net.essl.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by babafemi on 10/14/2017.
 */

public class ApiClient {
    public static final String API_URL="https://biztool.herokuapp.com/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
