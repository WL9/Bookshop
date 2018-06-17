package com.example.william.xebiabookshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import com.example.william.xebiabookshop.data.ApiUtils;
import com.example.william.xebiabookshop.data.ResponseAdapter;
import com.example.william.xebiabookshop.data.remote.Service;


public class MainActivity extends AppCompatActivity {

<<<<<<< HEAD
    private ResponseAdapter mResponseAdapter = new ResponseAdapter();
    private Service mService = ApiUtils.getService();
=======
    private RecyclerView recyclerView;
    private List<Book> books = new ArrayList<>();
>>>>>>> 71665ce... First View : book list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        mService = ApiUtils.getService();

        mResponseAdapter.loadBooks();
=======
        //FONCTION D'AJOUT DES LIVRES A LA LISTE

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new BookAdapter(books));
>>>>>>> 71665ce... First View : book list
    }
}