package com.example.mujahid.allinall.CustomAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mujahid.allinall.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Mujahid on 11/27/2017.
 */

public class CustomExpandListAdapter extends BaseExpandableListAdapter {
    private List<String> header;
    private HashMap<String, List<String>> child_Items;
    private Context ctx;

    public CustomExpandListAdapter(Context c, List<String> l, HashMap<String,List<String>> m){
        this.ctx = c;
        this.header = l;
        this.child_Items = m;
    }



    @Override
    public int getGroupCount() {
        return header.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return child_Items.get(header.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int i) {
        return header.get(i);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child_Items.get(header.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition ;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup viewGroup) {
        String title =(String) this.getGroup(groupPosition);
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            convertView = inflater.inflate(R.layout.custom_expandlist_parent,null);

        }
        TextView textView = (TextView)convertView.findViewById(R.id.headingItem);
        textView.setText(title);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.image);
        if (isExpanded){
            imageView.setImageResource(R.drawable.ic_collapse);

        }else{
            imageView.setImageResource(R.drawable.ic_expandlist);
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup viewGroup) {
        String title = (String)this.getChild(groupPosition,childPosition);
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            convertView = inflater.inflate(R.layout.custom_expandlist_child,null);

        }
        TextView textView = (TextView)convertView.findViewById(R.id.childItem);
        textView.setText(title);


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
