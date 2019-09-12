package com.main.lynkbrave

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.main.lynkbrave.R.layout.activity_login
import kotlinx.android.synthetic.main.activity_login.*
import java.util.regex.Pattern

class LoginActivity: AppCompatActivity() {

    private var EMAIL_PATTERN =
        "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(activity_login)

        login_button.setOnClickListener {
            if(isValid()){
                loading(true)

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun isValid(): Boolean {
        val email = txtEmail.getText().toString()
        if(!validateEmail(email)) {
            txtEmail.setError("Please enter valid email address.")
        } else if(txtEmail?.text.toString().isEmpty()) {
            text_view_email.setError("Please enter email address.")
        }
        if(txtPassword?.text.toString().isEmpty()) return false
        return true
    }

    private fun loading(value: Boolean) {
        if(value) progressBar.visibility = View.VISIBLE
        else progressBar.visibility = View.GONE

        if(!value){
            txtEmail.text.clear()
            txtPassword.text.clear()
        }

        if(!value) login_layout_form.visibility = View.VISIBLE
        else login_layout_form.visibility = View.GONE
    }

    fun validateEmail(email: String): Boolean {
        val p = Pattern.compile(EMAIL_PATTERN)
        val m = p.matcher(email)
        return m.matches()
    }
}