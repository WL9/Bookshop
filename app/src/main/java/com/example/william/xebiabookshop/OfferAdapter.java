package com.example.william.xebiabookshop;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.william.xebiabookshop.data.models.Book;
import com.example.william.xebiabookshop.data.models.Offer;

import java.util.ArrayList;
import java.util.List;

public class OfferAdapter {     //extends RecyclerView.Adapter<BookViewHolder>{

    private List<Offer> listOffers;

    public OfferAdapter(List<Offer> offers) { this.listOffers = offers;}

/*  TO DO : ADAPTER EN FONCTION DE LA GESTION DES OFFRES
    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.book_model,viewGroup,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookViewHolder bookViewHolder, int position) {
        Offer offer = listOffers.get(position);
        bookViewHolder.bind(offer);
    }

    @Override
    public int getItemCount() {
        return listOffers.size();
    }
*/
    public void updateOffers(List<Offer> items) {
        listOffers = items;
//        notifyDataSetChanged();
    }
}
