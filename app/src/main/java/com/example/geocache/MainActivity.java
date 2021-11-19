package com.example.geocache;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;


public class MainActivity extends AppCompatActivity {

    SliderView sView;
    int[] images = { R.drawable.homepage_slider_one,
            R.drawable.homepage_slider_two,
            R.drawable.homepage_slider_three,
            R.drawable.homepage_slider_four,
            R.drawable.homepage_slider_five
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sView = findViewById(R.id.homepage_slider_view);

        ImageSlider homepageImageSlider = new ImageSlider(images);
        sView.setSliderAdapter(homepageImageSlider);
        sView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sView.setScrollTimeInSec(4);
        sView.startAutoCycle();
    }
}