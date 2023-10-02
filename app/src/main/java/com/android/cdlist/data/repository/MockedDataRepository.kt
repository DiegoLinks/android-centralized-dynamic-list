package com.android.cdlist.data.repository

import com.android.cdlist.data.model.Item

val medalItem =
    Item(imageUrl = "https://cdn-icons-png.flaticon.com/512/3176/3176294.png", isActive = true)

val trophyItem =
    Item(imageUrl = "https://cdn-icons-png.flaticon.com/512/5987/5987898.png", isActive = true)

val trophyDisabledItem =
    Item(imageUrl = "https://cdn-icons-png.flaticon.com/512/5987/5987898.png", isActive = false)

val levelItem =
    Item(
        imageUrl = "https://static-00.iconduck.com/assets.00/green-square-emoji-512x512-rrh7w362.png",
        isActive = true
    )

val levelDisabledItem =
    Item(
        imageUrl = "https://static-00.iconduck.com/assets.00/green-square-emoji-512x512-rrh7w362.png",
        isActive = false
    )

val medalList = mutableListOf(medalItem, medalItem, medalItem, medalItem, medalItem)

val trophyList =
    mutableListOf(trophyItem, trophyItem, trophyItem, trophyDisabledItem, trophyDisabledItem)

val levelList =
    mutableListOf(levelItem, levelItem, levelItem, levelItem, levelDisabledItem, levelDisabledItem)


