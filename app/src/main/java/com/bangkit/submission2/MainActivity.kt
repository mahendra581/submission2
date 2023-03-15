package com.bangkit.submission2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.submission2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvDisease: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Disease>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        binding.rvContent.layoutManager = layoutManager

        rvDisease = findViewById(R.id.rv_content)
        binding.rvContent.setHasFixedSize(true)

        list.addAll(getListDisease())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val i = Intent(this, AboutActivity::class.java)
                startActivity(i)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

   private fun getListDisease(): ArrayList<Disease> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataDate = resources.getStringArray(R.array.data_date)
        val dataCause = resources.getStringArray(R.array.data_cause)
        val list = ArrayList<Disease>()
        for (i in dataName.indices) {
            val case = Disease(dataName[i], dataDescription[i], dataPhoto[i], dataDate[i], dataCause[i])
            list.add(case)
        }
        return list
    }

    private fun showRecyclerList() {
        rvDisease.layoutManager = LinearLayoutManager(this)
        val listDiseaseAdapter = ListDisease(list)
        rvDisease.adapter = listDiseaseAdapter
//        listHeroAdapter.setOnItemClickCallback(object : ListDisease.OnItemClickCallback {
//            override fun onItemClicked(data: Disease) {
//                showSelected(data)
//            }
//        })
    }
//    private fun showSelected(case: Disease) {
////        binding.rvContent.adapter = ListDisease(adapter.listStory)
//    }

}