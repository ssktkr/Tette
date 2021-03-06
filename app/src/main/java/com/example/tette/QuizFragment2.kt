package com.example.tette

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class QuizFragment2: Fragment() {
    companion object {
        fun createInstance(): QuizFragment2 {
            return QuizFragment2()
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.quiz_fragment2_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonnext = view.findViewById<Button>(R.id.buttonfirstnext)
        buttonnext.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.add(R.id.fragment_layout, QuizFragment3.createInstance())
            transaction?.addToBackStack(null)
            transaction?.commit()
        }

        val buttonprev = view.findViewById<Button>(R.id.buttonfirstprev)
        buttonprev.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }
}