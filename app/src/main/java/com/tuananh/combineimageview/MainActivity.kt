package com.tuananh.combineimageview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listUrl: MutableList<String> = arrayListOf()
        listUrl.add("https://whytlink-resources-dev.s3.amazonaws.com/uploads/doctor/avatar_image/127776_1515467441_127776_ce1515467440.9675.png")
        imageAvatar.setListImage(listUrl)
    }
}
