package com.marketpulse.scans.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ScansModel(
    val color: String?,
    val criteria:ArrayList<Criteria>?,
    val id: Int?,
    val name: String?,
    val tag: String?
):Parcelable