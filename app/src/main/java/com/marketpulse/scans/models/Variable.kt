package com.marketpulse.scans.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Variable(
    @SerializedName(value="$1", alternate= ["$2","$3","$4","$5"])
    val `$4`: X4?
):Parcelable