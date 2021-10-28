package com.AndroidStudioProjects.hw2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

 const val FROM_SECOND = "fromSecond"
 const val RESULT_KEY = "resultKey"

class SecondFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val inputEditText = view.findViewById<EditText>(R.id.edtFromSecondFragment).text
//        Log.d("redmi", "$inputEditText")
        view.findViewById<Button>(R.id.btnGoBack).setOnClickListener {
            parentFragmentManager.popBackStack()
            parentFragmentManager.setFragmentResult(FROM_SECOND, bundleOf(RESULT_KEY to inputEditText.toString()))
        }
    }

}