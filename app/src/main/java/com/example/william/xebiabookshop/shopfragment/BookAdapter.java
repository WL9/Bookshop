package com.example.william.xebiabookshop.shopfragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.william.xebiabookshop.R;
import com.example.william.xebiabookshop.data.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder>{

    private List<Book> listBook;
    private List<Book> shoppingCart = new ArrayList<>();
    public AddCartClickListener onClickAddCart;

    public BookAdapter(List<Book> books, AddCartClickListener listener) {
        listBook = books;
        onClickAddCart = listener;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.book_model,viewGroup,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final BookViewHolder bookViewHolder, int position) {
        final Book book = listBook.get(position);
        bookViewHolder.bind(book);

        bookViewHolder.getPurchaseButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isAlreadyInCart(book)) {
                    shoppingCart.add(book);
                }
                onClickAddCart.addCartOnClick(view, shoppingCart);
                bookViewHolder.closeCard();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }

    public void updateBooks(List<Book> items) {
        listBook = items;
        notifyDataSetChanged();
    }

    private boolean isAlreadyInCart (Book book) {
        for (Book selection : shoppingCart){
            if (book.getIsbn() == selection.getIsbn())
                return true;
        }
        return false;
    }

    public interface AddCartClickListener {
        void addCartOnClick (View v, List<Book> shoppingCart);
    }
}