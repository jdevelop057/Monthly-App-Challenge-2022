package com.jdevelop.starwarsapp.ui.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.jdevelop.starwarsapp.R
import com.jdevelop.starwarsapp.data.model.people.PeopleModel
import com.jdevelop.starwarsapp.data.model.people.PeopleResultsModel
import com.squareup.picasso.Picasso

/**
 * Created by Jdevelop057 on 12/02/2022.
 */
class MainRecyclerViewAdapter(private val onClickListener: (PeopleResultsModel) -> Unit) :
    RecyclerView.Adapter
    <MainRecyclerViewAdapter.ViewHolder>(), ClickListener {

    private lateinit var mainList: PeopleModel

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageViewCardView: AppCompatImageView =
            view.findViewById(R.id.imageViewCardView)
        private val textViewCardView: TextView = view.findViewById(R.id.textViewCardView)


        fun render(item: PeopleResultsModel, onClickListener: (PeopleResultsModel) -> Unit) {
            val list = item.url.split("/")
            val id = list[list.size - 1].ifEmpty { list[list.size - 2] }
            Picasso.get()
                .load("https://starwars-visualguide.com/assets/img/characters/${id}.jpg")
                .placeholder(R.drawable.starwars_logo)
                .error(R.drawable.starwars_logo)
                .into(imageViewCardView)

            textViewCardView.text = item.name

            itemView.setOnClickListener { onClickListener(item) }
        }

    }


    fun setData(data: PeopleModel) {
        mainList = data
    }


    fun addData(data: PeopleModel) {
        mainList.results.addAll(data.results)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.people_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mainList.results[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = mainList.results.size
    override fun onItemClick(position: Int, v: View?) {
        TODO("Not yet implemented")
    }

}

interface ClickListener {
    fun onItemClick(position: Int, v: View?)
}