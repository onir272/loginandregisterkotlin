package com.example.loginapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_sign_in.setOnClickListener {
            val json=JSONObject()
            json.put("mail",et_mail.text.toString())
            json.put("password",et_password.text.toString())
            PostRequest(this,"signin",json){
                //if request success
                CompleteLogin()
            }
        }
        btn_sign_up.setOnClickListener {
            val json=JSONObject()
            json.put("mail",et_mail.text.toString())
            json.put("password",et_password.text.toString())
            PostRequest(this,"signup",json){
                //if request success
                CompleteSignup()
            }
        }



    }

    private fun CompleteSignup() {
        Toast.makeText(this,"Sign up Successful",Toast.LENGTH_LONG).show()
    }

    private fun CompleteLogin() {
        Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show()
    }
}
