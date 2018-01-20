package com.example.jgd.jgd

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.Window

class SplashScreenActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set portrait orientation
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView(R.layout.splash_screen)

        val task = object : TimerTask() {
            fun run() {

                // Start the next activity
                val mainIntent = Intent().setClass(this@SplashScreenActivity, MainActivity::class.java!!)
                startActivity(mainIntent)

                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish()
            }
        }

        // Simulate a long loading process on application startup.
        val timer = Timer()
        timer.schedule(task, SPLASH_SCREEN_DELAY)
    }

    companion object {

        // Set the duration of the splash screen
        private val SPLASH_SCREEN_DELAY: Long = 3000
    }

}