package com.marketpulse.scans.adapter

import android.app.Activity
import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marketpulse.R
import com.marketpulse.scans.models.Criteria
import com.marketpulse.scans.models.ScansModel
import com.marketpulse.scans.views.CriteriaActivity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.scans_row.view.*

public class ScansListAdapter(val scanList:ArrayList<ScansModel>,var activity: Activity): RecyclerView.Adapter<ScansListAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScansListAdapter.ViewHolder
    {


        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.scans_row, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {

        return scanList.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tvName.text=scanList.get(position).name
        holder.itemView.tvTag.text=scanList.get(position).tag

        holder.itemView.setOnClickListener {
            var criteraIntent= Intent(activity,CriteriaActivity::class.java)
            criteraIntent.putParcelableArrayListExtra("criteria",scanList.get(position).criteria)
            activity.startActivity(criteraIntent)
        }
    }


    inner class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer

}