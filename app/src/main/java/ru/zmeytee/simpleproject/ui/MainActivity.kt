package ru.zmeytee.simpleproject.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.zmeytee.simpleproject.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

    }

    override fun onBackPressed() {
//        super.onBackPressed()
        val previousBackStackEntry = findNavController(R.id.navHostFragment).previousBackStackEntry

        if (previousBackStackEntry == null) {
            finish()
        } else {
            findNavController(R.id.navHostFragment).navigateUp()
        }
    }
}