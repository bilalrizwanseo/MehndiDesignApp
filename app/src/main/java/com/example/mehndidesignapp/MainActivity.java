package com.example.mehndidesignapp;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView feetFrag,armsFrag,handsFrag,designFrag,palmFrag;
    ViewPager viewPager;
    PageViewAdapter pageViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        feetFrag = (TextView)findViewById(R.id.feetFragmnt);
        palmFrag = (TextView)findViewById(R.id.PalmFragmnt);
        armsFrag = (TextView)findViewById(R.id.armsFragmnt);
        handsFrag = (TextView)findViewById(R.id.upperHandFragmnt);
        designFrag = (TextView) findViewById(R.id.designFragmnt);

        viewPager  = (ViewPager)findViewById(R.id.fragment_container);

        pageViewAdapter = new PageViewAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pageViewAdapter);

        feetFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(3);
            }
        });

        palmFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(1);
            }
        });

        handsFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(4);
            }
        });

        armsFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(2);
            }
        });

        designFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(0);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                onChangeTab(i);
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void onChangeTab(int i) {

        if(i == 0)
        {
            feetFrag.setTextSize(15);
            feetFrag.setTextColor(getColor(R.color.lightColor));


            handsFrag.setTextSize(15);
            handsFrag.setTextColor(getColor(R.color.lightColor));

            armsFrag.setTextSize(15);
            armsFrag.setTextColor(getColor(R.color.lightColor));

            palmFrag.setTextSize(15);
            palmFrag.setTextColor(getColor(R.color.lightColor));


            designFrag.setTextSize(20);
            designFrag.setTextColor(getColor(R.color.brightColor));

        }

        if(i == 1)
        {
            feetFrag.setTextSize(15);
            feetFrag.setTextColor(getColor(R.color.lightColor));


            handsFrag.setTextSize(15);
            handsFrag.setTextColor(getColor(R.color.lightColor));

            palmFrag.setTextSize(20);
            palmFrag.setTextColor(getColor(R.color.brightColor));

            armsFrag.setTextSize(15);
            armsFrag.setTextColor(getColor(R.color.lightColor));

            designFrag.setTextSize(15);
            designFrag.setTextColor(getColor(R.color.lightColor));

        }

        if(i == 2)
        {

            palmFrag.setTextSize(15);
            palmFrag.setTextColor(getColor(R.color.lightColor));

            feetFrag.setTextSize(15);
            feetFrag.setTextColor(getColor(R.color.lightColor));


            handsFrag.setTextSize(15);
            handsFrag.setTextColor(getColor(R.color.lightColor));

            armsFrag.setTextSize(20);
            armsFrag.setTextColor(getColor(R.color.brightColor));

            designFrag.setTextSize(15);
            designFrag.setTextColor(getColor(R.color.lightColor));

        }

        if(i == 3)
        {
            palmFrag.setTextSize(15);
            palmFrag.setTextColor(getColor(R.color.lightColor));

            feetFrag.setTextSize(20);
            feetFrag.setTextColor(getColor(R.color.brightColor));


            handsFrag.setTextSize(15);
            handsFrag.setTextColor(getColor(R.color.lightColor));

            armsFrag.setTextSize(15);
            armsFrag.setTextColor(getColor(R.color.lightColor));

            designFrag.setTextSize(15);
            designFrag.setTextColor(getColor(R.color.lightColor));

        }

        if(i == 4)
        {
            palmFrag.setTextSize(15);
            palmFrag.setTextColor(getColor(R.color.lightColor));

            feetFrag.setTextSize(15);
            feetFrag.setTextColor(getColor(R.color.lightColor));


            handsFrag.setTextSize(20);
            handsFrag.setTextColor(getColor(R.color.brightColor));

            armsFrag.setTextSize(15);
            armsFrag.setTextColor(getColor(R.color.lightColor));

            designFrag.setTextSize(15);
            designFrag.setTextColor(getColor(R.color.lightColor));

        }
    }
}
