package com.marketpulse.scans.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class X4(
    val default_value: Int?,
    val max_value: Int?,
    val min_value: Int?,
    val parameter_name: String?,
    val study_type: String?,
    val type: String?,
    var values: List<String>?
):Parcelable