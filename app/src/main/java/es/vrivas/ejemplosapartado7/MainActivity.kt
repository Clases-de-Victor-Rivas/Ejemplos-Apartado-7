package es.vrivas.ejemplosapartado7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val LOG_TAG = "LOG EN MAINACTIVITY"
    @Suppress("UNUSED_EXPRESSION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d( LOG_TAG, "Ejecutando método onCreate")
        layout.setOnClickListener {view->
            Toast.makeText(this, "Soy un Toast de duración corta", Toast.LENGTH_SHORT ).show()
            true
        }
        /*layout.setOnLongClickListener { view->
            Toast.makeText(this, "Soy un Toast de duración LARGA!", Toast.LENGTH_LONG ).show()
            true
        }*/

        // Sustituimos el Toast largo por un snackbar
        layout.setOnLongClickListener { view->
            Snackbar.make(
                view,
                "Soy un SNACKBAR de duración LARGA!",
                Snackbar.LENGTH_LONG
            )
                .setAction("Pulsa el snackbar"
                ) {
                    Log.d( LOG_TAG, "SNACKBAR PULSADO")
                }
                .show()
            true
        }

    }


    override fun onResume() {
        super.onResume()
        Log.e(LOG_TAG, "Ejecutando método onResume")
    }

}