package com.example.moviestreaming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.moviestreaming.Model.AllCatagory;
import com.example.moviestreaming.Model.Catagory;
import com.example.moviestreaming.Model.bannermovie;
import com.example.moviestreaming.adapter.MainRecylearviewAdapter;
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
    private List<bannermovie> Homebanner = new ArrayList<>();
    private TabLayout tabindicator, maintablayout;

    private List<bannermovie> Showsbanner = new ArrayList<>();
    private List<bannermovie> MovieBanner = new ArrayList<>();
    private List<bannermovie> KidsBanner = new ArrayList<>();

    private RecyclerView catagorylist;
    private List<AllCatagory> catagoryList = new ArrayList<>();
    private MainRecylearviewAdapter mainRecylearviewAdapter;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabindicator = findViewById(R.id.tab_indicator);
        maintablayout = findViewById(R.id.TabLayout);

        Homebanner.add(new bannermovie(1, "Highest AP", "https://lh3.googleusercontent.com/proxy/cv-05Hd5yBxJT7ivB86-SppgNWtuHY7IR2wyPWsGT58uuVKUNTsnkkMJYuwhOis8e_5i2flUO7FDJ8n6OZWxWgmy1a9PpDdDevyWFlrNFw4ES_z5sJAuOpGhtQ88VgjvQoOenUFqbkKy", ""));
        Homebanner.add(new bannermovie(2, "War", "https://www.thetelugufilmnagar.com/wp-content/uploads/2019/08/Trailer-Out.jpg", ""));
        Homebanner.add(new bannermovie(3, "Wanted", "https://2.bp.blogspot.com/-tKHmwnEOAHo/XNk8ZASVYwI/AAAAAAAAAI8/EG45TZnypHAJx1rmmyuFqvdYZUMoObOeACEwYBhgL/s1600/indias%2Bmost%2Bwanted%2Bbudget.JPG", ""));


        Showsbanner.add(new bannermovie(1, "ISHOTERA", "https://i.ytimg.com/vi/AZyeSVsLNu8/maxresdefault.jpg", ""));
        Showsbanner.add(new bannermovie(2, "SHARDER UDHAM", "https://miro.medium.com/max/2560/1*0EuvsFwdIhf2SHwFqslL0g.jpeg", ""));
        Showsbanner.add(new bannermovie(3, "KGF", "https://dgzmedia.com/wp-content/uploads/2018/11/KGF-Trailer-Hindi-Tamil-Malayalam.jpg", ""));


        KidsBanner.add(new bannermovie(1, "THE CAROODS", "https://www.hdwallpapers.in/download/the_croods_2013-wide.jpg", ""));
        KidsBanner.add(new bannermovie(2, "RIO 2", "https://i.pinimg.com/originals/36/cd/96/36cd96886eb559b2127fe587f95a2ec4.jpg", ""));
        KidsBanner.add(new bannermovie(3, "INCREDIBLES 2", "https://lumiere-a.akamaihd.net/v1/images/640x320_531289ec.png", ""));

        MovieBanner.add(new bannermovie(1, "OBIVION", "https://d2kektcjb0ajja.cloudfront.net/images/posts/feature_images/000/000/072/large-1466557422-feature.jpg?1466557422", ""));
        MovieBanner.add(new bannermovie(2, "AVENGERS", "https://c4.wallpaperflare.com/wallpaper/869/847/751/movies-hollywood-movies-wallpaper-preview.jpg", ""));
        MovieBanner.add(new bannermovie(3, "NEW MOON", "data:image/jpeg;base64,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", ""));


        sweapbannerviewpager = findViewById(R.id.BannerViewPager);
        banner_adapter = new banner_adapter(getApplicationContext(), Homebanner);
        sweapbannerviewpager.setAdapter(banner_adapter);
        tabindicator.setupWithViewPager(sweapbannerviewpager);


        Timer scralltimer = new Timer();
        scralltimer.scheduleAtFixedRate(new AutoScrall(), 4000, 6000);
        tabindicator.setupWithViewPager(sweapbannerviewpager, true);


        maintablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {

                    case 0:

                        banner_adapter = new banner_adapter(getApplicationContext(), Showsbanner);
                        sweapbannerviewpager.setAdapter(banner_adapter);

                        return;
                    case 1:

                        banner_adapter = new banner_adapter(getApplicationContext(), MovieBanner);
                        sweapbannerviewpager.setAdapter(banner_adapter);
                        return;

                    case 2:

                        banner_adapter = new banner_adapter(getApplicationContext(), KidsBanner);
                        sweapbannerviewpager.setAdapter(banner_adapter);
                        return;

                   /* default:
                        banner_adapter = new banner_adapter(getApplicationContext(), Homebanner);
                        sweapbannerviewpager.setAdapter(banner_adapter);*/

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        catagorylist = findViewById(R.id.MainRecylearViewID);
        catagorylist.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        catagorylist.setHasFixedSize(true);


        List<Catagory> homecatagory_iteamsone = new ArrayList<>();
        homecatagory_iteamsone.add(new Catagory(1, "Kides Hodj", "https://i.ytimg.com/vi/BH6un25oKFQ/maxresdefault.jpg", ""));
        homecatagory_iteamsone.add(new Catagory(2, "Naja", "https://i.ytimg.com/vi/gdwM7xKOph0/maxresdefault.jpg", ""));
        homecatagory_iteamsone.add(new Catagory(2, "Air Strike", "https://i.pinimg.com/originals/d1/e9/cb/d1e9cb634d53a8992423e04fc2d1e610.jpg", ""));

        List<Catagory> homecatagory_iteamstwo = new ArrayList<>();
        homecatagory_iteamstwo.add(new Catagory(1, "DIC 2018", "https://www.filmibeat.com/ph-big/2018/10/seven_154019100400.jpg", ""));
        homecatagory_iteamstwo.add(new Catagory(2, "2.0", "https://static.toiimg.com/photo/64629496.cms", ""));
        homecatagory_iteamstwo.add(new Catagory(2, "Miju", "https://www.bestwebsiteinindia.com/blog/wp-content/uploads/2020/03/Dangal-1024x576.jpg", ""));


        List<Catagory> homecatagory_iteamthree = new ArrayList<>();
        homecatagory_iteamthree.add(new Catagory(1, "SMALL FOOT", "https://parklandtalk.com/wp-content/uploads/2019/01/smallfoot-final.jpg", ""));
        homecatagory_iteamthree.add(new Catagory(2, "Spring", "https://www.blender.org/wp-content/uploads/2019/04/spring_staff_16_9_logo.jpg?x18097", ""));
        homecatagory_iteamthree.add(new Catagory(2, "FloyMobi", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcT_5Zwt8BrkCr0oSuEZl31whh23gW2uz7T4Og&usqp=CAU", ""));


        catagoryList.add(new AllCatagory(1, "Watch next TV and movie", homecatagory_iteamsone));
        catagoryList.add(new AllCatagory(2, "Movie in Hinde", homecatagory_iteamstwo));
        catagoryList.add(new AllCatagory(3, "Kids and family movie", homecatagory_iteamthree));
        mainRecylearviewAdapter = new MainRecylearviewAdapter(getApplicationContext(), catagoryList);
        catagorylist.setAdapter(mainRecylearviewAdapter);

    }


    public class AutoScrall extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sweapbannerviewpager.getCurrentItem() < Homebanner.size() - 1) {
                        sweapbannerviewpager.setCurrentItem(sweapbannerviewpager.getCurrentItem() + 1);
                    } else {
                        sweapbannerviewpager.setCurrentItem(0);
                    }
                }
            });
        }
    }

}