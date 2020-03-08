package io.backjeff.customviewexamples.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import com.backjeff.customviewexamples.R

class CustomRadioButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : BaseCustomView(context, attrs, defStyle) {

    private val titleTextView: TextView
    private val descriptionTextView: TextView

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.custom_radio_button, this, true).run {
                titleTextView = findViewById(R.id.title)
                descriptionTextView = findViewById(R.id.description)
            }
        setupStyleable()
    }

    private fun setupStyleable() {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.BaseCustomView,
            defStyle,
            0
        ).apply {
            try {

                getString(R.styleable.BaseCustomView_title).also {
                    titleTextView.text = it
                }

                getString(R.styleable.BaseCustomView_description).also {
                    descriptionTextView.text = it
                }

            } finally {
                recycle()
            }
        }

    }

}
