package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast

class Game : AppCompatActivity() {

    private lateinit var hungerBar: ProgressBar
    private lateinit var happyBar: ProgressBar
    private lateinit var cleanBar: ProgressBar

    private var hungerProgress = 0
    private var cleanProgress = 0
    private var happyProgress = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        val image = findViewById<ImageView>(R.id.imageView)
        val feed = findViewById<Button>(R.id.feed)
        val clean = findViewById<Button>(R.id.clean)
        val play = findViewById<Button>(R.id.plays)


        feed.setOnClickListener {
            test(image, R.drawable.food)
            if (hungerProgress < 30 ) {
                hungerProgress += 10
                hungerBar.progress = hungerProgress}
            if (hungerProgress == 30) {
                feed.isEnabled = false
                Toast.makeText(this,"Bob is full", Toast.LENGTH_SHORT).show()}

        }

        clean.setOnClickListener {
            test(image, R.drawable.wash)
            if (cleanProgress < 30 ) {
                cleanProgress += 10
                cleanBar.progress = cleanProgress}
            if (cleanProgress == 30) {
                clean.isEnabled = false
                Toast.makeText(this,"Bob is Clean", Toast.LENGTH_SHORT).show()}

        }

        play.setOnClickListener {
            test(image, R.drawable.play)
            if (happyProgress < 30 ) {
                happyProgress += 10
                happyBar.progress = happyProgress}
            if (happyProgress == 30) {
                play.isEnabled = false
                Toast.makeText(this,"Bob is Happy", Toast.LENGTH_SHORT).show()}

        }
    }

    private fun test(imageView: ImageView, drawableId: Int) {
        imageView.setImageResource(drawableId)
    }
}
