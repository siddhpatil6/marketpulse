package com.marketpulse.scans.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Criteria(
    val text: String?,
    val type: String?,
    val variable:Variable?

):Parcelable