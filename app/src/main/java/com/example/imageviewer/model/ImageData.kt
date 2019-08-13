package com.example.imageviewer.model

import android.net.Uri
import java.io.Serializable

class ImageData(name: String, uri: Uri) : Serializable {
     private val name = name
     private val stringUri=uri.toString()
}
