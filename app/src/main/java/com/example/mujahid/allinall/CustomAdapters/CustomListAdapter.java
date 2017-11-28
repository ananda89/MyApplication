package com.example.mujahid.allinall.CustomAdapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mujahid.allinall.Pojo.ProgrammingLangData;
import com.example.mujahid.allinall.R;

import java.util.ArrayList;

/**
 * Created by Mujahid on 11/26/2017.
 */

public class CustomListAdapter extends ArrayAdapter<ProgrammingLangData> {
int res;
ArrayList<ProgrammingLangData> mainlist;
    public CustomListAdapter(@NonNull Context context, int resource, ArrayList<ProgrammingLangData> list) {
        super(context, resource,list);
        this.res = resource;
        mainlist = list;
    }

    @NonNull
    public View getView(int pos, View convertView, @NonNull ViewGroup parent){
        LinearLayout langView;
        ProgrammingLangData data = mainlist.get(pos);
        if(convertView==null){
            langView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
            assert vi != null;
            convertView = vi.inflate(res,langView);

        }

        TextView title = (TextView)convertView.findViewById(R.id.title);
        TextView description = (TextView)convertView.findViewById(R.id.hmmm);
        ImageView image = (ImageView)convertView.findViewById(R.id.image);
        description.setText(data.getLangDes());
        title.setText(data.getLangName());
        image.setImageResource(data.getLogo());


return convertView;
    }



}
