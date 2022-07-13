package com.example.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.newsapp.adapter.QuoteAdapter
import kotlinx.android.synthetic.main.fragment_quote.*

class QuoteFragment : Fragment() {
    val arrayList=ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val  view =inflater.inflate(R.layout.fragment_quote , container , false)
        return view
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        card_view.setOnClickListener {
            card_view.visibility=View.INVISIBLE
            recycler_quote.layoutManager = LinearLayoutManager(requireContext())
            arrayList.add(R.drawable.i1)
            arrayList.add(R.drawable.i2)
            arrayList.add(R.drawable.i3)
            arrayList.add(R.drawable.i6)

            PagerSnapHelper().attachToRecyclerView(recycler_quote)
            recycler_quote.adapter = QuoteAdapter(arrayList)
        }
    }

}