package io.backjeff.customviewexamples.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.backjeff.customviewexamples.R
import io.backjeff.customviewexamples.common.customview.ClickListener
import io.backjeff.customviewexamples.common.extension.toast
import kotlinx.android.synthetic.main.fragment_custom_radio_group.*

class CustomRadioGroupFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_custom_radio_group, container, false)
    }

    override fun setupView() {
        radioGroup.clickListener = object :
            ClickListener {
            override fun onClick(view: View?) {
                when(view?.id) {
                    R.id.radio1 -> toast("radio1")
                    R.id.radio2 -> toast("radio2")
                    R.id.radio3 -> toast("radio3")
                }
            }
        }
    }

}
