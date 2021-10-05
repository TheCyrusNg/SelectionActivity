package edu.temple.selectionactivity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.View


val foodArray: Array<Image> = arrayOf(Image("sandwhich",R.drawable.chicken_sandwhich),
    Image("tofu",R.drawable.tofu_stew),Image("Fried Chicken",R.drawable.fried_chicken)
    ,Image("Corn Dog",R.drawable.corn_dog), Image("Dumplings",R.drawable.dumpling)
    ,Image("Onigiri",R.drawable.onigiri),Image("Pork Belly",R.drawable.pork_belly)
    ,Image("Pork Bun",R.drawable.pork_bun),Image("Ramen",R.drawable.ramen)
    ,Image("Steak",R.drawable.steak),Image("Sushi",R.drawable.sushi))

const val EXTRA_MESSAGE = "edu.temple.selectionactivity.MESSAGE"
const val EXTRA_IMAGE = "edu.temple.selectionactivity.IMAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        var adapter = ImageAdapter(foodArray)
        recyclerView.adapter=adapter
        recyclerView.layoutManager= GridLayoutManager(this, 3)

        adapter.setOnItemClickListener(object : ImageAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val message = foodArray[position].description
                val image = foodArray[position].resourceId
                val intent = Intent(this@MainActivity,DisplayActivity::class.java).apply{
                    putExtra(EXTRA_MESSAGE,message)
                    putExtra(EXTRA_IMAGE,image)
                }
                startActivity(intent)
            }
        })
    }
}