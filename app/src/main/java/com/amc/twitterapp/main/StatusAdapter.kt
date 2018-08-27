package com.amc.twitterapp.main

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.amc.twitterapp.data.TwitterStatus
import com.amc.twitterapp.databinding.ItemStatusBinding

/**
 * This class was created by Anthony M Cannon on 26/08/2018.
 */
class StatusAdapter : ListAdapter<TwitterStatus, StatusHolder>(
        object : DiffUtil.ItemCallback<TwitterStatus>() {
            override fun areItemsTheSame(oldItem: TwitterStatus, newItem: TwitterStatus): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TwitterStatus, newItem: TwitterStatus): Boolean {
                return oldItem.createdAt == newItem.createdAt
                        && oldItem.fullText == newItem.fullText
            }
        }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusHolder {
        val binding = ItemStatusBinding.inflate(
                LayoutInflater.from(parent.context), parent, false)
        return StatusHolder(binding)
    }

    override fun onBindViewHolder(holder: StatusHolder, position: Int) {
        holder.binding.status = getItem(position)
        holder.binding.executePendingBindings()
    }
}
