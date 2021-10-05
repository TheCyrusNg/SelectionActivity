package edu.temple.selectionactivity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)


        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val image = intent.getIntExtra(EXTRA_IMAGE,0)


        val textView = findViewById<TextView>(R.id.actTextView).apply {
            text = message
        }

        val iView = findViewById<ImageView>(R.id.actImageView)
        iView.setImageResource(image)
    }

}