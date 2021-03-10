package com.regera.aad.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readUserData : LiveData<List<User>> = userDao.readUsers()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }

    suspend fun deleteAllUsers(){
        userDao.deleteAllUsers()
    }
}