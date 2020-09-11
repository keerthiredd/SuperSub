package com.example.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import okhttp3.*
import java.io.IOException

class ExerciseActivity : Activity() {
    private val client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise2)
        run("http://ec2-3-231-125-209.compute-1.amazonaws.com:8081/exercise/5f43ea90fe137dc694c30d69")
    }

    private fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) = println(response.body()?.string())
        })
    }
}
