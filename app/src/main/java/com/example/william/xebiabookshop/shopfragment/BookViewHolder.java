package com.example.william.xebiabookshop.shopfragment;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.william.xebiabookshop.R;
import com.example.william.xebiabookshop.data.models.Book;
import com.squareup.picasso.Picasso;

public class BookViewHolder extends RecyclerView.ViewHolder{

    private TextView titleView;
    private TextView authorView;
    private TextView priceView;
    private TextView synopsisView;
    private ImageView coverView;
    private CardView bookCardView;
    private Button purchaseButton;

    public BookViewHolder(View itemView) {
        super(itemView);

        titleView = itemView.findViewById(R.id.title);
        authorView = itemView.findViewById(R.id.author);
        priceView = itemView.findViewById(R.id.price);
        synopsisView = itemView.findViewById(R.id.synopsis);
        coverView = itemView.findViewById(R.id.cover);
        bookCardView = itemView.findViewById(R.id.bookCard);
        purchaseButton = itemView.findViewById(R.id.addtocart);

        bookCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (synopsisView.getVisibility() == View.GONE){
                    synopsisView.setVisibility(View.VISIBLE);
                    purchaseButton.setVisibility(View.VISIBLE);
                }
                else {
                    synopsisView.setVisibility(View.GONE);
                    purchaseButton.setVisibility(View.GONE);
                }
            }
        });
    }

    public void bind(Book book){
        titleView.setText(book.getTitle());
        authorView.setText(book.getAuthor());
        priceView.setText(book.getPrice().toString() + " €");
        synopsisView.setText(book.getSynopsis());
        Picasso.get().load(book.getCover()).resize(340,500).into(coverView);
    }

    public Button getPurchaseButton(){
        return purchaseButton;
    }

    public void closeCard () {
        synopsisView.setVisibility(View.GONE);
        purchaseButton.setVisibility(View.GONE);
    }

}