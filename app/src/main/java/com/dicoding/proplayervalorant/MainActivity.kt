package com.dicoding.proplayervalorant

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPlayers: RecyclerView
    private val list = ArrayList<Player>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Pro Player Valorant"

        rvPlayers = findViewById(R.id.rv_players)
        rvPlayers.setHasFixedSize(true)

        list.addAll(getListPlayers())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvPlayers.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvPlayers.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.action_about -> {
                val intent = Intent(this@MainActivity, AboutMe::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListPlayers(): ArrayList<Player> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataMouse = resources.getStringArray(R.array.data_mouse)
        val dataKeyboard = resources.getStringArray(R.array.data_keyboard)
        val dataHeadset = resources.getStringArray(R.array.data_headset)
        val listPlayer = ArrayList<Player>()
        for (i in dataName.indices) {
            val player = Player(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataMouse[i], dataKeyboard[i], dataHeadset[i])
            listPlayer.add(player)
        }
        return listPlayer
    }

    private fun showRecyclerList() {
        rvPlayers.layoutManager = LinearLayoutManager(this)
        val listPlayerAdapter = ListPlayerAdapter(list)
        rvPlayers.adapter = listPlayerAdapter

        listPlayerAdapter.setOnItemClickCallback(object : ListPlayerAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Player) {
                val moveWithIntent = Intent(this@MainActivity, DetailPlayer::class.java)
                moveWithIntent.putExtra(DetailPlayer.EXTRA_NAME, data.name)
                moveWithIntent.putExtra(DetailPlayer.EXTRA_DESCRIPTION, data.description)
                moveWithIntent.putExtra(DetailPlayer.EXTRA_PHOTO, data.photo)
                moveWithIntent.putExtra(DetailPlayer.EXTRA_MOUSE, data.mouse)
                moveWithIntent.putExtra(DetailPlayer.EXTRA_KEYBOARD, data.keyboard)
                moveWithIntent.putExtra(DetailPlayer.EXTRA_HEADSET, data.headset)
                startActivity(moveWithIntent)
            }
        })
    }
}