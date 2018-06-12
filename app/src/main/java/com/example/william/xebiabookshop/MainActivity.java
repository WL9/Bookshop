package com.example.william.xebiabookshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.william.xebiabookshop.data.ApiUtils;
import com.example.william.xebiabookshop.data.ResponseAdapter;
import com.example.william.xebiabookshop.data.models.Answer;
import com.example.william.xebiabookshop.data.models.Book;
import com.example.william.xebiabookshop.data.models.Offer;
import com.example.william.xebiabookshop.data.remote.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private ResponseAdapter mResponseAdapter = new ResponseAdapter();
    private Service mService = ApiUtils.getService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mService = ApiUtils.getService();

    //    loadAnswers();
        mResponseAdapter.loadBooks();
        testInit();


    }

    public void testInit (){
        List<Book> books = mResponseAdapter.getBooks();
//        Log.i("Book", "size : " + books.size());
//        Log.i("Book", "Title : " + books.get(0).getTitle());
/*        Log.i("Book", "Cover : " + books.get(0).getCover());
        Log.i("Book", "Price : " + books.get(0).getPrice());
        Log.i("Book", "ISBN : " + books.get(0).getIsbn());
        Log.i("Book", "Title : " + books.get(2).getTitle());
        Log.i("Book", "Cover : " + books.get(2).getCover());
        Log.i("Book", "Price : " + books.get(2).getPrice());
        Log.i("Book", "ISBN : " + books.get(2).getIsbn());
        Log.i("Book", "Title : " + books.get(6).getTitle());
        Log.i("Book", "Cover : " + books.get(6).getCover());
        Log.i("Book", "Price : " + books.get(6).getPrice());
        Log.i("Book", "ISBN : " + books.get(6).getIsbn());

        List<Offer> offers = mResponseAdapter.getOffers(books.get(0).getIsbn(), books.get(5).getIsbn());
        Log.i("offer", "size = " + offers.size());
        Log.i("offer", "Element 0 : " +
                "type : " + offers.get(0).getType() +
                " value : " + offers.get(0).getValue());
        Log.i("offer", "Element 1 : " +
                "type : " + offers.get(1).getType() +
                " value : " + offers.get(1).getValue());
        Log.i("offer", "Element 2 : " +
                "type : " + offers.get(2).getType() +
                " value : " + offers.get(2).getValue());
 */   }


/*
    public void loadAnswers() {
        mService.getBooks().enqueue(new Callback<List<Book>>() {
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if(response.isSuccessful()) {
                    Log.d("MainActivity", "posts loaded from API");
                    List<Book> books = response.body();
                    Log.i("Book", "size : " + books.size());
                    Log.i("Book", "Title : " + books.get(0).getTitle());
                    Log.i("Book", "Cover : " + books.get(0).getCover());
                    Log.i("Book", "Price : " + books.get(0).getPrice());
                    Log.i("Book", "ISBN : " + books.get(0).getIsbn());
                    Log.i("Book", "Title : " + books.get(2).getTitle());
                    Log.i("Book", "Cover : " + books.get(2).getCover());
                    Log.i("Book", "Price : " + books.get(2).getPrice());
                    Log.i("Book", "ISBN : " + books.get(2).getIsbn());
                    Log.i("Book", "Title : " + books.get(6).getTitle());
                    Log.i("Book", "Cover : " + books.get(6).getCover());
                    Log.i("Book", "Price : " + books.get(6).getPrice());
                    Log.i("Book", "ISBN : " + books.get(6).getIsbn());
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            public void onFailure(Call<List<Book>> call, Throwable t) {
                //            showErrorMessage();
                Log.d("MainActivity", "error loading from API");

            }
        });


        mService.getOffers("c8fabf68-8374-48fe-a7ea-a00ccd07afff,a460afed-e5e7-4e39-a39d-c885c05db861").enqueue(new Callback<Answer>() {
            public void onResponse(Call<Answer> call, Response<Answer> response) {

                if(response.isSuccessful()) {
                    Log.d("MainActivity", "posts loaded from API");
                    List<Offer> offers = response.body().getOffers();
                    Log.i("offer", "size = " + offers.size());
                    Log.i("offer", "Element 0 : " +
                            "type : " + offers.get(0).getType() +
                            " value : " + offers.get(0).getValue());
                    Log.i("offer", "Element 1 : " +
                            "type : " + offers.get(1).getType() +
                            " value : " + offers.get(1).getValue());
                    Log.i("offer", "Element 2 : " +
                            "type : " + offers.get(2).getType() +
                            " value : " + offers.get(2).getValue());
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            public void onFailure(Call<Answer> call, Throwable t) {
    //            showErrorMessage();
                Log.d("MainActivity", "error loading offers from API");

            }
        });
    }
*/
}
