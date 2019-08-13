package com.example.imageviewer.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.imageviewer.R
import com.example.imageviewer.model.ImageData
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_IMAGE_GET = 1
        const val REQUEST_IMAGE_DISPLAY = 2
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
        view.id = int


        //TODO: FIX THIS LATER, WORK ON RECYCLER
        /*
        view.setOnClickListener {
            var addImageIntent = Intent(this, DetailsActivity::class.java)
            addImageIntent.putExtra("display", view.id)
            startActivityForResult(addImageIntent, REQUEST_IMAGE_DISPLAY)
        }
        */
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data != null) {
        val photoUri = data.data
        val path = photoUri!!.path!!.split("/".toRegex()).dropLastWhile{it.isEmpty()}.toTypedArray()
            imageList.add(ImageData(path[path.size - 1], photoUri))
            picture_linear_layout.addView(createTextView(path[path.size - 1], imageList.size))

        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}
