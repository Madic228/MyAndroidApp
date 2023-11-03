package com.example.girich_project;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;


import androidx.appcompat.app.AppCompatActivity;

public class t5_lab_2_MainActivity extends AppCompatActivity {


    VideoView videoPlayer;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t5_lab_2_activity_main);
        videoPlayer = findViewById(R.id.videoPlayer);

//        videoPlayer.setVideoPath
//                ("blob:http://www.ochevidets.ru/wcmfiles/1697782240.mp4");
//    }
        Uri myVideoUri= Uri.parse( "android.resource://" +
                getPackageName() + "/" + R.raw.cs2);
        videoPlayer.setVideoURI(myVideoUri);
        MediaController mediaController = new MediaController(this);
        videoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoPlayer);
    }
    public void play(View view){
        videoPlayer.start();
    }
    public void pause(View view){
        videoPlayer.pause();
    }
    public void stop(View view){
        videoPlayer.stopPlayback();
        videoPlayer.resume();
    }
}
