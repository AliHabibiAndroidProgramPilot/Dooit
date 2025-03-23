package com.ali.dooit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ali.dooit.R
import com.ali.dooit.databinding.RecyclerItemBinding
import com.ali.dooit.db.entities.TaskEntity
import com.ali.dooit.db.entities.relations.TaskWithTaskSubItems
import java.time.format.DateTimeFormatter
import kotlin.random.Random

class PinnedListRecyclerAdapter(
    private val tasksList: ArrayList<TaskWithTaskSubItems>
) : RecyclerView.Adapter<PinnedListRecyclerAdapter.CustomViewHolder>() {

    inner class CustomViewHolder(private val binding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val colors = listOf(
            R.color.item_background_color1,
            R.color.item_background_color2,
            R.color.item_background_color3,
        )

        fun setData(item: TaskEntity) {
            binding.helperViewGroup.setBackgroundColor(colors[Random.nextInt(0, 3)])
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
        holder.setData(tasksList[position].task)
    }

    fun initializeDiffCallback(newList: ArrayList<TaskWithTaskSubItems>) {
        val diffCallBack = RecyclerDiffUtils(tasksList, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)
        tasksList.clear()
        tasksList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

}