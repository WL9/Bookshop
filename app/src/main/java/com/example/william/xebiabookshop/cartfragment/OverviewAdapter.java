package com.example.william.xebiabookshop.cartfragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.william.xebiabookshop.R;
import com.example.william.xebiabookshop.data.models.Book;

import java.util.List;


public class OverviewAdapter extends RecyclerView.Adapter<OverviewViewHolder>{

    private List<Book> shoppingCart;
    private int [] shoppingQuantity;

    private Context context;
    public AdapterEventListener adapterEventListener;

    public OverviewAdapter(Context context, List<Book> books, AdapterEventListener listener) {
        this.context = context;
        shoppingCart = books;
        shoppingQuantity = new int[shoppingCart.size()];
        for (int i=0; i<shoppingQuantity.length; i++){
            shoppingQuantity[i]=1;
        }
        adapterEventListener = listener;
    }

    @Override
    public OverviewViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.book_overview_model,viewGroup,false);
        return new OverviewViewHolder(context, view);
    }

    @Override
    public void onBindViewHolder(final OverviewViewHolder overviewViewHolder, final int bookPosition) {
        final Book book = shoppingCart.get(bookPosition);
        overviewViewHolder.bind(book, shoppingQuantity[bookPosition]);

        overviewViewHolder.getRemoveButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoppingCart.remove(bookPosition);
                notifyDataSetChanged();

                int [] newQuantity = new int [shoppingQuantity.length-1];
                int j =0;
                for (int i = 0; i<shoppingQuantity.length;i++){
                    if (i != bookPosition) {
                        newQuantity[j] = shoppingQuantity[i];
                        j++;
                    }
                }
                shoppingQuantity = newQuantity;

                adapterEventListener.removeFromCartOnClick();
            }
        });

        overviewViewHolder.getQuantitySpinner().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int quantityPosition, long id) {
                shoppingQuantity[bookPosition] = Integer.parseInt(parent.getItemAtPosition(quantityPosition).toString());
                adapterEventListener.modifiedQuantity();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                shoppingQuantity[bookPosition] = 1;
                adapterEventListener.modifiedQuantity();
            }
        });
    }

    @Override
    public int getItemCount() {
        return shoppingCart.size();
    }

    public void updateBooks(List<Book> items) {
        shoppingCart = items;
        notifyDataSetChanged();

        if (shoppingCart.size()>shoppingQuantity.length) {
            int[] newQuantity = new int[shoppingCart.size()];
            for (int i=0; i<newQuantity.length;i++){
                if (i<shoppingQuantity.length)
                    newQuantity[i]=shoppingQuantity[i];
                else
                    newQuantity[i] = 1;
            }
            shoppingQuantity = newQuantity;
        }
    }

    public int[] getShoppingQuantity(){
        return shoppingQuantity;
    }

    public interface AdapterEventListener {
        void removeFromCartOnClick ();
        void modifiedQuantity();
    }
}
