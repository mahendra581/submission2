package com.bangkit.submission2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.bangkit.submission2.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.apply {
            title = getString(R.string.detail_name)
        }
        val data = intent.getParcelableExtra<Disease>("DATA")
        val photo = data?.photo
        val name = data?.name
        val description = data?.description
        val datacause = data?.cause

        Glide.with(this@DetailActivity)
            .load(photo)
            .into(binding.rvImage)
        binding.tvName.text = name
        binding.tvDescription.text = description
        binding.tvCause.text = datacause

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_share,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.action_share -> {
                val urlLink = Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=081226390964"))
                startActivity(urlLink);
            }
        }
        return super.onOptionsItemSelected(item)
    }
}