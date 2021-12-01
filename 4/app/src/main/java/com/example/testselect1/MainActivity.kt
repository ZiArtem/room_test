package com.example.testselect1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.testselect1.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

lateinit var  but: Button
lateinit var  but1: Button
var  textTest:String = "dont work"
lateinit var db: UserDatabase
lateinit  var userDao:UserDao
lateinit  var pasDao:PasswordDao

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        but = findViewById(R.id.but)
        but1 = findViewById(R.id.button2)

        val db = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java, "user_table"
        ).fallbackToDestructiveMigration().build()

        userDao = db.userDao()
        pasDao = db.passwordDao()

        but.setOnClickListener{
            lifecycleScope.launch {
            signIn()}
        }

        but1.setOnClickListener{
            lifecycleScope.launch {
                spp()}
        }
    }

    private fun spp (){
        Toast.makeText(applicationContext, textTest, Toast.LENGTH_SHORT).show()
    }

    private suspend fun signIn (){
        val user1  = User("tema11","tema","zzz")
        val password1 = Password("tema11","ghj")

//        userDao.insertUser(user1)
//        pasDao.insertPassword(password1)

        Thread(Runnable {
            var pas = pasDao.getLogin("tema11","ghj")

            if (!pas.isEmpty()) {
                runOnUiThread {
                    Toast.makeText(applicationContext, "success!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                }
                val intent = Intent(this, NewActivity::class.java)
                startActivity(intent)
            } else {
                runOnUiThread {
                    textTest ="work"
                    Toast.makeText(applicationContext, "wrong user", Toast.LENGTH_SHORT).show()
                }
            }
        }).start()
    }



}