package com.example.william.xebiabookshop.cartfragment;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.william.xebiabookshop.R;
import com.example.william.xebiabookshop.data.models.Book;
import com.squareup.picasso.Picasso;


public class OverviewViewHolder extends RecyclerView.ViewHolder {

    private Context context;
    private TextView titleOverview;
    private TextView priceOverview;
    private ImageView imageOverview;
    private CardView overviewCard;
    private Button removeButton;
    private Spinner quantitySpinner;

    public OverviewViewHolder(Context context, View itemView) {
        super(itemView);
        this.context = context;

        titleOverview = itemView.findViewById(R.id.overviewtitle);
        priceOverview = itemView.findViewById(R.id.overviewprice);
        imageOverview = itemView.findViewById(R.id.overviewcover);
        overviewCard = itemView.findViewById(R.id.overviewcard);
        removeButton = itemView.findViewById(R.id.remove);
        quantitySpinner = itemView.findViewById(R.id.quantity);

        Integer [] quantities = new Integer[99];
        for (int i = 0; i<99;i++){
            quantities[i]=i+1;
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(context,android.R.layout.simple_spinner_item, quantities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantitySpinner.setAdapter(adapter);
    }

    public void bind(Book book, int quantity){
        titleOverview.setText(book.getTitle());
        String txtPrice = book.getPrice().toString() + context.getString(R.string.per_unit);
        priceOverview.setText(txtPrice);
        Picasso.get().load(book.getCover()).resize(170,250).into(imageOverview);
        quantitySpinner.setSelection(quantity-1);
        }

    public Button getRemoveButton(){
        return removeButton;
    }

    public Spinner getQuantitySpinner(){
        return quantitySpinner;
    }
}
