package com.example.csgocaseswatcherapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.csgocaseswatcherapp.R

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_container)

        if (savedInstanceState == null) {
            changeFragment(fragment = CasePreviewFragment.newInstance())
        }
    }

    open fun changeFragment(fragment: Fragment) {
        val addToBackStack = supportFragmentManager.findFragmentById(R.id.fragmentContainer) != null
        val transaction = supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(fragment.javaClass.simpleName)
        }
        transaction.commit()
    }
}