package com.example.william.xebiabookshop.data.remote;

import com.example.william.xebiabookshop.data.models.OfferList;
import com.example.william.xebiabookshop.data.models.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface Service {

    @GET("/books")
    Call<List<Book>> getBooks();

    @GET("/books/{isbn}/commercialOffers")
    Call<OfferList> getOffers(@Path("isbn") String isbn);

}