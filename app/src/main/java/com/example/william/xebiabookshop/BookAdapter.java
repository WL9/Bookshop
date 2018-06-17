package com.example.william.xebiabookshop;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.william.xebiabookshop.data.models.Book;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder>{

    private List<Book> listBook;
    private List<Book> shoppingCart;

    public BookAdapter(List<Book> books) {
        this.listBook = books;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.book_model,viewGroup,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookViewHolder bookViewHolder, int position) {
        final Book book = listBook.get(position);
        bookViewHolder.bind(book);

        bookViewHolder.getPurchaseButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoppingCart.add(book);
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

    public List<Book> getShoppingCart (){
        return shoppingCart;
    }
}