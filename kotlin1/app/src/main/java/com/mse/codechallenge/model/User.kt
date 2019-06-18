package com.mse.codechallenge.model
import com.google.gson.annotations.SerializedName

class User (id: Int, name: String, username:String, email: String, phone:String, website:String) {

    @SerializedName("id")
    var id = id

    @SerializedName("name")
    var name = name

    @SerializedName("username")
    var username = username

    @SerializedName("email")
    var email =  email

    @SerializedName("phone")
    var phone = phone

    @SerializedName("website")
    var website = website
}