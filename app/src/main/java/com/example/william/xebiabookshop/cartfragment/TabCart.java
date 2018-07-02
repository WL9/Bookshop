package com.example.william.xebiabookshop.cartfragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.william.xebiabookshop.R;
import com.example.william.xebiabookshop.SharedViewModel;
import com.example.william.xebiabookshop.data.ApiUtils;
import com.example.william.xebiabookshop.data.models.Book;
import com.example.william.xebiabookshop.data.models.Offer;
import com.example.william.xebiabookshop.data.models.OfferList;
import com.example.william.xebiabookshop.data.remote.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TabCart extends Fragment {

    private Service mService = ApiUtils.getService();
    private OfferAdapter offerAdapter;

    private List<Book> shoppingList = new ArrayList<>();
    private List<Offer> proposedOffers = new ArrayList<>();

    private TextView totalCart;
    private TextView reduction;
    private TextView reducedPrice;


    public TabCart() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedViewModel model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        model.getSelected().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> books) {
                shoppingList = books;
                loadOffers();
                updateCartView();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        offerAdapter = new OfferAdapter(shoppingList, new OfferAdapter.RemoveFromCartClickListener() {
            @Override
            public void removeFromCartOnClick() {
                updateCartView();
            }
        });

        View cartView = inflater.inflate(R.layout.fragment_cart, container, false);
        RecyclerView recyclerView = cartView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(offerAdapter);

        totalCart = cartView.findViewById(R.id.totalcart);
        reduction = cartView.findViewById(R.id.reduction);
        reducedPrice = cartView.findViewById(R.id.reducedprice);

        loadOffers();
        updateCartView();

        return cartView;
    }


    public void loadOffers () {
        String reference = new String();
        if (shoppingList != null) {
            for (Book book : shoppingList) {
                if (reference.isEmpty())
                    reference += book.getIsbn();
                else
                    reference += "," + book.getIsbn();
            }
        }
        mService.getOffers(reference).enqueue(new Callback<OfferList>() {
            public void onResponse(Call<OfferList> call, Response<OfferList> response) {

                if(response.isSuccessful()) {
                    proposedOffers = response.body().getOffers();
                    updateCartView();
                    Log.d("CartFragment", "offers loaded from API");
                }
                else {
                    int statusCode = response.code();
                    // TO DO : handle request errors depending on status code
                    proposedOffers = new ArrayList<>();
                    Log.d("CartFragment", "error loading offers from API" + statusCode);
                }
            }

            public void onFailure(Call<OfferList> call, Throwable t) {
                Log.d("CartFragment", "error loading offers from API");

            }
        });
    }


    float getTotalPrice () {
        float totalPrice = 0;
        for (Book book : shoppingList)
            totalPrice += book.getPrice();

        return totalPrice;
    }

    float applyOffer (Offer offer, float totalPrice){
        float reducedPrice = totalPrice;
        switch(offer.getType()) {
            case "percentage":
                reducedPrice = totalPrice * (1 - (float)offer.getValue()/100);
                break;
            case "minus":
                reducedPrice = totalPrice - offer.getValue();
                break;
            case "slice":
                int numberOfSlices = (int)totalPrice / offer.getSliceValue();
                reducedPrice = totalPrice - offer.getValue() * numberOfSlices;
                break;
        }
        return reducedPrice;
    }

    float getBestOffer (){

        float totalPrice = getTotalPrice();
        float bestPrice = totalPrice;

        for (Offer offer : proposedOffers){
            float currentOffer = applyOffer(offer, totalPrice);
            if (currentOffer < bestPrice)
                bestPrice = currentOffer;
        }
        return bestPrice;
    }


    void updateCartView (){
        Log.d("CartFragment", "Number of books : " + shoppingList.size());
        Log.d("CartFragment", "Number of offers : " + proposedOffers.size());
        for (Offer offer : proposedOffers){
            Log.d("CartFragment", "Offer : " + offer.getType() + " " + offer.getValue());
        }

        float valueTotalCart = getTotalPrice();
        float valueReducedPrice = getBestOffer();
        float valueReduction = valueTotalCart - valueReducedPrice;

        totalCart.setText(String.format("%.2f",valueTotalCart) + "€");
        reduction.setText("- " + String.format("%.2f",valueReduction) + "€");
        reducedPrice.setText(String.format("%.2f",valueReducedPrice) + "€");
        offerAdapter.updateBooks(shoppingList);
    }
}