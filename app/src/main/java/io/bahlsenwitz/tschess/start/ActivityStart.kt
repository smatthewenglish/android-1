package io.bahlsenwitz.tschess.start

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.bahlsenwitz.tschess.R
import android.widget.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import io.bahlsenwitz.tschess.util.ServerAddress

class ActivityStart : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        // get reference to all views
        var et_user_name = findViewById<EditText>(R.id.et_user_name)
        var et_password = findViewById<EditText>(R.id.et_password)
        var btn_reset = findViewById<Button>(R.id.btn_reset)
        var btn_submit = findViewById<Button>(R.id.btn_submit)

        btn_reset.setOnClickListener {
            // clearing user_name and password edit text views on reset button click
            et_user_name.setText("")
            et_password.setText("")
        }

        // set on-click listener
        btn_submit.setOnClickListener {
            val user_name = et_user_name.text;
            val password = et_password.text;
            Toast.makeText(this@ActivityStart, user_name, Toast.LENGTH_LONG).show()

            // your code to validate the user_name and password combination
            // and verify the same

            // Instantiate the RequestQueue.
            val queue = Volley.newRequestQueue(this)
            val url = ServerAddress().IP

            // Request a string response from the provided URL.
            val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    // Display the first 500 characters of the response string.
                    textView.text = "Response is: ${response.substring(0, 500)}"
                },
                Response.ErrorListener { textView.text = "That didn't work!" })

            // Add the request to the RequestQueue.
            queue.add(stringRequest)


        }
    }


}
