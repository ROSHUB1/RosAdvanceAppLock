package com.rosadvanceapplock.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rosadvanceapplock.R

class LockedAppsAdapter(
    private var lockedApps: MutableList<String>,
    private val onRemoveClick: (String) -> Unit
) : RecyclerView.Adapter<LockedAppsAdapter.LockedAppViewHolder>() {
    
    class LockedAppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val appName: TextView = itemView.findViewById(R.id.app_name)
        private val removeButton: Button = itemView.findViewById(R.id.remove_button)
        
        fun bind(packageName: String, onRemove: (String) -> Unit) {
            appName.text = packageName
            removeButton.setOnClickListener { onRemove(packageName) }
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LockedAppViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_locked_app, parent, false)
        return LockedAppViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: LockedAppViewHolder, position: Int) {
        holder.bind(lockedApps[position], onRemoveClick)
    }
    
    override fun getItemCount() = lockedApps.size
    
    fun updateList(newList: MutableList<String>) {
        lockedApps = newList
        notifyDataSetChanged()
    }
}