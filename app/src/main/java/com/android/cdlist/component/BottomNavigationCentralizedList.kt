package com.android.cdlist.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.android.cdlist.R
import com.android.cdlist.data.model.ButtonItem
import com.android.cdlist.ui.helper.gone
import com.android.cdlist.ui.helper.visible

class BottomNavigationCentralizedList @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.item_centralized_bottom_menu, this, true)
    }

    /**
     * English - Creates a list with views of the item_centralized_bottom_menu. If you change the view type, it is
     * necessary to update the list type to mutableListOf<TypeOfViewUsed>.
     *
     * Português - Cria uma lista com as views de item_centralized_bottom_menu, caso troque o tipo de view é necessário
     * trocar o tipo da lista mutableListOf<TipoDaViewQueUsar>.
     */
    private val buttonList = mutableListOf<CustomButton>(
        findViewById(R.id.bt_1),
        findViewById(R.id.bt_2),
        findViewById(R.id.bt_3),
        findViewById(R.id.bt_4),
        findViewById(R.id.bt_5),
        findViewById(R.id.bt_6)
    )

    fun setButtons(items: List<ButtonItem>) {
        /**
         * English - Hides all views to display a new list based on the received list.
         *
         * Português - Faz com que todas as views sejam escondidas, para exibir uma nova lista de acordo com a lista recebida.
         */
        buttonList.forEach { it.gone() }

        for ((index, item) in items.withIndex()) {
            if (index >= buttonList.size) {
                break
            }
            val button = buttonList[index]
            configButton(item = item, view = button)
        }
    }

    /**
     * English - Iterates through the list of items and assembles the list according to the properties of each item.
     * Makes visible only the quantity of items from the received list.
     *
     * Português - Passa pela lista de itens e monta a lista de acordo com as propriedades de cada item.
     * Torna visível apenas a quantidade de itens da lista recebida.
     */
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