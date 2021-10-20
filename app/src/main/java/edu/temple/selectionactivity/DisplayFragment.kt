package edu.temple.selectionactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class DisplayFragment : Fragment() {
    private var viewModel : ImageViewModel? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var message : String? = null
        var image : String? = null
        val textView = view.findViewById<TextView>(R.id.actTextView)
        val viewModel = ViewModelProvider(this).get(ImageViewModel::class.java)
        viewModel.message.observe(viewLifecycleOwner,{o -> textView.text = o!!.toString()})

        viewModel.image.observe(viewLifecycleOwner, Observer{O ->
            image = O.toString()
            println(image)
        })

        val foodArray: Array<Image> = arrayOf(Image(resources.getString(R.string.sandwhich),R.drawable.chicken_sandwhich),
            Image(resources.getString(R.string.tofu),R.drawable.tofu_stew),Image(resources.getString(R.string.fried_Chicken),R.drawable.fried_chicken)
            ,Image(resources.getString(R.string.corn_Dog),R.drawable.corn_dog), Image(resources.getString(R.string.dumplings),R.drawable.dumpling)
            ,Image(resources.getString(R.string.onigiri),R.drawable.onigiri),Image(resources.getString(R.string.pork_Belly),R.drawable.pork_belly)
            ,Image(resources.getString(R.string.pork_Bun),R.drawable.pork_bun),Image(resources.getString(R.string.ramen),R.drawable.ramen)
            ,Image(resources.getString(R.string.steak),R.drawable.steak),Image(resources.getString(R.string.sushi),R.drawable.sushi))
        val imageView = view.findViewById<ImageView>(R.id.actImageView)
        imageView.setImageResource(foodArray[0].resourceId)
        var mes : String? = message
        var ima : String? = image
        if(mes != message){
            textView.setText(message)
        }
        if(ima != image){
            imageView.setImageResource(foodArray[image!!.toInt()].resourceId)
        }

    }


}


