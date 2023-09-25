package com.android.cdlist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.cdlist.R
import com.android.cdlist.component.HorizontalCentralizedList
import com.android.cdlist.data.repository.getCardData
import com.android.cdlist.data.repository.medalList

class MainActivity : AppCompatActivity() {

    private lateinit var centralizedList: HorizontalCentralizedList
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        centralizedList = findViewById(R.id.centralized_list)

        centralizedList.setItems(medalList)

        //---//

        recyclerView = findViewById(R.id.recycler_view)

        val adapter = DescriptionAdapter(getCardData(this)) {
            val route = it.id
            navigate(route = route)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun navigate(route: Int) {
        //TODO navigate
    }
}