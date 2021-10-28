package com.AndroidStudioProjects.hw2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private var contacts : List<Contact>) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context.applicationContext).inflate(R.layout.item_row,parent,false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
       holder.bind(contacts[position])
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

     class ContactViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

         init {
             itemView.setOnClickListener {
                 val position = adapterPosition
                 Toast.makeText(itemView.context,"You clicked on item ${position + 1}",Toast.LENGTH_LONG).show()
             }
         }
        fun bind (item : Contact) {
//            itemView.findViewById<ImageView>(R.id.image).setImageResource(R.drawable.ic_baseline_account_circle_24)
            itemView.findViewById<TextView>(R.id.txtContactName).text = item.name
            itemView.findViewById<TextView>(R.id.txtContactNumber).text = item.number

        }

    }

    fun setData(newContactList : List<Contact>) {
        val diffUtil = MyDiffUtil(contacts,newContactList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        contacts = newContactList
        diffResult.dispatchUpdatesTo(this)
    }
}