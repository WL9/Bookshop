package com.example.william.xebiabookshop.data.remote;

import com.example.william.xebiabookshop.data.models.BooksAnswer;
import com.example.william.xebiabookshop.data.models.OffersAnswer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("/books")
    Call<BooksAnswer> getBooks();

    @GET("/books")
    Call<BooksAnswer> getBooks(@Query("tagged") String tags);

    @GET("/books/c8fabf68-8374-48fe-a7ea-a00ccd07afff,a460afed-e5e7-4e39-a39d-c885c05db861/commercialOffers")
    Call<OffersAnswer> getOffers();

    @GET("/books/c8fabf68-8374-48fe-a7ea-a00ccd07afff,a460afed-e5e7-4e39-a39d-c885c05db861/commercialOffers")
    Call<OffersAnswer> getOffers(@Query("tagged") String tags);

}