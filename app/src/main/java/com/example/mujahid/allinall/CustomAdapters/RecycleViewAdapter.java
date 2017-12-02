package com.example.mujahid.allinall.CustomAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mujahid.allinall.Pojo.ProgrammingLangData;
import com.example.mujahid.allinall.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mujahid on 12/1/2017.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.RecycleViewHolder> {

    private LayoutInflater intflater;
    private List<ProgrammingLangData> data = new ArrayList<>();
    public RecycleViewAdapter(Context context, List<ProgrammingLangData> d){
        data = d;
        intflater = LayoutInflater.from(context);
    }


    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view =  intflater.inflate(R.layout.custom_listview1,parent,false);
       RecycleViewHolder holder = new RecycleViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder( RecycleViewHolder holder, int position) {
        ProgrammingLangData object = data.get(position);
        holder.title.setText(object.getLangName());
        holder.description.setText(object.getLangDes());
        holder.imageView.setImageResource(object.getLogo());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class RecycleViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        ImageView imageView;
        public RecycleViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.hmmm);
            imageView = itemView.findViewById(R.id.image);

        }
    }
}
