package com.dicoding.proplayervalorant

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailPlayer : AppCompatActivity() {
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_MOUSE = "extra_mouse"
        const val EXTRA_KEYBOARD = "extra_keyboard"
        const val EXTRA_HEADSET = "extra_headset"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_player)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Pro Player Detail"

        val playerName: TextView = findViewById<TextView>(R.id.tv_item_name)
        val playerDescription: TextView = findViewById<TextView>(R.id.tv_item_description)
        val playerPhoto: ImageView = findViewById<ImageView>(R.id.img_item_photo)
        val playerMouse: TextView = findViewById<TextView>(R.id.text_mouse)
        val playerKeyboard: TextView = findViewById<TextView>(R.id.text_keyboard)
        val playerHeadset: TextView = findViewById<TextView>(R.id.text_headset)

        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)
        val mouse = intent.getStringExtra(EXTRA_MOUSE)
        val keyboard = intent.getStringExtra(EXTRA_KEYBOARD)
        val headset = intent.getStringExtra(EXTRA_HEADSET)

        playerName.text = name
        playerDescription.text = description
        playerPhoto.setImageResource(photo)
        playerMouse.text = mouse
        playerKeyboard.text = keyboard
        playerHeadset.text = headset
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}