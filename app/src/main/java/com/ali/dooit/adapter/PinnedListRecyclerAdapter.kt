package com.ali.dooit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ali.dooit.databinding.RecyclerItemBinding
import com.ali.dooit.db.entities.TaskEntity
import java.time.format.DateTimeFormatter

class PinnedListRecyclerAdapter(
    private val tasksList: ArrayList<TaskEntity>
) : RecyclerView.Adapter<PinnedListRecyclerAdapter.CustomViewHolder>() {

    inner class CustomViewHolder(private val binding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(item: TaskEntity) {
            // Add Task Title
            binding.txtTitle.text = item.taskTitle
            // Manage Task Label
            if (item.taskLabel == null)
                binding.txtLabel.visibility = View.GONE
            else
                binding.txtLabel.text = item.taskLabel
            // Manage Task Notification
            if (item.isNotificationSet) {
                val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
                binding.txtNotification.text = formatter.format(item.notificationDataAndTime)
            } else {
                binding.txtNotification.visibility = View.GONE
                binding.icDate.visibility = View.GONE
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder =
        CustomViewHolder(
            RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = tasksList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.setData(tasksList[position])
    }

    fun initializeDiffCallback(newList: ArrayList<TaskEntity>) {
        val diffCallBack = RecyclerDiffUtils(tasksList, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)
        tasksList.clear()
        tasksList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

}