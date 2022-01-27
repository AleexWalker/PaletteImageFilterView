package com.example.palette

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.transition.Fade
import androidx.transition.Slide
import androidx.transition.TransitionManager
import kotlinx.android.synthetic.main.item_cards.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.appbar)
        setSupportActionBar(toolbar)

        val items = ArrayList<Tarjeta>()
        items.add(Tarjeta(R.drawable.image1))
        items.add(Tarjeta(R.drawable.image2))
        items.add(Tarjeta(R.drawable.image3))
        items.add(Tarjeta(R.drawable.image4))
        items.add(Tarjeta(R.drawable.image5))
        items.add(Tarjeta(R.drawable.image6))
        items.add(Tarjeta(R.drawable.image7))
        items.add(Tarjeta(R.drawable.image8))

        val recView = findViewById<RecyclerView>(R.id.recview)

        recView.setHasFixedSize(true)

        val adaptador = CardsAdapter(items)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adaptador.onClick = {
            val intent = Intent(this, MainActivity2::class.java)
            val item = items.get(recView.getChildAdapterPosition(it))
            val p1 = Pair.create<View, String>(image1, image1.transitionName)

            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, p1).toBundle()

            //options?.putString("NOM", item.)
            options?.putInt("LOGO", item.imagen)

            //Añadimos la información al Intent
            intent.putExtras(options!!)
            startActivity(intent, options)
            //overridePendingTransition(R.transition.fade, R.transition.slide)
        }
    }
}