package com.mse.codechallenge

import android.view.View
import android.widget.ImageView
import android.widget.TextView

class CustomViewHolder(mView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(mView) {
    var name: TextView
    var userImage: ImageView
    var email: TextView
    var phone: TextView
    var view = mView

    init {
        name = mView.findViewById(R.id.name)
        userImage = mView.findViewById(R.id.userPhoto)
        email = mView.findViewById(R.id.email)
        phone = mView.findViewById(R.id.phone)
    }
}