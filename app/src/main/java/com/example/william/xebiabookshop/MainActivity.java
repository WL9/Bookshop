package com.example.william.xebiabookshop;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.pager);
        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());

        adapter.addFragment(new TabShop(), "Boutique");
        adapter.addFragment(new TabCart(), "Panier");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
/*
    private Service mService = ApiUtils.getService();
    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;
    private OfferAdapter offerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mService = ApiUtils.getService();
        recyclerView = findViewById(R.id.recyclerView);
        bookAdapter = new BookAdapter(new ArrayList<Book>(0));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(bookAdapter);

        loadBooks();
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


    public void loadOffers (String ... isbns) {
        String reference = null;
        for (String isbn : isbns){
            if (reference.isEmpty())
                reference += isbn;
            else
                reference += ", " + isbn;
        }

        mService.getOffers(reference).enqueue(new Callback<OfferList>() {
            public void onResponse(Call<OfferList> call, Response<OfferList> response) {

                if(response.isSuccessful()) {
                    offerAdapter.updateOffers(response.body().getOffers());
                    Log.d("MainActivity", "posts loaded from API");
                }
                else {
                    int statusCode = response.code();
                    // TO DO : handle request errors depending on status code
                    Log.d("MainActivity", "error loading offers from API" + statusCode);
                }

            }

            public void onFailure(Call<OfferList> call, Throwable t) {
                //            showErrorMessage();
                Log.d("MainActivity", "error loading offers from API");

            }
        });
    }
    */
}