package edu.temple.selectionactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter (private val foodArray: Array<Image>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>()
{
    private lateinit var mListener : onItemClickListener
    interface onItemClickListener {
        fun onItemClick(position : Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    inner class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val imageView = itemView.findViewById<ImageView>(R.id.itemHolder)
        init{
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val contactView = inflater.inflate(R.layout.itemholder, parent, false)

        return ViewHolder(contactView,mListener)
    }


    override fun onBindViewHolder(viewHolder: ImageAdapter.ViewHolder, position: Int) {

        val food: Image = foodArray[position]

        val imageView = viewHolder.imageView
        imageView.setImageResource(food.resourceId)
    }


    override fun getItemCount(): Int {
        return foodArray.size
    }

}