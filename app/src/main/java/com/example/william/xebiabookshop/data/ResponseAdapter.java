package com.example.william.xebiabookshop.data;

import android.os.AsyncTask;
import android.util.Log;

import com.example.william.xebiabookshop.data.models.Answer;
import com.example.william.xebiabookshop.data.models.Book;
import com.example.william.xebiabookshop.data.models.Offer;
import com.example.william.xebiabookshop.data.remote.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResponseAdapter {

    private List<Book> mBooks = new ArrayList<>();
    private List<Offer> mOffers = new ArrayList<>();

    private Service mService = ApiUtils.getService();


    public void loadBooks () {
        mService.getBooks().enqueue(new Callback<List<Book>>() {
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful()) {
                    Log.d("MainActivity", "Books loaded from API");
                    mBooks = response.body();
                }
                else {
//                    int statusCode = response.code();
                    // handle request errors depending on status code
                    Log.d("MainActivity", "error loading books from API");
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

        mService.getOffers(reference).enqueue(new Callback<Answer>() {
            public void onResponse(Call<Answer> call, Response<Answer> response) {

                if(response.isSuccessful()) {
                    Log.d("MainActivity", "posts loaded from API");
                    mOffers = response.body().getOffers();
                }
//                else {
//                    int statusCode  = response.code();
                    // handle request errors depending on status code
//                }
            }

            public void onFailure(Call<Answer> call, Throwable t) {
                //            showErrorMessage();
                Log.d("MainActivity", "error loading offers from API");

            }
        });
    }

    public List<Book> getBooks () {
        return mBooks;
    }

    public List<Offer> getOffers (String ... isbns){
        return mOffers;
    }

/*
    public void loadBooks (){
        new ListBooksTask().execute();

    }

    class ListBooksTask extends AsyncTask<Void,Void,List<Book>> {

        @Override
        protected List<Book> doInBackground(Void... voids) {
            List<Book> books = mService.getBooks();
            return books;
        }

        @Override
        protected void onPostExecute(List<Book> books) {
            super.onPostExecute(books);
            Log.i("Book", "I'm done with this shit");
        }
    }
*/
}
