package com.android.cdlist.component

import android.content.Context
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
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.GrayscaleTransformation

class CustomHorizontalCentralizedList @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.item_centralized_list, this, true)
    }

    private val imageViews = mutableListOf<AppCompatImageView>(
        findViewById(R.id.iv_item_1),
        findViewById(R.id.iv_item_2),
        findViewById(R.id.iv_item_3),
        findViewById(R.id.iv_item_4),
        findViewById(R.id.iv_item_5),
        findViewById(R.id.iv_item_6)
    )

    fun setItemsWithCoilBlackAndWithe(items: List<Item>) {
        imageViews.forEach { it.gone() }

        for ((index, item) in items.withIndex()) {
            if (index >= imageViews.size) {
                break
            }
            val imageView = imageViews[index]
            configImageWithCoilBlackAndWithe(item, imageView)
        }
    }

    private fun configImageWithCoilBlackAndWithe(item: Item, view: AppCompatImageView) {
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

    fun setItemsWithGlideBlackAndWithe(items: List<Item>) {
        imageViews.forEach { it.gone() }

        for ((index, item) in items.withIndex()) {
            if (index >= imageViews.size) {
                break
            }
            val imageView = imageViews[index]
            configImageGlideBlackAndWithe(item, imageView)
        }
    }

    private fun configImageGlideBlackAndWithe(item: Item, view: AppCompatImageView) {
        if (item.isActive) {
            Glide.with(context).load(item.imageUrl).into(view)
        } else {
            Glide.with(context)
                .load(item.imageUrl)
                .apply(RequestOptions.bitmapTransform(GrayscaleTransformation()))
                .into(view)
        }

        view.visible()
    }

    fun setItemsWithGlideBlur(items: List<Item>) {
        imageViews.forEach { it.gone() }

        for ((index, item) in items.withIndex()) {
            if (index >= imageViews.size) {
                break
            }
            val imageView = imageViews[index]
            configImageWithGlideBlur(item, imageView)
        }
    }

    private fun configImageWithGlideBlur(item: Item, view: AppCompatImageView) {
        if (item.isActive) {
            Glide.with(context).load(item.imageUrl).into(view)
        } else {
            Glide.with(context)
                .load(item.imageUrl)
                .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 3)))
                .into(view)
        }

        view.visible()
    }
}