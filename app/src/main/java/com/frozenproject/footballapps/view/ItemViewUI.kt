package com.frozenproject.footballapps.view

import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.frozenproject.footballapps.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class ItemViewUI : AnkoComponent<ViewGroup> {

    //initial id for showing items in recyclerview
    companion object {
        val tv_item = 1
        val img_item = 2
    }
    //Implementation Anko Layout
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {

        verticalLayout {
            lparams(width = matchParent, height = wrapContent)

            cardView {
                id = R.id.cv_football
                //Adding cardview style with ripple effect
                background = ContextCompat.getDrawable(context, R.drawable.selector)

                verticalLayout {
                    orientation = LinearLayout.HORIZONTAL
                    padding = dip(16)
                    lparams(width = matchParent, height = wrapContent)

                    //IMAGEVIEW declaration
                    imageView {
                        id = img_item
                    }.lparams {
                        width = dip(55)
                        height = dip(55)
                        marginEnd = dip(16)
                    }

                    //TEXTVIEW declaration
                    textView {
                        id = tv_item
                        textSize = 16f
                        typeface = Typeface.DEFAULT_BOLD
                    }.lparams {
                        gravity = Gravity.CENTER_VERTICAL
                        width = matchParent
                        height = wrapContent
                    }

                }
                //PARAMETER cardview
            }.lparams(width = matchParent, height = matchParent) {
                margin = dip(5)
            }
        }
    }

}