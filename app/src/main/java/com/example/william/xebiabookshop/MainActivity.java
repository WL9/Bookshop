package com.example.william.xebiabookshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.william.xebiabookshop.data.ApiUtils;
import com.example.william.xebiabookshop.data.ResponseAdapter;
import com.example.william.xebiabookshop.data.remote.Service;


public class MainActivity extends AppCompatActivity {

    private ResponseAdapter mResponseAdapter = new ResponseAdapter();
    private Service mService = ApiUtils.getService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mService = ApiUtils.getService();

        mResponseAdapter.loadBooks();
    }
}