package com.android.cdlist.data.repository

import com.android.cdlist.data.model.ButtonItem
import com.android.cdlist.data.model.Item

val medalItem =
    Item(imageUrl = "https://cdn-icons-png.flaticon.com/512/3176/3176294.png", isActive = true)

val trophyItem =
    Item(imageUrl = "https://cdn-icons-png.flaticon.com/512/5987/5987898.png", isActive = true)

val trophyDisabledItem =
    Item(imageUrl = "https://cdn-icons-png.flaticon.com/512/5987/5987898.png", isActive = false)

val levelItem = Item(
    imageUrl = "https://static-00.iconduck.com/assets.00/green-square-emoji-512x512-rrh7w362.png",
    isActive = true
)

val levelDisabledItem = Item(
    imageUrl = "https://static-00.iconduck.com/assets.00/green-square-emoji-512x512-rrh7w362.png",
    isActive = false
)

val dropItem = Item(
    imageUrl = "https://cdn1.iconfinder.com/data/icons/smallicons-weather/32/drop-512.png",
    isActive = true
)

val dropDisabledItem = Item(
    imageUrl = "https://cdn1.iconfinder.com/data/icons/smallicons-weather/32/drop-512.png",
    isActive = false
)

val medalList = mutableListOf(medalItem, medalItem, medalItem, medalItem, medalItem)

val trophyList =
    mutableListOf(trophyItem, trophyItem, trophyItem, trophyDisabledItem, trophyDisabledItem)

val levelList =
    mutableListOf(levelItem, levelItem, levelItem, levelItem, levelDisabledItem, levelDisabledItem)

val dropList = mutableListOf(
    dropItem,
    dropItem,
    dropDisabledItem,
    dropDisabledItem,
    dropDisabledItem,
    dropDisabledItem
)

val simpleButton = ButtonItem(label = "Menu", showLabel = false, labelBottom = false)
val labelButton = ButtonItem(label = "Menu", showLabel = true, labelBottom = false)
val topLabelButton = ButtonItem(label = "Menu", showLabel = true, labelBottom = true)

val simpleButtonList =
    listOf(simpleButton, simpleButton, simpleButton, simpleButton, simpleButton, simpleButton)

val labelButtonList =
    listOf(labelButton, labelButton, labelButton, labelButton, labelButton)

val topLabelButtonList =
    listOf(topLabelButton, topLabelButton, topLabelButton, topLabelButton, topLabelButton)

val multipleButtonList =
    listOf(topLabelButton, labelButton, simpleButton, labelButton, topLabelButton)
