package com.example.geocache;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;


public class Homepage extends AppCompatActivity {

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
        setContentView(R.layout.activity_homepage);

        sView = findViewById(R.id.homepage_slider_view);

        ImageSlider homepageImageSlider = new ImageSlider(images);
        sView.setSliderAdapter(homepageImageSlider);
        sView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sView.setScrollTimeInSec(4);
        sView.startAutoCycle();
    }

    public void onCreateAccountClick(View view){
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }

    public void onLoginClick(View view){
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
        finish();
    }


}