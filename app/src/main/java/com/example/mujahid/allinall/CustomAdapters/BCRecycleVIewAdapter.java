package com.example.mujahid.allinall.CustomAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mujahid.allinall.Pojo.IncommingCalls;
import com.example.mujahid.allinall.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Mujahid on 1/5/2018.
 */

public class BCRecycleVIewAdapter extends RecyclerView.Adapter<BCRecycleVIewAdapter.MyHolder> {
    private ArrayList<IncommingCalls> list = new ArrayList<>();

   public BCRecycleVIewAdapter(ArrayList<IncommingCalls> calls){
        list = calls;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.broad_cast_recycle_layout,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.t1.setText(String.format("%s",list.get(position).getID()));
       holder.t2.setText(list.get(position).getNumber());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView t1, t2;

        MyHolder(View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.identy);
            t2 = itemView.findViewById(R.id.number);
        }
    }
}
