package com.mse.codechallenge

import android.Manifest.permission.CALL_PHONE
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

class Fragment1 : Fragment() {
    var phoneTxtView: TextView? = null
    var emailTxtView: TextView? = null
    var phoneButton :ImageButton? = null
    var emailButton :ImageButton? = null

    var email: String? = null
    var phone: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fragment1, container, false)

        phoneTxtView = view.findViewById(R.id.phone)
        emailTxtView = view.findViewById(R.id.email)
        phoneButton = view.findViewById(R.id.phoneButton)
        emailButton = view.findViewById(R.id.emailButton)

        phoneTxtView?.setText(phone)
        emailTxtView?.setText(email)

        phoneButton?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val callIntent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone))
                //callIntent?.setData(Uri.parse("tel:"+phone));
                if (ContextCompat.checkSelfPermission(activity as UserInfoActivity, CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(callIntent)
                } else {
                    requestPermissions( arrayOf(CALL_PHONE), 1)
                }
            }
        })

        emailButton?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val callIntent = Intent(Intent.ACTION_SEND)
                callIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                callIntent.setType("message/rfc822")
                startActivity(callIntent)
            }
        })
        return view
    }
}
