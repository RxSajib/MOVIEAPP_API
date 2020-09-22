package com.example.moviestreaming.adapter;

import android.content.Context;
import android.nfc.tech.NfcV;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.moviestreaming.Model.bannermovie;
import com.example.moviestreaming.R;

import java.util.List;

public class banner_adapter extends PagerAdapter {

    private Context context;
    private List<bannermovie> bannermovieList;

    public banner_adapter(Context context, List<bannermovie> bannermovieList) {
        this.context = context;
        this.bannermovieList = bannermovieList;
    }

    @Override
    public int getCount() {
        return bannermovieList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View Mview = LayoutInflater.from(container.getContext()).inflate(R.layout.banner_layout,container, false);

        ImageView bannerimage = Mview.findViewById(R.id.BannerImage);
        Glide.with(container.getContext()).load(bannermovieList.get(position).getImageUri()).into(bannerimage);

        container.addView(Mview);
        return Mview;
    }
}
