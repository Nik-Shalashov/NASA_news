package ru.android1.nasanews

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import ru.android1.nasanews.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        image_view.animate().scaleY(-1f)
            .setInterpolator(AccelerateDecelerateInterpolator()).setDuration(2000)
            .setListener(object : Animator.AnimatorListener{
                override fun onAnimationStart(animation: Animator?) {
                    TODO("Not yet implemented")
                }
                override fun onAnimationEnd(animation: Animator?) {
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish()
                }
                override fun onAnimationCancel(animation: Animator?) {
                    TODO("Not yet implemented")
                }
                override fun onAnimationRepeat(animation: Animator?) {
                    TODO("Not yet implemented")
                }
            })

        handler.postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }, 3000)
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}