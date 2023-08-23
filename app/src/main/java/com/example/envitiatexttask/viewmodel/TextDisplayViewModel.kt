package com.example.envitiatexttask.viewmodel

import android.app.Application
import android.content.ContentValues
import android.content.Context
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TextDisplayViewModel(): ViewModel() {

    val displayText = MutableLiveData<String>()

    fun onButtonClick(newText: String) {
        val currentTime = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
        val newEntry = "[$currentTime] $newText"
//        Log.d(ContentValues.TAG, "onButtonClick: $newEntry")

        val existingText = displayText.value ?: ""
        val updatedText = "$newEntry\n$existingText"
        displayText.value = updatedText
    }


}