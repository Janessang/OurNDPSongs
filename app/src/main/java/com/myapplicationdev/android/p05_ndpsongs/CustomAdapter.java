package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Song> songList;

    public CustomAdapter (Context context, int resource, ArrayList<Song> objects) {
        super (context, resource, objects);

        parent_context = context;
        layout_id = resource;
        songList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        //TextView tvStars = rowView.findViewById(R.id.textViewStars);
        TextView tvSinger = rowView.findViewById(R.id.textViewSinger);
        ImageView ivNew = rowView.findViewById(R.id.imageView);
        RatingBar rb = rowView.findViewById(R.id.ratingBar2);

        Song current = songList.get(position);

        tvTitle.setText(current.getTitle());
        tvYear.setText(Integer.toString(current.getYearReleased()));

        rb.setRating(current.getStars());
        tvSinger.setText(current.getSingers());

        if(current.getYearReleased() >= 2019) {
            ivNew.setVisibility(View.VISIBLE);

        } else {
            ivNew.setVisibility(View.INVISIBLE);
        }

        return rowView;
    }
}
