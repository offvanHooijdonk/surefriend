package by.off.surefriend.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import by.off.surefriend.R
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_splash)
    }

    override fun onStart() {
        super.onStart()

        startActivity<MainActivity>()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}