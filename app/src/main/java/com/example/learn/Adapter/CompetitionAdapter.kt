package com.example.learn.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.learn.DetailActivity
import com.example.learn.R
import com.example.learn.models.Competition
import com.google.gson.Gson

class CompetitionAdapter (private val dataSet: List<Competition>) :
    RecyclerView.Adapter<CompetitionAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val tv_name: TextView
        val tv_type: TextView
        val iv_eb: ImageView


        init {
            // Define click listener for the ViewHolder's View
            tv_name = view.findViewById(R.id.iname)
            tv_type = view.findViewById(R.id.itype)
            iv_eb = view.findViewById(R.id.imblem_im)
            view.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val competition = dataSet[position]
                val intent = Intent(view.context, DetailActivity::class.java)
                val json = Gson().toJson(competition)
                intent.putExtra("competition", json)
                view.context.startActivity(intent)
                Toast.makeText(view.getContext(), "Item is clicked"+ position, Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.comp_rv_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.tv_name.text = dataSet[position].name
        viewHolder.tv_type.text = dataSet[position].type
        Glide.with(viewHolder.iv_eb.context)
            .load(dataSet[position].emblem)
            .placeholder(R.drawable.ic_launcher_background)
            .error(android.R.drawable.ic_dialog_alert)
            .into(viewHolder.iv_eb)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
