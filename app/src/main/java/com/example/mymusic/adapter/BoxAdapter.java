package com.example.mymusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mymusic.R;

import java.io.File;
import java.util.ArrayList;

public class BoxAdapter extends BaseAdapter {
    private LayoutInflater lInflater;
    private ArrayList<Product> objects;

    public BoxAdapter(Context context, ArrayList<Product> products) {
        objects = products;
        lInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }
        Product p = getProduct(position);
        File inputPath=new File(p.path);
        ((TextView) view.findViewById(R.id.nameFold)).setText(inputPath.getName());
        ((ImageView) view.findViewById(R.id.foldMus)).setImageResource(p.image);
        return view;
    }
    Product getProduct(int position) {
        return ((Product) getItem(position));
    }
}
