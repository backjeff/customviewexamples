package io.backjeff.customviewexamples.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.backjeff.customviewexamples.R
import io.backjeff.customviewexamples.common.extension.setNavigationIcon
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun setupView() {
        setNavigationIcon(null)
        button1.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.button1 -> findNavController().navigate(R.id.customRadioGroupFragment)
        }
    }

}
