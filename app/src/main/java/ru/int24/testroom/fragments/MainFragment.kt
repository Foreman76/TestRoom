package ru.int24.testroom.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
import ru.int24.testroom.R
import ru.int24.testroom.adapters.DocAdapter
import ru.int24.testroom.models.OneCDocument
import ru.int24.testroom.viewmodels.DocumentViewModel


class MainFragment : Fragment(R.layout.fragment_main) {

    private val myAdapter = DocAdapter()
    private val documentViewModel: DocumentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        documentViewModel.getFromNetwork()
        documentViewModel.setTodataBase()
        documentViewModel.setDocToList()

        rc.adapter = myAdapter
        rc.layoutManager = LinearLayoutManager(context)
        documentViewModel.getListDoc().observe(viewLifecycleOwner, Observer<ArrayList<OneCDocument>> { myAdapter.setData(it) })

    }

}