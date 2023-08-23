package com.example.envitiatexttask

import android.content.ContentValues
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.envitiatexttask.databinding.ActivityMainBinding
import com.example.envitiatexttask.viewmodel.TextDisplayViewModel
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var textDisplayViewModel: TextDisplayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textDisplayViewModel = ViewModelProvider(this).get(TextDisplayViewModel::class.java)


        binding.okButton.setOnClickListener {
            val editText = binding.inputTextField.text.toString()
            textDisplayViewModel.onButtonClick(editText)
            binding.inputTextField.text.clear()
        }

        textDisplayViewModel.displayText.observe(this) { updatedText ->
            binding.displayText.text = updatedText
            writeToFile(updatedText)
        }


    }

    private fun writeToFile(text: String) {
        val fileName = "text_log.txt"
        try {
            openFileOutput(fileName, Context.MODE_APPEND).use { outputStream ->
                val dataWithNewline = "$text\n\n"
                outputStream.write(dataWithNewline.toByteArray())
                Toast.makeText(applicationContext, "Wrote to file: $fileName", Toast.LENGTH_SHORT).show()
                Log.d(ContentValues.TAG, "Wrote to file: $fileName")
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}