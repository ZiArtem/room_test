package com.example.testselect1.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class, Password::class], version = 2)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun passwordDao():PasswordDao
}

