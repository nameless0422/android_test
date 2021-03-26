package com.example.testapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.card_item.view.*

class MyAdapter(private val context: Context, private val myModelArrayList: ArrayList<MyModel>) : PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return myModelArrayList.size //return list od records/items
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        //inflate layout card_item.xml
        val view = LayoutInflater.from(context).inflate(R.layout.card_item, container, false)

        //get data
        val model = myModelArrayList[position]
        val title = model.title
        val description = model.description
        val date = model.date
        val image = model.image

        //set data to ui views
        view.bannerIv.setImageResource(image)

        //handle item/card click
        view.setOnClickListener{
            Toast.makeText(context, "$title \n $description \n $date", Toast.LENGTH_SHORT).show()
        }

        //add view to container
        container.addView(view, position)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}