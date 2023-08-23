package com.example.envitiatexttask

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.envitiatexttask.viewmodel.TextDisplayViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import java.text.SimpleDateFormat
import java.time.Clock
import java.time.Instant
import java.time.ZoneId
import java.util.Date
import java.util.Locale

class TextDisplayViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<String>

    private lateinit var viewModel: TextDisplayViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = TextDisplayViewModel()
        viewModel.displayText.observeForever(observer)
    }


    @Test
    fun `onButtonClick updates displayText with new entry`() {
        val newText1 = "Hello, World!"
        val currentTime1 = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
        val expectedEntry1 = "[$currentTime1] $newText1"

        viewModel.onButtonClick(newText1)

        verify(observer).onChanged(expectedEntry1)
    }
}
