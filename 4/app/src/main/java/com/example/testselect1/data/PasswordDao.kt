package com.example.testselect1.data
import androidx.room.*

@Dao
interface PasswordDao {
    @Query("SELECT * FROM password_table")
    fun getAllPassword(): List<Password>

    @Query("SELECT * FROM password_table WHERE login_=(:login) and password=(:password)")
    fun getLogin(login:String,password:String):List<Password>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPassword(pas: Password)

    @Delete
    fun delete(pas: Password)
}