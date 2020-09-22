package com.example.moviestreaming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.moviestreaming.Model.bannermovie;
import com.example.moviestreaming.adapter.banner_adapter;
import com.google.android.material.tabs.TabLayout;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    private ViewPager sweapbannerviewpager;
    private com.example.moviestreaming.adapter.banner_adapter banner_adapter;
    private List<bannermovie> bannermovieList = new ArrayList<>();
    private TabLayout tabindicator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabindicator = findViewById(R.id.tab_indicator);

        bannermovieList.add(new bannermovie(1, "Highest AP", "https://lh3.googleusercontent.com/proxy/cv-05Hd5yBxJT7ivB86-SppgNWtuHY7IR2wyPWsGT58uuVKUNTsnkkMJYuwhOis8e_5i2flUO7FDJ8n6OZWxWgmy1a9PpDdDevyWFlrNFw4ES_z5sJAuOpGhtQ88VgjvQoOenUFqbkKy", ""));
        bannermovieList.add(new bannermovie(2, "War", "https://www.thetelugufilmnagar.com/wp-content/uploads/2019/08/Trailer-Out.jpg", ""));
        bannermovieList.add(new bannermovie(3, "Wanted", "https://2.bp.blogspot.com/-tKHmwnEOAHo/XNk8ZASVYwI/AAAAAAAAAI8/EG45TZnypHAJx1rmmyuFqvdYZUMoObOeACEwYBhgL/s1600/indias%2Bmost%2Bwanted%2Bbudget.JPG", ""));

        sweapbannerviewpager = findViewById(R.id.BannerViewPager);
        banner_adapter = new banner_adapter(getApplicationContext(), bannermovieList);
        sweapbannerviewpager.setAdapter(banner_adapter);
        tabindicator.setupWithViewPager(sweapbannerviewpager);


        Timer scralltimer = new Timer();
        scralltimer.scheduleAtFixedRate(new AutoScrall(), 4000, 6000);
        tabindicator.setupWithViewPager(sweapbannerviewpager, true);

    }


    public class AutoScrall extends TimerTask{

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(sweapbannerviewpager.getCurrentItem() < bannermovieList.size() - 1){
                        sweapbannerviewpager.setCurrentItem(sweapbannerviewpager.getCurrentItem() + 1);
                    }
                    else {
                        sweapbannerviewpager.setCurrentItem(0);
                    }
                }
            });
        }
    }

}