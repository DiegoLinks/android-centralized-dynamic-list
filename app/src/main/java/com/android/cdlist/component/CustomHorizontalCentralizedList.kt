package com.android.cdlist.component

import android.content.Context
import android.graphics.ColorFilter
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import coil.load
import com.android.cdlist.R
import com.android.cdlist.data.model.Item
import com.android.cdlist.ui.helper.gone
import com.android.cdlist.ui.helper.visible
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CustomHorizontalCentralizedList @JvmOverloads constructor(
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

        imageViews.forEach { it.gone() }

        for ((index, item) in items.withIndex()) {
            if (index >= imageViews.size) {
                break
            }
            val imageView = imageViews[index]
            configImage(item, imageView)
        }
    }

    private fun configImage(item: Item, view: AppCompatImageView) {
        val matrix = ColorMatrix()
        matrix.setSaturation(0F)
        val colorFilter = ColorMatrixColorFilter(matrix)

        if (item.isActive) {
            view.load(item.imageUrl)
        } else {
            view.colorFilter = colorFilter
            view.load(item.imageUrl)
        }

        view.visible()
    }

    //todo config imagem com Glide

    //todo config image com coil
}