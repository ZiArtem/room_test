package com.example.testselect1.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
class User (
    @PrimaryKey
    val login:String,
    val firstName: String,
    val lastName: String
    )

