package io.backjeff.customviewexamples.customview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.forEach

class CustomRadioGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    var clickListener: ClickListener? = null
    var selectedId: Int = 0
        set(value) {
            try {
                val child = findViewById<CustomRadioButton>(value)
                require(child is CustomRadioButton)
                field = value
                setAllButtonsToUnselectedState()
                setSelectedButtonToSelectedState(child)
                handleClick(child)
            } catch(e: Throwable) {}
        }

    override fun addView(child: View?, params: ViewGroup.LayoutParams?) {
        if (child is CustomRadioButton) {
            child.setOnClickListener {
                selectedId = child.id
            }
        }
        super.addView(child, params)
    }

    private fun setAllButtonsToUnselectedState() {
        forEach { child ->
            if (child is CustomRadioButton) setButtonToUnselectedState(child)
        }
    }

    private fun setButtonToUnselectedState(customRadioButton: CustomRadioButton) {
        customRadioButton.alpha = 0.5f
    }

    private fun setSelectedButtonToSelectedState(customRadioButton: CustomRadioButton) {
        customRadioButton.alpha = 1f
    }

    private fun handleClick(selectedButton: View) {
        clickListener?.run {
            onClick(selectedButton)
        }
    }

}
