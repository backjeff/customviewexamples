package io.backjeff.customviewexamples

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.backjeff.customviewexamples.R
import io.backjeff.customviewexamples.customview.ClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    private fun setupView() {
        radioGroup.clickListener = object :
            ClickListener {
            override fun onClick(view: View?) {
                when(view?.id) {
                    R.id.radio1 -> Log.i("customview", "radio1")
                    R.id.radio2 -> Log.i("customview", "radio2")
                    R.id.radio3 -> Log.i("customview", "radio3")
                }
            }
        }
    }

}
