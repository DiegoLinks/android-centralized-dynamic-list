package com.android.cdlist.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import com.android.cdlist.data.model.Item
import com.android.cdlist.R
import com.android.cdlist.ui.helper.visible
import com.bumptech.glide.Glide

class HorizontalCentralizedList @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.item_centralized_list, this, true)
    }

    fun setItems(items: List<Item>) {
        val imageViews = mutableListOf<AppCompatImageView>(
            findViewById(R.id.iv_item_1),
            findViewById(R.id.iv_item_2),
            findViewById(R.id.iv_item_3),
            findViewById(R.id.iv_item_4),
            findViewById(R.id.iv_item_5),
            findViewById(R.id.iv_item_6)
        )

        for ((index, item) in items.withIndex()) {
            if (index >= imageViews.size) {
                break
            }
            val imageView = imageViews[index]
            Glide.with(context).load(item.imageUrl).into(imageView)
            imageView.visible()
        }
    }
}