package com.example.william.xebiabookshop.shopfragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.william.xebiabookshop.R;
import com.example.william.xebiabookshop.SharedViewModel;
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
    private SharedViewModel model;
    private List<Book> cart;


    public TabShop() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View shopView = inflater.inflate(R.layout.fragment_shop, container, false);
        recyclerView = shopView.findViewById(R.id.recyclerView);
        bookAdapter = new BookAdapter(new ArrayList<Book>(0), new BookAdapter.AddCartClickListener() {
            @Override
            public void addCartOnClick(View v, List<Book> shoppingCart) {
                cart = shoppingCart;
                model.select(cart);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(bookAdapter);
        bookAdapter.notifyDataSetChanged();
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