package com.amc.twitterapp.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.amc.twitterapp.R
import com.amc.twitterapp.api.ApiSuccessResponse
import com.amc.twitterapp.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * This class was created by Anthony M Cannon on 26/08/2018.
 */
class MainFragment : Fragment() {

    var viewModelFactory: ViewModelProvider.Factory? = null

    private var adapter: StatusAdapter = StatusAdapter()
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentMainBinding>(
                inflater, R.layout.fragment_main, container, false).apply {
            viewModel = this@MainFragment.viewModel
            setLifecycleOwner(this@MainFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        status_list.adapter = this@MainFragment.adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getList().observe(this, Observer {
            if (it is ApiSuccessResponse) {
                adapter.submitList(it.body)
            } else {
                Toast.makeText(context, "Sorry, no statuses could be loaded.", Toast.LENGTH_LONG).show()
            }
        })
    }
}