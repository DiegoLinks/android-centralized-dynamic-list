package com.android.cdlist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.cdlist.R
import com.android.cdlist.component.HorizontalCentralizedList
import com.android.cdlist.data.repository.medalList

class MainActivity : AppCompatActivity() {

    private lateinit var centralizedList: HorizontalCentralizedList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        centralizedList = findViewById(R.id.centralized_list)

        centralizedList.setItems(medalList)
    }
}