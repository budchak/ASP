package com.yaroshevich.podacha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yaroshevich.podacha.fragments.SessionFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, SessionFragment()).commit()
    }
}
