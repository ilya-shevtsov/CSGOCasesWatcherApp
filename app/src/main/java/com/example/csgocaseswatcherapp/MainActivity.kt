package com.example.csgocaseswatcherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController


open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActionBarWithNavController(findNavController(R.id.fragment))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

//        if (savedInstanceState == null) {
//            changeFragment(fragment = CasePreviewFragment.newInstance())
//        }
//    }
//
//    open fun changeFragment(fragment: Fragment) {
//        val addToBackStack = supportFragmentManager.findFragmentById(R.id.fragmentContainer) != null
//        val transaction = supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.fragmentContainer, fragment)
//        if (addToBackStack) {
//            transaction.addToBackStack(fragment.javaClass.simpleName)
//        }
//        transaction.commit()
//    }
}