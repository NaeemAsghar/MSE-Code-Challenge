package com.mse.codechallenge

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mse.codechallenge.model.User

class RecyclerViewCustomAdapter (private val context: Context, private val dataList: List<User>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.row_card_view, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, index: Int) {
        holder.view.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {

                /*Could use Parcelable here for a complete object.
                  In this case we are passing though some simple strings to our next activity
                */
                val intent = Intent(context, UserInfoActivity::class.java)
                intent.putExtra("name", dataList[index].name)
                intent.putExtra("phone", dataList[index].phone)
                intent.putExtra("email", dataList[index].email)

                context.startActivity(intent)
            }
        })

        holder.name.setText(dataList[index].name)
        holder.email.setText(dataList[index].email)
        holder.phone.setText(dataList[index].phone)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}