package com.frozenproject.footballapps.detail

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.frozenproject.footballapps.R
import com.frozenproject.footballapps.data.FootballTeam
import org.jetbrains.anko.*


class ClubDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Implementation parcelable data
        val grup: FootballTeam? = intent.getParcelableExtra("clubSheaf")

        verticalLayout {
            lparams(width = matchParent, height = wrapContent)

            //BANNER layout
            verticalLayout {
                lparams(
                    width = matchParent,
                    height = dip(200)
                )
                background = ColorDrawable(Color.parseColor("#ff748c")) //COLOR_BANNER

                //BACK_BUTTON
                imageButton {
                    id = R.id.back_button
                    val back: ImageButton? = findViewById(R.id.back_button)
                    back?.setOnClickListener { onBackPressed() }
                    //ICON_BACK
                    background = ContextCompat.getDrawable(context, R.drawable.image_back_34dp)
                }.lparams {
                    width = dip(30)
                    height = dip(30)
                    setMargins(dip(15), dip(15), 0, 0)
                }

                //IMAGE_VIEW : Club Football logo
                imageView {
                    Glide.with(this)
                        .load(grup?.imgTeam)
                        .into(this)
                }.lparams {
                    height = dip(70)
                    width = dip(70)
                    gravity = Gravity.CENTER
                    setMargins(0, dip(16), 0, 0)
                }

                //TEXTVIEW: Club Football name
                textView {
                    textSize = 16f
                    text = grup?.teamName
                    typeface = Typeface.DEFAULT_BOLD
                }.lparams {
                    gravity = Gravity.CENTER
                    setMargins(0, dip(5), 0, dip(10))
                }
            }

            //TEXTVIEW: Club Football Description
            textView {
                textSize = 16f
                text = grup?.teamDesc
            }.lparams {
                gravity = Gravity.CENTER
            }
        }

    }
}