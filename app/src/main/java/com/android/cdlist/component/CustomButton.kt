package com.android.cdlist.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.android.cdlist.R

/** English - This class transforms the view built in item_menu_button into a component like
a TextView or an EditText, for example, which can be referenced in an XML layout
as <com.android.cdlist.component.CustomButton>. */

/** Português - Essa classe transforma a view construída em item_menu_button em um componente
    como um TextView ou um EditText por exemplo, que pode ser chamado em em uma classe XML
    como <com.android.cdlist.component.CustomButton. */
class CustomButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.item_menu_button, this, true)
    }
}