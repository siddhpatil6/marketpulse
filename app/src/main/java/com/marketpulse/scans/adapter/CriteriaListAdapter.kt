package com.marketpulse.scans.adapter

import android.app.Activity
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.marketpulse.R
import com.marketpulse.scans.models.Criteria
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.criteria_row.view.*


public class CriteriaListAdapter(val criteriaList:ArrayList<Criteria>?, var activity: Activity): RecyclerView.Adapter<CriteriaListAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CriteriaListAdapter.ViewHolder
    {


        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.criteria_row, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {

        if (criteriaList == null)
        return 0;
        else
        return  criteriaList.size;
    }

    class CriteriaClickableSpan(var index: Int,var activity: Activity,var position: Int,var criteriaList: ArrayList<Criteria>?) : ClickableSpan() {

        override fun onClick(widget: View) {
            Toast.makeText(activity,""+criteriaList?.get(position)?.text,Toast.LENGTH_LONG).show()
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val text = SpannableString(criteriaList?.get(position)?.text)
        if (text.contains("$"))
            {
                var index: Int = text.indexOf("$")
                while (index >= 0) {
                    text.setSpan(CriteriaClickableSpan(index+1,activity,position,criteriaList), index, index+2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                    println(index)
                    index = text.indexOf("$", index + 1)

                }

            }
            holder.itemView.tvText.setMovementMethod(LinkMovementMethod.getInstance())
            holder.itemView.tvText.setText(text)

            holder.itemView.setOnClickListener {

            }

    }


    inner class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer

}