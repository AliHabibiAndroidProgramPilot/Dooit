package com.ali.dooit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ali.dooit.databinding.FragmentAllListBinding
import com.ali.dooit.mvp.ext.AllListFragmentContract
import com.ali.dooit.mvp.model.ModelAllListFragment
import com.ali.dooit.mvp.presenter.PresenterAllListFragment

class AllListFragment : Fragment(), AllListFragmentContract.View {

    private var _binding: FragmentAllListBinding? = null
    private val binding get() = _binding!!

    private lateinit var presenter: PresenterAllListFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ModelAllListFragment()
        presenter = PresenterAllListFragment(model)
        presenter.attachView(this)
        presenter.viewCaller()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        presenter.detachView()
    }

}