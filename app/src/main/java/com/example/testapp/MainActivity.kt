
package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //actionbar
    private lateinit var actionBar: ActionBar

    private lateinit var myModelList:ArrayList<MyModel>
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init actionbar
        actionBar = this.supportActionBar!!

        loadCards()

        //add page change listener
        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                //change title of actionbar
                val title = myModelList[position].title
                actionBar.title  = title
            }

            override fun onPageSelected(position: Int) {

            }
        })
        val bottomSheetFragment = BottomSheetFragment()
        bottomSheetFragment.show(supportFragmentManager,"bottomsheet_fragment")
    }

    private fun loadCards(){
        //init list
        myModelList = ArrayList()

        //add item/data to list
        myModelList.add(
            MyModel(
            "Android Marshmallow",
            "Description",
            "October 5, 2015",
            R.drawable.schedule)
        )

        myModelList.add(
            MyModel(
                "어쩌고 저쩌고",
                "Description",
                "October 5, 2015",
                R.drawable.schedule)
        )

        myModelList.add(
            MyModel(
                "Android어쩌저저ow",
                "Description",
                "October 5, 2015",
                R.drawable.schedule)
        )

        myModelList.add(
            MyModel(
                "Android Marshmallow",
                "Des그냥대강ion",
                "October 5, 2015",
                R.drawable.schedule)
        )

        //setup adapter
        myAdapter = MyAdapter(this, myModelList)

        //set adapter to viewpager
        viewPager.adapter = myAdapter

        //set default padding
        viewPager.setPadding(100,0,100,0)
    }


}