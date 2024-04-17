package com.example.tdmpa_2p_pr02

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class DetalleProductoActivity : AppCompatActivity() {
    var precio = 0.0
    var cantidad = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_producto)

        val txtNombreProducto = findViewById<TextView>(R.id.txtNombreProducto)
        val nombreProducto = intent.extras?.getString("nombreProducto").toString()
        txtNombreProducto.text = "Nombre: ${nombreProducto}"

        val txtPrecioProducto = findViewById<TextView>(R.id.txtPrecioProducto)
        val precioProducto = intent.extras?.getString("precioProducto").toString()
        precio = precioProducto.toDouble()
        txtPrecioProducto.text = "Precio: ${precioProducto}"

        val txtDescripcionProducto = findViewById<TextView>(R.id.txtDescripcionProducto)
        val descripcionProducto = intent.extras?.getString("descripcionProducto").toString()
        txtDescripcionProducto.text = "Descripcion: ${descripcionProducto}"

        val imgDetalleProducto = findViewById<ImageView>(R.id.imgDetalleProducto)
        val imagenProducto = intent.extras?.getString("imagenProducto").toString()
        imgDetalleProducto.setImageResource(imagenProducto.toInt())

        calcularTotal()

        val btnMenos = findViewById<Button>(R.id.btnMenos)
        val btnMas = findViewById<Button>(R.id.btnMas)
        btnMenos.setBackgroundColor(Color.parseColor("#B79D9B"))
        btnMas.setBackgroundColor(Color.parseColor("#B79D9B"))

        btnMenos.setOnClickListener {
            menos()
        }

        btnMas.setOnClickListener {
            mas()
        }
    }

    fun calcularTotal() {
        val txtPrecioTotal = findViewById<TextView>(R.id.txtPrecioTotal)

        var total = cantidad * precio;
        txtPrecioTotal.text = "Precio Total: ${total}";
    }

    fun menos(){
        val txtCantidad = findViewById<TextView>(R.id.txtCantidad)

        if (cantidad > 1) {
            cantidad--
        }
        txtCantidad.text = cantidad.toString()
        calcularTotal()
    }

    fun mas(){
        val txtCantidad = findViewById<TextView>(R.id.txtCantidad)

        cantidad++
        txtCantidad.text = cantidad.toString()
        calcularTotal()
    }
}