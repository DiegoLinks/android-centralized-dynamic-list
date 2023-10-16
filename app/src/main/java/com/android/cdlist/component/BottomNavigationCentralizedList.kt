package com.android.cdlist.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.android.cdlist.R
import com.android.cdlist.data.model.ButtonItem
import com.android.cdlist.data.model.Item
import com.android.cdlist.ui.helper.gone
import com.android.cdlist.ui.helper.visible
import com.bumptech.glide.Glide

class BottomNavigationCentralizedList @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.item_centralized_bottom_menu, this, true)
    }

    private val buttonList = mutableListOf<CustomButton>(
        findViewById(R.id.bt_1),
        findViewById(R.id.bt_2),
        findViewById(R.id.bt_3),
        findViewById(R.id.bt_4),
        findViewById(R.id.bt_5),
        findViewById(R.id.bt_6)
    )

    fun setButtons(items: List<ButtonItem>) {
        buttonList.forEach { it.gone() }

        for ((index, item) in items.withIndex()) {
            if (index >= buttonList.size) {
                break
            }
            val button = buttonList[index]
            configButton(item = item, view = button)
        }
    }

    private fun configButton(item: ButtonItem, view: CustomButton) {
        val tvLabel = view.findViewById<TextView>(R.id.tv_menu_top)
        val tvBottomLabel = view.findViewById<TextView>(R.id.tv_menu_bottom)

        tvLabel.text = item.label
        tvBottomLabel.text = item.label

        if (item.showLabel && item.labelBottom) {
            tvLabel.gone()
            tvBottomLabel.visible()
        } else if (item.showLabel) {
            tvLabel.visible()
            tvBottomLabel.gone()
        } else {
            tvLabel.gone()
            tvBottomLabel.gone()
        }

        view.visible()
    }
}