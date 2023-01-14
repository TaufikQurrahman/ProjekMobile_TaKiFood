package com.example.takifood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.takifood.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_beranda.*

class SettingNav : AppCompatActivity() {

    //deklarasi variable
    private var layoutManager: RecyclerView.LayoutManager?=null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)
        supportActionBar?.hide()

        //menentukan layoutManager untuk RecyclerView
        layoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = layoutManager
        //Link kan RecyclerView dengan class Adapter
        adapter = RecyclerAdapter()
        recycler_view.adapter = adapter

        val homeFragment = Home()
        val favoritFragment = Favorit()
        val keranjangFragment = Keranjang()
        val profileFragment = Profile()

        makeCurrentFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> makeCurrentFragment(homeFragment)
                R.id.favorit -> makeCurrentFragment(favoritFragment)
                R.id.keranjang -> makeCurrentFragment(keranjangFragment)
                R.id.profile -> makeCurrentFragment(profileFragment)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment:Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout, fragment)
            commit()
        }
}