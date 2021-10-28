package com.AndroidStudioProjects.hw2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FirstFragment: Fragment() {

    val contactList = mutableListOf(
        Contact("Philip","+37455555555"),
        Contact("Sherlock","+37455555233"),
        Contact("Jack","+37455554545"),
        Contact("Logan","+37455333333"),
        Contact("Vincent","+37455111111"),
        Contact("Albert","+37455558855"),
        Contact("David","+37455999555"))

    private val myAdapter by lazy { ContactAdapter(contactList)}



    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_first,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val image = view.findViewById<ImageView>(R.id.imgContactPic)


        val recyclerView = view.findViewById<RecyclerView>(R.id.rvContacts)
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)


        view.findViewById<Button>(R.id.btnAddContact).setOnClickListener {
           val newContactList = contactList.plus(Contact("Tomas","+37493828384"))
             myAdapter.setData(newContactList)
        }

        view.findViewById<Button>(R.id.btnSecondFragment).setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.secondContainer,SecondFragment())
                .addToBackStack(null)
                .commit()
        }


        parentFragmentManager.setFragmentResultListener(FROM_SECOND,viewLifecycleOwner) { _, bundle->
            if (bundle.containsKey(RESULT_KEY)) {
                Toast.makeText(context,"${bundle.getString(RESULT_KEY)}",Toast.LENGTH_LONG).show()

            }

        }


    }


}


