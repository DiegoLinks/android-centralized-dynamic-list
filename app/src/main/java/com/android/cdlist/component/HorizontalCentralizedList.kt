package com.android.cdlist.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import coil.load
import com.android.cdlist.data.model.Item
import com.android.cdlist.R
import com.android.cdlist.ui.helper.gone
import com.android.cdlist.ui.helper.visible

class HorizontalCentralizedList @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.item_centralized_list, this, true)
    }

    fun setItems(items: List<Item>) {
        /**
         * English - Creates a list with views of the item_centralized_list. If you change the view type, it is
         * necessary to update the list type to mutableListOf<TypeOfViewUsed>.
         *
         * Português - Cria uma lista com as views de item_centralized_list, caso troque o tipo de view é necessário
         * trocar o tipo da lista mutableListOf<TipoDaViewQueUsar>.
         */
        val imageViews = mutableListOf<AppCompatImageView>(
            findViewById(R.id.iv_item_1),
            findViewById(R.id.iv_item_2),
            findViewById(R.id.iv_item_3),
            findViewById(R.id.iv_item_4),
            findViewById(R.id.iv_item_5),
            findViewById(R.id.iv_item_6)
        )

        /**
         * English - Hides all views to display a new list based on the received list.
         *
         * Português - Faz com que todas as views sejam escondidas, para exibir uma nova lista de acordo com a lista recebida.
         */
        imageViews.forEach { it.gone() }

        /**
         * English - Iterates through the list of items and assembles the list according to the properties of each item.
         * Uses Coil to load URLs.
         * Makes visible only the quantity of items from the received list.
         *
         * Português - Passa pela lista de itens e monta a lista de acordo com as propriedades de cada item.
         * Usa Coil para carregar as urls.
         * Torna visível apenas a quantidade de itens da lista recebida.
         */
        for ((index, item) in items.withIndex()) {
            if (index >= imageViews.size) {
                break
            }
            val imageView = imageViews[index]
            imageView.load(item.imageUrl)
            imageView.visible()
        }
    }
}