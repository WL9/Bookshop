package com.example.william.xebiabookshop;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.william.xebiabookshop.data.models.Book;

import java.util.List;


public class SharedViewModel extends ViewModel {
    private final MutableLiveData<List<Book>> selected = new MutableLiveData<>();

    public void select(List<Book> books){
        selected.setValue(books);
    }

    public LiveData<List<Book>> getSelected() {
        return selected;
    }
}
