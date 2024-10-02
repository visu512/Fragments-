package com.example.fragmentskotlin

import android.content.Context
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fragmentskotlin.databinding.ActivityMainBinding
import com.example.fragmentskotlin.fragments.BlankFragment1
import com.example.fragmentskotlin.fragments.BlankFragment2
import com.example.fragmentskotlin.fragments.BlankFragment3

class MainActivity() : AppCompatActivity(), Parcelable {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.button1.setOnClickListener {
            val manager = supportFragmentManager // support of fragment
            val tr = manager.beginTransaction() // start fragment
            tr.replace(R.id.frameLayout, BlankFragment1()) // replace frame layout to fragments
            tr.addToBackStack(null)
            tr.commit()

        }
        binding.button2.setOnClickListener {
            val manager = supportFragmentManager // support of fragment
            val tr = manager.beginTransaction() // start fragment
            tr.replace(R.id.frameLayout, BlankFragment2()) // replace frame layout to fragments
            tr.addToBackStack(null)
            tr.commit()

        }
        binding.status.setOnClickListener {
            val manager = supportFragmentManager // support of fragment
            val tr = manager.beginTransaction() // start fragment
            tr.replace(R.id.frameLayout, BlankFragment3()) // replace frame layout to fragments
            tr.addToBackStack(null)
            tr.commit()
        }

        // menu
        fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu_item,menu)
            return super.onCreateOptionsMenu(menu)
        }

        fun onOptionsItemSelected(item: MenuItem): Boolean {
            when (item.itemId){
                R.id.About -> Toast.makeText(this,"About Selected",Toast.LENGTH_SHORT).show()
                R.id.share -> Toast.makeText(this,"Settings Selected",Toast.LENGTH_SHORT).show()
                R.id.exit -> Toast.makeText(this,"Exit Selected",Toast.LENGTH_SHORT).show()
            }
            return super.onOptionsItemSelected(item)
        }

    }
    /// menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if present.
        menuInflater.inflate(R.menu.menu_item, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.share -> {
                Toast.makeText(this, "Share Selected", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.About -> {
                Toast.makeText(this, "camera Selected", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.exit -> {
                Toast.makeText(this, "logout  Selected", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.call -> {
                Toast.makeText(this, "call   Selected", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}