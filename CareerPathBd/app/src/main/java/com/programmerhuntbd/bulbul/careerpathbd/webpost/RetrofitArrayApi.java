package com.programmerhuntbd.bulbul.careerpathbd.webpost;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by bulbul on 10/19/2018.
 */

public interface RetrofitArrayApi {

    @GET("wp-json/wp/v2/posts")
    Call<List<WPPost>> getPostInfo();
    /// to make call to dynamic URL
    //  @GET
    //  Call<List<WPPost>> getPostInfo(@Url String url);
    //

}