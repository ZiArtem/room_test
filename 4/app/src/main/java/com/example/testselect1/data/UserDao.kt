package com.example.testselect1.data

import androidx.room.*


@Dao
interface UserDao {
    @Query("SELECT * FROM user_table")
    fun getAll(): List<User>

    @Query("SELECT * FROM user_table WHERE firstName=(:login) and lastName=(:password)")
    fun getUser(login:String,password:String):List<User>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: User)

    @Delete
    fun delete(user: User)
}


