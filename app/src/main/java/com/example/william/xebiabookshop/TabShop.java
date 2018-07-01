package com.example.william.xebiabookshop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.william.xebiabookshop.data.ApiUtils;
import com.example.william.xebiabookshop.data.models.Book;
import com.example.william.xebiabookshop.data.remote.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TabShop extends Fragment{

    private Service mService = ApiUtils.getService();
    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;

    public TabShop() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View shopView = inflater.inflate(R.layout.fragment_shop, container, false);
        mService = ApiUtils.getService();
        recyclerView = shopView.findViewById(R.id.recyclerView);
        bookAdapter = new BookAdapter(new ArrayList<Book>(0));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(bookAdapter);
        loadBooks();

        return shopView;
    }

    public void loadBooks () {
        mService.getBooks().enqueue(new Callback<List<Book>>() {
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful()) {
                    bookAdapter.updateBooks(response.body());
                    Log.d("MainActivity", "Books loaded from API");
                }
                else {
                    int statusCode = response.code();
                    // TO DO : handle request errors depending on status code
                    Log.d("MainActivity", "error loading books from API" + statusCode);
                }
            }

            public void onFailure(Call<List<Book>> call, Throwable t) {
                Log.d("MainActivity", "error loading books from API");

            }
        });
    }
}