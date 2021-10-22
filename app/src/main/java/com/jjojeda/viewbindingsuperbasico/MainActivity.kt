package com.jjojeda.viewbindingsuperbasico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jjojeda.viewbindingsuperbasico.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var VistaMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        VistaMain = ActivityMainBinding.inflate(layoutInflater)
        val VistaPrincipal = VistaMain.root
        setContentView(VistaPrincipal)
        // Tambien podria ser:
        // setContentView(VistaMain.root)

        VistaMain.bCambiarTexto.setOnClickListener(){
             Thread.sleep(500)
            if (VistaMain.cbTextoAoB.isChecked){
                actualizaTexto(texto = "Texto Modificado")
            }
            else {
                if (VistaMain.etTexto.text.isNotEmpty()){
                    actualizaTexto(texto = VistaMain.etTexto.text.toString())
                }
                else {
                    actualizaTexto(texto = "Texto no Originalllll")
                }
            }
        }
    }
    private fun validaTexto(Nombre: String): Boolean{
        return Nombre.isNotEmpty()
    }
    private fun actualizaTexto(texto: String){
        VistaMain.tvTexto.text = texto
    }
}

