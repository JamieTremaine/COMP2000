package com.example.geocache;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.constraintlayout.helper.widget.Layer;

import com.smarteist.autoimageslider.SliderViewAdapter;

public class ImageSlider extends SliderViewAdapter<ImageSlider.Holder> {

    private int[] images;

    public ImageSlider(int[] images){
        this.images = images;
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.homepage_slider, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, int position) {

        viewHolder.imageView.setImageResource(images[position]);
    }


    @Override
    public int getCount() {
        return this.images.length;
    }

    public class Holder extends SliderViewAdapter.ViewHolder{

        ImageView imageView;

        public Holder(View itemView){
            super(itemView);

            imageView = itemView.findViewById(R.id.homepage_slider_view);
        }
    }
}
