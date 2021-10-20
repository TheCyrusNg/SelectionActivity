package edu.temple.selectionactivity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "test"
private const val ARG_PARAM2 = "param2"



/**
 * A simple [Fragment] subclass.
 * Use the [SelectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Array<Image>? = null
    private var param2: String? = null
    val EXTRA_MESSAGE = "edu.temple.selectionactivity.MESSAGE"
    val EXTRA_IMAGE = "edu.temple.selectionactivity.IMAGE"
    var ima : Array<Image>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getParcelableArray(ARG_PARAM1) as Array<Image>
            param2 = it.getString(ARG_PARAM2)
            ima = param1
            val message = param1?.get(0)?.description
            val image = param1?.get(0)?.resourceId

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val foodArray: Array<Image> = arrayOf(Image(resources.getString(R.string.sandwhich),R.drawable.chicken_sandwhich),
            Image(resources.getString(R.string.tofu),R.drawable.tofu_stew),Image(resources.getString(R.string.fried_Chicken),R.drawable.fried_chicken)
            ,Image(resources.getString(R.string.corn_Dog),R.drawable.corn_dog), Image(resources.getString(R.string.dumplings),R.drawable.dumpling)
            ,Image(resources.getString(R.string.onigiri),R.drawable.onigiri),Image(resources.getString(R.string.pork_Belly),R.drawable.pork_belly)
            ,Image(resources.getString(R.string.pork_Bun),R.drawable.pork_bun),Image(resources.getString(R.string.ramen),R.drawable.ramen)
            ,Image(resources.getString(R.string.steak),R.drawable.steak),Image(resources.getString(R.string.sushi),R.drawable.sushi))
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        var adapter = ImageAdapter(foodArray)
        recyclerView.adapter=adapter
        recyclerView.layoutManager= GridLayoutManager(context,3)

        val viewModel = ViewModelProvider(this).get(ImageViewModel::class.java)

        val bundle = arguments
        val message = bundle?.getString("param2")

        adapter.setOnItemClickListener(object : ImageAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val message = param1?.get(position)?.description
                val image = param1?.get(position)?.resourceId
                viewModel.setMessage(message)
                viewModel.setImage(position.toString())
                println(viewModel.getMessage().toString())

            }
        })


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SelectionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Array<Image>, param2: String) =
            SelectionFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArray(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)

                }
            }
    }
}