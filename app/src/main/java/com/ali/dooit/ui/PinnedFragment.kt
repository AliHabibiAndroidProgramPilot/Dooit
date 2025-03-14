package com.ali.dooit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ali.dooit.databinding.FragmentPinnedBinding
import com.ali.dooit.mvp.ext.PinnedFragmentContract
import com.ali.dooit.mvp.model.ModelPinnedFragment
import com.ali.dooit.mvp.presenter.PresenterPinnedFragment

class PinnedFragment : Fragment(), PinnedFragmentContract.View {

    private var _binding: FragmentPinnedBinding? = null
    private val binding get() = _binding!!

    private lateinit var presenter: PresenterPinnedFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPinnedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ModelPinnedFragment()
        presenter = PresenterPinnedFragment(model)
        presenter.attachView(this)
        presenter.viewCaller()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
        _binding = null
    }

}