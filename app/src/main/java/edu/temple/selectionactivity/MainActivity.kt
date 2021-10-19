package edu.temple.selectionactivity


import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.View


const val EXTRA_MESSAGE = "edu.temple.selectionactivity.MESSAGE"
const val EXTRA_IMAGE = "edu.temple.selectionactivity.IMAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val foodArray: Array<Image> = arrayOf(Image(resources.getString(R.string.sandwhich),R.drawable.chicken_sandwhich),
            Image(resources.getString(R.string.tofu),R.drawable.tofu_stew),Image(resources.getString(R.string.fried_Chicken),R.drawable.fried_chicken)
            ,Image(resources.getString(R.string.corn_Dog),R.drawable.corn_dog), Image(resources.getString(R.string.dumplings),R.drawable.dumpling)
            ,Image(resources.getString(R.string.onigiri),R.drawable.onigiri),Image(resources.getString(R.string.pork_Belly),R.drawable.pork_belly)
            ,Image(resources.getString(R.string.pork_Bun),R.drawable.pork_bun),Image(resources.getString(R.string.ramen),R.drawable.ramen)
            ,Image(resources.getString(R.string.steak),R.drawable.steak),Image(resources.getString(R.string.sushi),R.drawable.sushi))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        var adapter = ImageAdapter(foodArray)
        recyclerView.adapter=adapter
        recyclerView.layoutManager= GridLayoutManager(this, 3)

        val testString : String = "example only"
        var bundle = Bundle()
        bundle.putParcelableArray("test", foodArray)
        var frag = SelectionFragment()
        frag.arguments = bundle

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