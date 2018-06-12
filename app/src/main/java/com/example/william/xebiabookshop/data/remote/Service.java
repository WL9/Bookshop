package com.example.william.xebiabookshop.data.remote;

import com.example.william.xebiabookshop.data.models.Answer;
import com.example.william.xebiabookshop.data.models.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface Service {

    @GET("/books")
    Call<List<Book>> getBooks();

    @GET("/books/c8fabf68-8374-48fe-a7ea-a00ccd07afff,a460afed-e5e7-4e39-a39d-c885c05db861/commercialOffers")
    Call<Answer> getOffers();

    @GET("/books/{isbn}/commercialOffers")
    Call<Answer> getOffers(@Path("isbn") String isbn);

}