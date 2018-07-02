package com.example.william.xebiabookshop.cartfragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.william.xebiabookshop.R;
import com.example.william.xebiabookshop.data.models.Book;

import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OverviewViewHolder>{

    private List<Book> shoppingCart;
    public RemoveFromCartClickListener onClickRemoveFromCart;

    public OfferAdapter(List<Book> books, RemoveFromCartClickListener listener) {
        shoppingCart = books;
        onClickRemoveFromCart = listener;
    }

    @Override
    public OverviewViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.book_overview_model,viewGroup,false);
        return new OverviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final OverviewViewHolder overviewViewHolder, final int position) {
        final Book book = shoppingCart.get(position);
        overviewViewHolder.bind(book);

        overviewViewHolder.getRemoveButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoppingCart.remove(position);
                notifyDataSetChanged();
                onClickRemoveFromCart.removeFromCartOnClick();
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
    }

    public interface RemoveFromCartClickListener {
        void removeFromCartOnClick ();
    }
}
