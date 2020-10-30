package es.vrivas.ejemplosapartado7

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val LOG_TAG = "LOG EN MAINACTIVITY"
    @Suppress("UNUSED_EXPRESSION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Usp de Log.d
        Log.d( LOG_TAG, "Ejecutando método onCreate")

        // Uso de TOAST corto
        layout.setOnClickListener {view->
            Toast.makeText(this, "Soy un Toast de duración corta", Toast.LENGTH_SHORT ).show()
            true
        }

        // USO DE TOAST largo
        // Sustituimos el Toast largo por un snackbar
        /*layout.setOnLongClickListener { view->
            Toast.makeText(this, "Soy un Toast de duración LARGA!", Toast.LENGTH_LONG ).show()
            true
        }*/

        // Uso de Snackbar con action + Uso de Log.d en dicho action
        layout.setOnLongClickListener { view->
            Snackbar.make( view,"Soy un SNACKBAR de duración LARGA!", Snackbar.LENGTH_LONG )
                .setAction("Pulsa el snackbar"
                ) {
                    Log.d( LOG_TAG, "SNACKBAR PULSADO")
                }
                .show()
            true
        }

    }

    // Uso de Alert Dialog
    @Suppress("UNUSED_PARAMETER")
    fun boton_dialog_alert_click(View: View) {
        val dialogo = AlertDialog.Builder(this)
            .setTitle("Soy el título del diálogo")
            .setMessage("Soy el mensaje del diálogo")
            .setPositiveButton("Aceptar"){ dialogInterface: DialogInterface, i: Int ->
               Log.d( LOG_TAG, "Aceptar diálogo")
                //dialogInterface.dismiss() // Elimina el diálogo
            }
            .setNegativeButton("Cancelar"){ dialogInterface: DialogInterface, i: Int ->
                Log.d( LOG_TAG, "Cancelar diálogo")
                //dialogInterface.cancel() // Cancel lanza el evento OnCancel y posteriormente hace dismiss
            }
            dialogo.show()
    }


    override fun onResume() {
        super.onResume()

        // Uso de Log.e
        Log.e(LOG_TAG, "Ejecutando método onResume")
    }

}