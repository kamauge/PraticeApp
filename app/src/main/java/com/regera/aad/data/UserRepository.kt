package com.regera.aad.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readUserData : LiveData<List<User>> = userDao.readUsers()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}