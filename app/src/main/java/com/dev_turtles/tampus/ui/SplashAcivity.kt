package com.dev_turtles.tampus.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.dev_turtles.tampus.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        },3000)

    }
}