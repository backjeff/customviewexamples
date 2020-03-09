package io.backjeff.customviewexamples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.backjeff.customviewexamples.R
import io.backjeff.customviewexamples.common.extension.safeNavigateUp

class AppActivity : AppCompatActivity() {

    private val navController by lazy { findNavController(R.id.fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSupportNavigateUp() = navController.safeNavigateUp()

}
