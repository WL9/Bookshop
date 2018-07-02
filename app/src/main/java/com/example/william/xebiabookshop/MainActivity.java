package com.example.william.xebiabookshop;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.william.xebiabookshop.cartfragment.TabCart;
import com.example.william.xebiabookshop.shopfragment.TabShop;


public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.pager);
        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());


        adapter.addFragment(new TabShop(), "Boutique");
        adapter.addFragment(new TabCart(), "Panier");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}