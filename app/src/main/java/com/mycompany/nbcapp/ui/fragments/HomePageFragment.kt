package com.mycompany.nbcapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import com.mycompany.nbcapp.R
import com.mycompany.nbcapp.databinding.FragmentHomeBinding
import com.mycompany.nbcapp.adapters.ShelvesAdapter
import com.mycompany.nbcapp.models.Shelve
import com.mycompany.nbcapp.ui.NbcViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: NbcViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    lateinit var binding: FragmentHomeBinding
    lateinit var shelvesAdapter: ShelvesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.setPage()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        connectData()
    }

    private fun connectData() {
        viewModel.setPage()
        viewModel.page.observe(viewLifecycleOwner, Observer {
            setRecyclerView(it.shelves)
            shelvesAdapter.differ.submitList(it.shelves)
        })
    }

    private fun setRecyclerView(shelves: List<Shelve>) {
        shelvesAdapter = ShelvesAdapter(shelves)
        binding.rvHome.apply {
            adapter = shelvesAdapter
        }
    }
}