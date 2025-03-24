package com.ali.dooit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ali.dooit.adapter.PinnedListRecyclerAdapter
import com.ali.dooit.databinding.FragmentPinnedBinding
import com.ali.dooit.db.entities.relations.TaskWithTaskSubItems
import com.ali.dooit.mvp.ext.PinnedFragmentContract
import com.ali.dooit.mvp.model.ModelPinnedFragment
import com.ali.dooit.mvp.presenter.PresenterPinnedFragment

class PinnedFragment : Fragment(), PinnedFragmentContract.View {

    private var _binding: FragmentPinnedBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: PresenterPinnedFragment
    private lateinit var recyclerAdapter: PinnedListRecyclerAdapter

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
        val model = ModelPinnedFragment(requireContext())
        presenter = PresenterPinnedFragment(model)
        presenter.attachView(this)
        presenter.viewCaller()
    }

    override fun initPinnedRecycler(pinnedTasks: ArrayList<TaskWithTaskSubItems>) {
        recyclerAdapter = PinnedListRecyclerAdapter(pinnedTasks)
        binding.pinnedRecycler.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.pinnedRecycler.adapter = recyclerAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
        _binding = null
    }

}