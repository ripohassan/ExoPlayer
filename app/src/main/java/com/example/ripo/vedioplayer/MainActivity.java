package com.example.ripo.vedioplayer;

import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.exoplayer2.ui.SimpleExoPlayerView;

public class MainActivity extends AppCompatActivity {
    private ExoPlayerUtilities exoplayerUtilities;
    private SimpleExoPlayerView exoPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTVPlayer("https://mnmedias.api.telequebec.tv/m3u8/29880.m3u8");

    }

    //region Methods for initializing TV player
    private void initTVPlayer(String url) {
        if (url != null) {
            if (url.contains("http")) {
                exoPlayerView = (SimpleExoPlayerView) findViewById(R.id.exo_player_view);
                exoplayerUtilities = new ExoPlayerUtilities(exoPlayerView);
                exoplayerUtilities.initExoplayerLive(url, getApplicationContext());
            } else {
                Toast.makeText(this, "Invalid TV source!", Toast.LENGTH_LONG).show();
            }
        }

    }

    }

