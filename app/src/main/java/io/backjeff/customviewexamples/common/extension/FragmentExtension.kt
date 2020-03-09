package io.backjeff.customviewexamples.common.extension

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import org.jetbrains.anko.toast

fun Fragment.toast(message: String) = requireContext().toast(message).show()
fun Fragment.getColor(@ColorRes colorId: Int) = ContextCompat.getColor(requireContext(), colorId)
fun Fragment.getDrawable(@ColorRes drawableId: Int) = ContextCompat.getColor(requireContext(), drawableId)
fun Fragment.getFont(fontId: Int) = ResourcesCompat.getFont(requireContext(), fontId)

fun Fragment.setToolbarTitle(title: String) {
    (context as? AppCompatActivity)?.title = title
}

fun Fragment.setNavigationIcon(id: Int?) {
    (activity as AppCompatActivity?)?.supportActionBar?.apply {
        id?.let { setHomeAsUpIndicator(it) }
        setDisplayHomeAsUpEnabled(id != null)
    }
    showActionBar()
}

fun Fragment.hideActionBar() = (activity as? AppCompatActivity)?.supportActionBar?.hide()

fun Fragment.showActionBar() = (activity as? AppCompatActivity)?.supportActionBar?.show()

fun Fragment.setToolbarLogo(@DrawableRes resId: Int?) {
    if (resId == null) {
        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayUseLogoEnabled(false)
    } else {
        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayUseLogoEnabled(true)
        (activity as? AppCompatActivity)?.supportActionBar?.setLogo(resId)
    }
}
