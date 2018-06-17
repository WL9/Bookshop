package com.example.william.xebiabookshop;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder>{

    List<Book> listBook;

    public MyAdapter(List<Book> books) {
        this.listBook = books;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.book_model,viewGroup,false);
        return new BookViewHolder(view);
    }

    //c'est ici que nous allons remplir notre cellule avec le texte/image de chaque MyObjects
    @Override
    public void onBindViewHolder(BookViewHolder myViewHolder, int position) {
        Book book = listBook.get(position);
        myViewHolder.bind(book);
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }

}