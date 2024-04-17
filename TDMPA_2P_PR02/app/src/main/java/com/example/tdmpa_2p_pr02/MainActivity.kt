package com.example.tdmpa_2p_pr02

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    var nombre = ""
    var precio = 0.0
    var descripcion = ""
    var imagen = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spnCategoria = findViewById<Spinner>(R.id.spnCategoria)
        val categorias = resources.getStringArray(R.array.Categorias)
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, categorias)
        spnCategoria.adapter = adaptador

        val spnProducto = findViewById<Spinner>(R.id.spnProducto)
        val comida = resources.getStringArray(R.array.Comida)
        val tecnologia = resources.getStringArray(R.array.Tecnologia)
        val papeleria = resources.getStringArray(R.array.Papeleria)

        spnCategoria.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                when (position) {
                    0 -> spnProducto.adapter = ArrayAdapter(
                        this@MainActivity,
                        android.R.layout.simple_spinner_item,
                        comida
                    )

                    1 -> spnProducto.adapter = ArrayAdapter(
                        this@MainActivity,
                        android.R.layout.simple_spinner_item,
                        tecnologia
                    )

                    2 -> spnProducto.adapter = ArrayAdapter(
                        this@MainActivity,
                        android.R.layout.simple_spinner_item,
                        papeleria
                    )
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "No se selecciono categoria", Toast.LENGTH_SHORT).show()
            }
        }

        spnProducto.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                when (spnProducto.selectedItem.toString()) {
                    "Tacos Combinados" -> {
                        productoTacoCombinado()
                    }

                    "Chilaquiles Verdes" -> {
                        productoChilaquilesVerdes()
                    }

                    "Pozole Verde" -> {
                        productoPozoleVerde()
                    }

                    "Samsung S23" -> {
                        productoSamsung()
                    }

                    "Asus VivoBook" -> {
                        productoAsus()
                    }

                    "Sony WF-CH510" -> {
                        productoSony()
                    }

                    "Lapiz" -> {
                        productoLapiz()
                    }

                    "Goma" -> {
                        productoGoma()
                    }

                    "Sacapuntas" -> {
                        productoSacapuntas()
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "No se selecciono producto", Toast.LENGTH_SHORT).show()
            }
        }

        val btnCotizar = findViewById<Button>(R.id.btnCotizar)
        btnCotizar.setBackgroundColor(Color.parseColor("#5483B3"))
        btnCotizar.setOnClickListener {
            val intent = Intent(this, DetalleProductoActivity::class.java)
            intent.putExtra("nombreProducto", nombre)
            intent.putExtra("precioProducto", precio.toString())
            intent.putExtra("descripcionProducto", descripcion)
            intent.putExtra("imagenProducto", imagen.toString())
            startActivity(intent)
        }
    }

    fun establecerValoresdeComponentes(nombre: String, precio: Double, descripcion: String, imagen: Int){
        val txtNombre = findViewById<TextView>(R.id.txtNombre)
        val txtPrecio = findViewById<TextView>(R.id.txtPrecio)
        val txtDescripcion = findViewById<TextView>(R.id.txtDesxripcion)
        val imgProducto = findViewById<ImageView>(R.id.imgProducto)

        txtNombre.text = "Nombre: ${nombre}"
        txtPrecio.text = "Precio: ${precio}"
        txtDescripcion.text = "Descripcion: ${descripcion}"
        imgProducto.setImageResource(imagen)
    }

    fun productoTacoCombinado(){
        nombre = "Taco Combinado"
        precio = 13.00
        descripcion = "Taco combinado de bistec y chorizo"
        imagen = R.drawable.tacocombinado

        establecerValoresdeComponentes(nombre,precio,descripcion,imagen)
    }

    fun productoChilaquilesVerdes(){
        nombre = "Chilaquiles Verdes"
        precio = 50.00
        descripcion = "Chilaquiles en salsa verde con queso y crema, y con su tradicional acompañamiento de frijoles refritos."
        imagen = R.drawable.chilaquilesverdes

        establecerValoresdeComponentes(nombre,precio,descripcion,imagen)
    }

    fun productoPozoleVerde(){
        nombre = "Pozole Verde"
        precio = 100.00
        descripcion = "Pozole verde preparado con tomates verdes, epazote y pepita de calabaza"
        imagen = R.drawable.pozoleverde

        establecerValoresdeComponentes(nombre,precio,descripcion,imagen)
    }

    fun productoSamsung(){
        nombre = "Samsung S23"
        precio = 20999.00
        descripcion = "Samsung Galaxy S23 8GB_128GB Lavanda"
        imagen = R.drawable.samsung

        establecerValoresdeComponentes(nombre,precio,descripcion,imagen)
    }

    fun productoAsus(){
        nombre = "ASUS Vivobook 15"
        precio = 20999.00
        descripcion = "Asus VivoBook 15 FHD / D515UA-BQ520W / Ryzen 5-5500U / 8GB en RAM / 256GB SSD"
        imagen = R.drawable.asus

        establecerValoresdeComponentes(nombre,precio,descripcion,imagen)
    }

    fun productoSony(){
        nombre = "Sony WF-CH510"
        precio = 999.00
        descripcion = "Sony WH-CH510 - Audífonos inalámbricos de Diadema, Negro"
        imagen = R.drawable.sony

        establecerValoresdeComponentes(nombre,precio,descripcion,imagen)
    }

    fun productoLapiz(){
        nombre = "Lapiz"
        precio = 10.00
        descripcion = "Lápiz con Goma Número 2 Hexagonal"
        imagen = R.drawable.lapiz

        establecerValoresdeComponentes(nombre,precio,descripcion,imagen)
    }

    fun productoGoma(){
        nombre = "Goma para borrar"
        precio = 18.00
        descripcion = "Goma de Borrar Factis"
        imagen = R.drawable.goma

        establecerValoresdeComponentes(nombre,precio,descripcion,imagen)
    }

    fun productoSacapuntas(){
        nombre = "Sacapuntas"
        precio = 10.00
        descripcion = "Sacapuntas de Metal Cuadrado"
        imagen = R.drawable.sacapuntas

        establecerValoresdeComponentes(nombre,precio,descripcion,imagen)
    }
}