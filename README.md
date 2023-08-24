# Envitia Text Task

FUNCTIONALITY

[x] 1. Enter text and press OK button to append to the list along with the time the button was clicked.
[x] 2. Text should also be written to a text file on the device.
[x] 4. Use a layout.xml file to create the view
[x] 5. Use a view model to update the text with timestamps


DELIVERABLES
[x] 1. Unit tests.
[x] 2. Simple Espresso UI test (optional).

## My Approach
- In this task, I followed the requirements to create a simple text entry interface using XML layout files. Users can input text and click an "OK" button. Upon clicking, the entered text is displayed along with a timestamp. I used the ViewModel to manage the data and logic.
-  Additionally, I integrated logic to write the displayed text to a local text file on the device. Whenever the "OK" button is clicked, if I had more time I would have appended it to the viewmodel instead of the main activity.
- To verify the correctness of the ViewModel's behavior, I created unit tests using Mockito and JUnit. I also created an instrumented test to validate the UI and ViewModel interaction in a real device environment.
- Also, in future I would try to implement the data binding tools, but instead used LiveData to expose the data from the input to the field.
