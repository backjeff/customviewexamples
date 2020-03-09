package io.backjeff.customviewexamples.common.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import com.backjeff.customviewexamples.R

class MainMenuButton @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyle: Int = 0
): BaseCustomView(context, attr, defStyle) {

    private val titleTextView: TextView
    private val descriptionTextView: TextView

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.main_menu_button, this, true).run {
                titleTextView = findViewById(R.id.title)
                descriptionTextView = findViewById(R.id.description)
            }
        setupStyleable()
    }

    private fun setupStyleable() {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.MainMenuButton,
            defStyle,
            0
        ).apply {
            try {

                getString(R.styleable.MainMenuButton_title).also {
                    titleTextView.text = it
                }

                getString(R.styleable.MainMenuButton_description).also {
                    descriptionTextView.text = it
                }

            } finally {
                recycle()
            }
        }

    }

}