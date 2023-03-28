package com.example.guardar_datos

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var campoUsuario:EditText?=null
    var campoPass: EditText?=null
    var txtUsuario: TextView?=null
    var txtPass:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("onCreate","appCreada")
        escuhar()


    }
    private fun escuhar(){
        val btnGuardar=findViewById<Button>(R.id.guardar)
        val btnCargar=findViewById<Button>(R.id.cargar)

        btnGuardar.setOnClickListener{guardar()}
        btnCargar.setOnClickListener{cargar()}
         campoUsuario=findViewById(R.id.user)
         campoPass =findViewById(R.id.pass)
         txtUsuario =findViewById(R.id.showUser)
        txtPass=findViewById(R.id.showPass)

    }
    private fun guardar(){
        var preferences: SharedPreferences =getSharedPreferences("credenciales", Context.MODE_PRIVATE)
        var usuario= campoUsuario?.text.toString()
        var pass= campoPass?.text.toString()
        var editor:SharedPreferences.Editor=preferences.edit()
        editor.putString("user",usuario)
        editor.putString("pass",pass)

        editor.commit()

        Toast.makeText(this,"Se han registrado los datos",Toast.LENGTH_SHORT).show()

    }
    private fun cargar(){
        //Abrimos el archivo de preferencias
        var preferences:SharedPreferences=getSharedPreferences("credenciales",Context.MODE_PRIVATE)

        //Se cargan los valores del archivo de preferencias
        var user: String? =preferences.getString("user","No existe la información")
        var pass: String? =preferences.getString("pass","No existe la información")

        txtUsuario?.text=user
        txtPass?.text=pass

    }

    override fun onStart(){
        super.onStart()
        Log.i("onStart","aplicacion iniciada")
    }
    override fun onResume(){
        super.onResume()
        Log.i("onResume","aplicacion a la espera de ordenes")
    }
    override fun onPause(){
        super.onPause()
        Log.i("onPause","aplicacion pausada")
    }
    override fun onStop(){
        super.onStop()
        Log.i("onStop","aplicacion detendida")
    }
    override fun onRestart(){
        super.onRestart()
        Log.i("onRestart","aplicacion reiniciada")
    } override fun onDestroy(){
        super.onDestroy()
        Log.i("onDestroy","aplicacion destruida")
    }


}