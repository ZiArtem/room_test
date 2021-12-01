package com.example.testselect1.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "password_table",  foreignKeys = [
    ForeignKey(entity = User::class,
        parentColumns = ["login"],
        childColumns = ["login_"],
        onDelete = ForeignKey.CASCADE
    )])
class Password (
    @PrimaryKey
    val login_: String,
    val password: String,
)