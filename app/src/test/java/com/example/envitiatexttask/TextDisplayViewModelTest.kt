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
import java.time.Clock
import java.time.Instant
import java.time.ZoneId

class TextDisplayViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<String>

    private lateinit var viewModel: TextDisplayViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        // Create a fixed instant for testing
        val fixedInstant = Instant.parse("2023-08-23T12:00:00Z")

        // Create a MockClockProvider with the fixed instant
        val mockClockProvider = MockClockProvider(fixedInstant)

        // Create the ViewModel with the MockClockProvider
        viewModel = TextDisplayViewModel(mockClockProvider)
        viewModel.displayText.observeForever(observer)
    }

    @Test
    fun `onButtonClick updates displayText with new entry`() {
        val newText = "Hello, World!"
        val fixedInstant = Instant.parse("2023-08-23T12:00:00Z")
        val expectedEntry = "[12:00] $newText"

        viewModel.onButtonClick(newText)

        verify(observer).onChanged(expectedEntry)
    }
}
