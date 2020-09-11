package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.image_slider_item.*

class MainActivity : Activity() {
    // declaring a null variable for VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageSliderImplementation()

        // display a toast message if any
        // error occurs while playing the video
        val mediaController = MediaController(this)
        mediaController.setAnchorView(simpleVideoView)
        val onlineUri: Uri = Uri.parse("https://www.youtube.com/watch?v=y9FU53v1M4Q")
        val offlineUri: Uri = Uri.parse("android.resource://$packageName/${R.raw.videoclip1}")
        simpleVideoView.setMediaController(mediaController)
        simpleVideoView.setVideoURI(offlineUri)
        simpleVideoView.requestFocus()
        simpleVideoView.start()
        tv_auto_Top.setOnClickListener {
            val intent = Intent(this, ExerciseActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

    }





    private fun imageSliderImplementation() {

        val adapter = ImageSliderAdapter(this)
        viewpager.adapter = adapter


    }



}









