package com.mse.codechallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class UserInfoActivity : AppCompatActivity() {
    var name: String? = null
    var email: String? = null
    var phone: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)
        val extras = intent.extras
        if (extras != null) {
            name = extras.getString("name")
            email = extras.getString("email")
            phone = extras.getString("phone")
        }
        setTitle(name)

        val myFragment = Fragment1()
        myFragment.phone = this.phone
        myFragment.email = this.email

        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragments, myFragment)
        ft.commit()
    }
}
