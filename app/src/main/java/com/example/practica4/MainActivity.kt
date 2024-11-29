package com.example.practica4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.FrameLayout
import android.widget.ImageSwitcher
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val imageSwitcher: ImageSwitcher = findViewById(R.id.imageSwitcher)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // Configura el ImageSwitcher
        imageSwitcher.setFactory {
            ImageView(this).apply {
                layoutParams = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
                scaleType = ImageView.ScaleType.CENTER_CROP
            }
        }

        // Lista de imágenes
        val images = listOf(
            ImageItem(R.drawable.image1),
            ImageItem(R.drawable.image2),
            ImageItem(R.drawable.image3),
            ImageItem(R.drawable.image4)
        )

        // Configura el RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = ImageAdapter(images) { imageResId ->
            imageSwitcher.setImageResource(imageResId)
        }

    }
}