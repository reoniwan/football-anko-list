package com.frozenproject.footballapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.frozenproject.footballapps.adapter.ListClubAdapter
import com.frozenproject.footballapps.data.FootballTeam
import com.frozenproject.footballapps.detail.ClubDetail
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {
    //mutable value from parcelable
    private var clubFootball: MutableList<FootballTeam> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()

        relativeLayout {
            padding = dip(16)
            lparams(width = matchParent, height = wrapContent)

            recyclerView {
                lparams(width = matchParent, height = wrapContent)
                layoutManager = LinearLayoutManager(context)

                //moving method to new activity with data from parcelable
                adapter = ListClubAdapter(context, clubFootball) {
                    startActivity<ClubDetail>("clubSheaf" to it)
                }
            }

        }

    }

    //initial to get data from array string
    private fun initData() {
        val nameClub = resources.getStringArray(R.array.club_name)
        val logoClub = resources.obtainTypedArray(R.array.img_club)
        val descriptionClub = resources.getStringArray(R.array.club_desc)

        for (i in nameClub.indices) {
            clubFootball.add(
                FootballTeam(
                    nameClub[i],
                    logoClub.getResourceId(i, 0),
                    descriptionClub[i]
                )
            )
        }
        logoClub.recycle()
    }

}



