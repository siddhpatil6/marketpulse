package com.marketpulse.scans.models

data class ScansModel(
    val color: String,
    val criteria: List<Criteria>,
    val id: Int,
    val name: String,
    val tag: String
)