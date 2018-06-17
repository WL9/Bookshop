package com.example.william.xebiabookshop;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BookViewHolder extends RecyclerView.ViewHolder{

    private TextView titleView;
    private TextView authorView;
    private TextView priceView;
    private TextView synopsisView;
    private ImageView coverView;

    public BookViewHolder(View itemView) {
        super(itemView);

        titleView = itemView.findViewById(R.id.title);
        authorView = itemView.findViewById(R.id.author);
        priceView = itemView.findViewById(R.id.price);
        synopsisView = itemView.findViewById(R.id.synopsis);
        coverView = itemView.findViewById(R.id.cover);
    }

    public void bind(Book book){
        titleView.setText(book.getTitle());
        authorView.setText(book.getAuthor());
        priceView.setText(book.getPrice());
        synopsisView.setText(book.getSynopsis());
        Picasso.get(coverView.getContext()).load(book.getImageUrl()).centerCrop().fit().into(coverView);
    }
}