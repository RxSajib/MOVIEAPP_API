package com.example.moviestreaming.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviestreaming.Model.Catagory;
import com.example.moviestreaming.R;

import java.util.List;

public class CatagoryAdapter extends RecyclerView.Adapter<CatagoryAdapter.CatagaryHolder> {

    private Context context;
    private List<Catagory> catagoryList;

    public CatagoryAdapter(Context context, List<Catagory> catagoryList) {
        this.context = context;
        this.catagoryList = catagoryList;
    }

    @NonNull
    @Override
    public CatagaryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.catagory_image_layout, null, false);

        return new CatagaryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatagaryHolder holder, int position) {

        Glide.with(holder.itemView.getContext()).load(catagoryList.get(position).getImageUri()).into(holder.catagoryimage);


    }

    @Override
    public int getItemCount() {
        return catagoryList.size();
    }

    public class CatagaryHolder extends RecyclerView.ViewHolder{

        private ImageView catagoryimage;

        public CatagaryHolder(@NonNull View itemView) {
            super(itemView);

            catagoryimage = itemView.findViewById(R.id.CatagoryImage);
        }
    }
}
