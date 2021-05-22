package es.jsalmoralp.apuntesandroidstudio

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView
import es.jsalmoralp.apuntesandroidstudio.databinding.ActivityMmaImagenesAnimadasBinding

class MMaImagenesAnimadasActivity : AppCompatActivity() {
    // [START] INSTANCIAS
    private lateinit var myLayout: ActivityMmaImagenesAnimadasBinding
    // [END] INSTANCIAS

    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * INICIALIZACIÓN
         */
        // TODO: Traducir titulo Activity
        title = "Animaciones con Lottie"

        super.onCreate(savedInstanceState)
        myLayout = ActivityMmaImagenesAnimadasBinding.inflate(layoutInflater)
        val view = myLayout.root
        setContentView(view)
        // [END] INICIALIZACIÓN

        /**
         * SetUp
         */
        var like1 = false
        myLayout.lavLike1.setOnClickListener {
            like1 = animacionLike(myLayout.lavLike1, R.raw.bandai_dokkan, like1)
        }
        var like2 = false
        myLayout.lavLike2.setOnClickListener {
            like2 = animacionLike(myLayout.lavLike2, R.raw.always_proud, like2)
        }
        var like3 = false
        myLayout.lavLike3.setOnClickListener {
            like3 = animacionLike(myLayout.lavLike3, R.raw.apple_event, like3)
        }
        var like4 = false
        myLayout.lavLike4.setOnClickListener {
            like4 = animacionLike(myLayout.lavLike4, R.raw.black_joy, like4)
        }
        var like5 = false
        myLayout.lavLike5.setOnClickListener {
            like5 = animacionLike(myLayout.lavLike5, R.raw.hmm, like5)
        }
        // [END] SetUp
    }

    /**
     * SETUP
     */
    private fun animacionLike(
        lottieAnimationView: LottieAnimationView,
        animacion: Int,
        like: Boolean
    ) : Boolean {
        if (!like) {
            lottieAnimationView.setAnimation(animacion)
            //lottieAnimationView.repeatCount = 5
            lottieAnimationView.playAnimation()
        } else {
            lottieAnimationView.animate()
                .alpha(0f)
                .setDuration(200)
                .setListener(object: AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator?) {
                        lottieAnimationView.setImageResource(R.mipmap.twitter_like)
                        lottieAnimationView.alpha = 1f
                    }
                })
        }
        return !like
    }
    // [END] SETUP

    /**
     * Boton "Back"
     */
    // Implementar la función de volver atrás, para que lo haga en nuestras búsquedas
    override fun onBackPressed() {
        val misActivitiesIntent = Intent(
            this,
            MMa2a00MisActivitiesActivity::class.java
        )
        startActivity(misActivitiesIntent)
    }
    // [END] Boton "Back"
}