package com.ali.dooit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ali.dooit.databinding.RecyclerItemBinding
import com.ali.dooit.db.entities.TaskEntity
import com.ali.dooit.mvp.ext.PinnedFragmentContract
import java.time.format.DateTimeFormatter

class PinnedRecyclerAdapter(
    private val pinnedTasks: ArrayList<TaskEntity>,
    private val includedView: View
) : RecyclerView.Adapter<PinnedRecyclerAdapter.CustomViewHolder>() {

    inner class CustomViewHolder(
        private val binding: RecyclerItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun setData(item: TaskEntity) {
            binding.txtTitle.text = item.taskTitle
            if (item.taskLabel != null)
                binding.txtLabel.text = item.taskLabel
            else
                binding.txtLabel.visibility = View.GONE
            if (item.isNotificationSet) {
                val date: String =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy - h:mm")
                        .format(item.notificationDataAndTime)
                binding.txtNotification.text = date
            } else {
                binding.txtNotification.visibility = View.GONE
                binding.icDate.visibility = View.GONE
            }
            binding.helperViewGroup.setOnClickListener {
                // TODO Intent to Activity
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder =
        CustomViewHolder(
            RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int {
        // TODO Manage include visibility
        return pinnedTasks.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.setData(pinnedTasks[position])
    }

}