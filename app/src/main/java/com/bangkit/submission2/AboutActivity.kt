package com.bangkit.submission2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class AboutActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        supportActionBar?.title = "DISEASE APP"

        val btnURL: Button = findViewById(R.id.btn_more)
        btnURL.setOnClickListener(this)

        supportActionBar?.apply {
            title = getString(R.string.detail_about)
        }
    }
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_more -> {
                val urlLink = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/mahendraadir/"))
                startActivity(urlLink);
            }
        }
    }
}