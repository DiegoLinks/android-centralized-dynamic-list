package com.android.cdlist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.cdlist.DescriptionAdapter
import com.android.cdlist.R
import com.android.cdlist.component.HorizontalCentralizedList
import com.android.cdlist.data.model.DescriptionCardItem
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

        val adapter = DescriptionAdapter(getOptions()) {
            val route = it.id
            navigate(route = route)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun getOptions(): List<DescriptionCardItem> {
        return listOf(
            DescriptionCardItem(
                id = 0,
                title = getString(R.string.horizontal_centralized_list_title),
                description = getString(R.string.horizontal_centralized_list_description)
            ),
            DescriptionCardItem(
                id = 0,
                title = getString(R.string.horizontal_centralized_list_title),
                description = getString(R.string.horizontal_centralized_list_description)
            ),
            DescriptionCardItem(
                id = 0,
                title = getString(R.string.horizontal_centralized_list_title),
                description = getString(R.string.horizontal_centralized_list_description)
            )
        )
    }

    private fun navigate(route: Int) {
        //TODO navigate
    }
}