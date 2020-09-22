package com.example.moviestreaming.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviestreaming.Model.AllCatagory;
import com.example.moviestreaming.Model.Catagory;
import com.example.moviestreaming.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class MainRecylearviewAdapter extends RecyclerView.Adapter<MainRecylearviewAdapter.MainviewHolder> {

    private Context context;
    private List<AllCatagory> catagoryList;

    public MainRecylearviewAdapter(Context context, List<AllCatagory> catagoryList) {
        this.context = context;
        this.catagoryList = catagoryList;
    }

    @NonNull
    @Override
    public MainviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.catagory_layout, null, false);

        return new MainviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainviewHolder holder, int position) {

        String text = catagoryList.get(position).getCatagory();
        holder.catagorytext.setText(text);
        setiteams_recylerview(holder.recyclerView, catagoryList.get(position).getCatagoryList());
    }

    @Override
    public int getItemCount() {
        return catagoryList.size();
    }

    public static class MainviewHolder extends RecyclerView.ViewHolder{

        private MaterialTextView catagorytext;
        private RecyclerView recyclerView;

        public MainviewHolder(@NonNull View itemView) {
            super(itemView);

            catagorytext = itemView.findViewById(R.id.CatagoryName);
            recyclerView = itemView.findViewById(R.id.CatagoryReclyerView);
        }
    }

    private void setiteams_recylerview(RecyclerView recyclerView, List<Catagory> catagorieslist){

        CatagoryAdapter catagoryAdapter = new CatagoryAdapter(context, catagorieslist);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(catagoryAdapter);
    }
}
