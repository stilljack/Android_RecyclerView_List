package com.example.imageviewer.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imageviewer.R

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)



        /*
        ///TODO WORK THIS OUT LATER, FOR NOW IMPLEMENT RECYCLER VIEW AND GO FROM THERE
        fun loadImage(uri: Uri) {
            img.setImageURI(uri)
        }

        val ss: String = intent.getStringExtra("display")
        loadImage(ss.toUri())

        */
    }
}
