package com.example.william.xebiabookshop.cartfragment;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.william.xebiabookshop.R;
import com.example.william.xebiabookshop.data.models.Book;
import com.squareup.picasso.Picasso;

public class OverviewViewHolder extends RecyclerView.ViewHolder{

    private TextView titleOverview;
    private TextView priceOverview;
    private ImageView imageOverview;
    private CardView overviewCard;
    private Button removeButton;

    public OverviewViewHolder(View itemView) {
        super(itemView);

        titleOverview = itemView.findViewById(R.id.overviewtitle);
        priceOverview = itemView.findViewById(R.id.overviewprice);
        imageOverview = itemView.findViewById(R.id.overviewcover);
        overviewCard = itemView.findViewById(R.id.overviewcard);
        removeButton = itemView.findViewById(R.id.remove);
    }

    public void bind(Book book){
        titleOverview.setText(book.getTitle());
        priceOverview.setText(book.getPrice().toString() + " €/unité");
        Picasso.get().load(book.getCover()).resize(170,250).into(imageOverview);
        }

    public Button getRemoveButton(){
        return removeButton;
    }
}
