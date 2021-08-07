package com.example.aes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submit =  findViewById<Button>(R.id.submit)

        submit.setOnClickListener {
            val input = findViewById<EditText>(R.id.input)

            val encrypt = findViewById<TextView>(R.id.encrypt)

            val decrypt = findViewById<TextView>(R.id.decrypt)

            val plainText  = input.text.toString()
            val aesEncrypt = AESEncrypt()
            val cipherText = aesEncrypt.encrypt(plainText)


            encrypt.setText(String(cipherText))

            val aesDecrypt = AESDecrypt(aesEncrypt.mySecretKey, aesEncrypt.myInitializationVector)

            val decryptCipherText = aesDecrypt.decrypt(cipherText)


            decrypt.setText(String(decryptCipherText));


        }
    }

}