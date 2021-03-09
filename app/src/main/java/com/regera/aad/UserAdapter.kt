package com.regera.aad

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.regera.aad.data.User
import com.regera.aad.databinding.CustomUserBinding
import com.regera.aad.databinding.FragmentListUsersBinding

class UserAdapter:RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var userList  = emptyList<User>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        return UserViewHolder(CustomUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentItem = userList[position]

        holder.binding.idTxt.text = currentItem.id.toString()
        holder.binding.firstNameTxt.text = currentItem.firstName
        holder.binding.lastNameTxt.text = currentItem.lastName
        holder.binding.ageTxt.text = currentItem.age.toString()


    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
      return userList.size
    }

    class UserViewHolder(val binding : CustomUserBinding) : RecyclerView.ViewHolder(binding.root)



}