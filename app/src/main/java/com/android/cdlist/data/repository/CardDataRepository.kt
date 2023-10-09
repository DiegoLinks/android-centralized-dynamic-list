package com.android.cdlist.data.repository

import android.content.Context
import com.android.cdlist.R
import com.android.cdlist.data.model.DescriptionCardItem

fun getCardData(context: Context): List<DescriptionCardItem> {
    return listOf(
        DescriptionCardItem(
            id = 0,
            title = context.getString(R.string.horizontal_centralized_list_title),
            description = context.getString(R.string.horizontal_centralized_list_description)
        ),
        DescriptionCardItem(
            id = 1,
            title = context.getString(R.string.custom_horizontal_centralized_list_title),
            description = context.getString(R.string.custom_horizontal_centralized_list_description)
        ),
        DescriptionCardItem(
            id = 2,
            title = context.getString(R.string.bottom_navigation_centralized_list_title),
            description = context.getString(R.string.bottom_navigation_centralized_list_description)
        )
    )
}