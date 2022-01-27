package com.example.palette

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Toolbar
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.palette.graphics.Palette
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val toolMensaje = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        val imagLogo = findViewById<ImageFilterView>(R.id.imageFilterView)
        var saturacion = false
        val contrasteInicial = imageFilterView.contrast
        val calidezInicial = imageFilterView.warmth

        val bundle = intent.extras
        val imagenSeleccionada = bundle!!.getInt("LOGO")

        toolMensaje.title = "PALETTE"

        imagLogo.setImageResource(bundle!!.getInt("LOGO"))

        val bitmap: Bitmap = BitmapFactory.decodeResource(resources, imagenSeleccionada)

        imageFilterView.setOnClickListener {
            imageFilterView.startAnimation(AnimationUtils.loadAnimation(baseContext, R.anim.anim_item))
            if (saturacion) {
                imageFilterView.saturation = 1f
                saturacion = false
            }else {
                imageFilterView.saturation = 0f
                saturacion = true
            }
        }

        contraste.setOnSeekBarChangeListener( object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                imageFilterView.contrast = (contrasteInicial + p1 * 0.01).toFloat()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        calidez.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                imageFilterView.warmth = (calidezInicial + p1 * 0.01).toFloat()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })
    }
}