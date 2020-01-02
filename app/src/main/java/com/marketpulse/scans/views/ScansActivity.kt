package com.marketpulse.scans.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.marketpulse.R
import com.marketpulse.scans.adapter.ScansListAdapter
import com.marketpulse.scans.models.ScansModel
import com.marketpulse.scans.viewmodel.ScansVM
import com.marketpulse.utils.Util
import kotlinx.android.synthetic.main.activity_scans.*

class ScansActivity : AppCompatActivity() {

    var scansResponseModle: LiveData<ArrayList<ScansModel>>? = null
    lateinit var scansListAdapter: ScansListAdapter

    private lateinit var scansVM: ScansVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scans)
        intitialize()
        callScansList()

    }

    fun intitialize()
    {
        Util.setToolbar(this, tbScans, "Scans")
    }


    private fun callScansList()
    {
        scansVM = ViewModelProviders.of(this).get(ScansVM::class.java)

        scansVM.getScansList()?.observe(this, scansResponseObserver)

    }

    val scansResponseObserver: Observer<ArrayList<ScansModel>> =
        Observer { data ->
            var linearLayoutManager = LinearLayoutManager(this)
            rvCriteria.layoutManager = linearLayoutManager
            scansListAdapter= ScansListAdapter(data)
            rvCriteria.adapter=scansListAdapter
            rvCriteria.adapter?.notifyDataSetChanged()

        }


}
