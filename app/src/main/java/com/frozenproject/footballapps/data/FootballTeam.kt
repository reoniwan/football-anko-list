package com.frozenproject.footballapps.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FootballTeam(val teamName: String, val imgTeam: Int, val teamDesc: String) : Parcelable