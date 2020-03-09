package io.backjeff.customviewexamples.common.customview

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout

abstract class BaseCustomView @JvmOverloads constructor(
    context: Context,
    val attrs: AttributeSet? = null,
    val defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

}