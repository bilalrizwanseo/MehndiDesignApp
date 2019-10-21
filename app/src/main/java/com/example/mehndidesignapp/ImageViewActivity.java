package com.example.mehndidesignapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.squareup.picasso.Picasso;

public class ImageViewActivity extends AppCompatActivity {


    //to show ads
    InterstitialAd mInterstitialAd;


    private ImageView imageViewMehndi;
    private Button shareBtn;

    private String imageUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        imageUrl = getIntent().getStringExtra("mhndi_img_url");
        shareBtn = (Button) findViewById(R.id.share_Btn);


        imageViewMehndi = (ImageView)findViewById(R.id.imageMehndi);

        Picasso.get().load(imageUrl).into(imageViewMehndi);



        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_STREAM, imageUrl);
                shareIntent.setType("image/jpeg");
                startActivity(Intent.createChooser(shareIntent, "Share Image via : "));
            }
        });

        //Banner ad
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //interstitial ad
        mInterstitialAd = new InterstitialAd(this);
        //replace adUnitId with your ad id from admob website
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                finish();
            }
        });

    }

    public void showInterstitial(){
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            //Log.d("TAG", "The interstitial wasn't loaded yet.");
            finish();
        }

    }

    @Override
    public void onBackPressed() {
        showInterstitial();
    }
}