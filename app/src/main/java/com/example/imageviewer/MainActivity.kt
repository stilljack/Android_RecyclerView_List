package com.example.imageviewer

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import java.util.jar.Attributes

class MainActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_IMAGE_GET = 1
        var index =0
        var imageList: ArrayList<ImageData> = ArrayList()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        add_button.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            if(intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, REQUEST_IMAGE_GET)
            }


        }



    }


    fun createTextView(string: String, int: Int): TextView {
        val view = TextView(this)
        view.text = string
        view.textSize = 24f
        view.setOnClickListener {  }
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data != null) {
        val photoUri = data.data
        val path = photoUri!!.path!!.split("/".toRegex()).dropLastWhile{it.isEmpty()}.toTypedArray()
        picture_linear_layout.addView(createTextView(path[path.size - 1],path.size))
        imageList.add(ImageData(path[path.size - 1], photoUri))
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}
