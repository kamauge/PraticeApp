package com.regera.aad

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.regera.aad.data.User

class UserAdapter:RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var userList  = emptyList<User>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_user, parent, false))    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentItem = userList[position]

      //  holder.itemView.

    }

    override fun getItemCount(): Int {
      return userList.size
    }

    class UserViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    }

}