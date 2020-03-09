package io.backjeff.customviewexamples.ui.fragment

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.backjeff.customviewexamples.R
import io.backjeff.customviewexamples.common.extension.setNavigationIcon
import org.jetbrains.anko.findOptional

abstract class BaseFragment : Fragment() {

    private var toolbar: Toolbar? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar(view)
        setupView()
    }

    open fun setupView() {}

    private fun setupToolbar(view: View) {
        toolbar = view.findOptional<Toolbar>(R.id.appToolbar)?.also {
            (requireActivity() as? AppCompatActivity)?.apply {
                setSupportActionBar(it)
                setupActionBarWithNavController(view.findNavController())
                setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> try {
                findNavController().popBackStack()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }

}
