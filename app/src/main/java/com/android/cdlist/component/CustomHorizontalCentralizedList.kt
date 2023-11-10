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

/**
 * English - The idea behind this component is precisely to customize the use of components according to needs.
 * Here you will find examples of customization that can be useful or help to think of new solutions.
 *
 * Português - A ideia desse componente é justamente poder customizar o uso dos componentes de acordo com as necessidades,
 * aqui você vai encontrar exemplos de personalização que podem ser úteis ou ajudar a pensar em novas soluções.
 */
class CustomHorizontalCentralizedList @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.item_centralized_list, this, true)
    }

    /**
     * English - Creates a list with views of the item_centralized_list. If you change the view type, it is
     * necessary to update the list type to mutableListOf<TypeOfViewUsed>.
     *
     * Português - Cria uma lista com as views de item_centralized_list, caso troque o tipo de view é necessário
     * trocar o tipo da lista mutableListOf<TipoDaViewQueUsar>.
     */
    private val imageViews = mutableListOf<AppCompatImageView>(
        findViewById(R.id.iv_item_1),
        findViewById(R.id.iv_item_2),
        findViewById(R.id.iv_item_3),
        findViewById(R.id.iv_item_4),
        findViewById(R.id.iv_item_5),
        findViewById(R.id.iv_item_6)
    )

    fun setItemsWithCoilBlackAndWithe(items: List<Item>) {
        /**
         * English - Hides all views to display a new list based on the received list.
         *
         * Português - Faz com que todas as views sejam escondidas, para exibir uma nova lista de acordo com a lista recebida.
         */
        imageViews.forEach { it.gone() }

        for ((index, item) in items.withIndex()) {
            if (index >= imageViews.size) {
                break
            }
            val imageView = imageViews[index]
            configImageWithCoilBlackAndWithe(item, imageView)
        }
    }

    /**
     * English - Goes through the list of items and assembles the list according to the properties of each item,
     * in this method, the image is either in color or black and white.
     * Uses Coil to load the URLs.
     * Makes visible only the quantity of items from the received list.
     *
     * Português - Passa pela lista de itens e monta a lista de acordo com as propriedades de cada item,
     * nesse método imagem em cores ou preta e branca.
     * Usa Coil para carregar as urls.
     * Torna visível apenas a quantidade de itens da lista recebida.
     */
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
        /**
         * English - Hides all views to display a new list based on the received list.
         *
         * Português - Faz com que todas as views sejam escondidas, para exibir uma nova lista de acordo com a lista recebida.
         */
        imageViews.forEach { it.gone() }

        for ((index, item) in items.withIndex()) {
            if (index >= imageViews.size) {
                break
            }
            val imageView = imageViews[index]
            configImageGlideBlackAndWithe(item, imageView)
        }
    }

    /**
     * English - Goes through the list of items and assembles the list according to the properties of each item,
     * in this method, the image is either in color or black and white.
     * Uses Glide to load the URLs and also to modify the images.
     * Makes visible only the quantity of items from the received list.
     *
     * Português - Passa pela lista de itens e monta a lista de acordo com as propriedades de cada item,
     * nesse método imagem em cores ou preta e branca.
     * Usa Glide para carregar as urls e também para modificar as imagens.
     * Torna visível apenas a quantidade de itens da lista recebida.
     */
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
        /**
         * English - Hides all views to display a new list based on the received list.
         *
         * Português - Faz com que todas as views sejam escondidas, para exibir uma nova lista de acordo com a lista recebida.
         */
        imageViews.forEach { it.gone() }

        for ((index, item) in items.withIndex()) {
            if (index >= imageViews.size) {
                break
            }
            val imageView = imageViews[index]
            configImageWithGlideBlur(item, imageView)
        }
    }

    /**
     * English - Goes through the list of items and assembles the list according to the properties of each item,
     * in this method, the image is either normal or blurred.
     * Uses Glide to load the URLs and also to modify the images.
     * Makes visible only the quantity of items from the received list.
     *
     * Português - Passa pela lista de itens e monta a lista de acordo com as propriedades de cada item,
     * nesse método imagem normal ou borrada.
     * Usa Glide para carregar as urls e também para modificar as imagens.
     * Torna visível apenas a quantidade de itens da lista recebida.
     */
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