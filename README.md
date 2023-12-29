
# IntentApp: A Simple Android Chat Application


##
#BRIAN BARNABAS LANGAY
2322190027
##


## Project Overview

IntentApp is a lightweight Android chat application designed to facilitate seamless communication between users. Leveraging the power of Intents, this app enables sending and receiving messages between two activities. The project is implemented in Java using Android Studio, making it accessible and adaptable.

## Tools and Technologies

- **Android Studio:** The primary integrated development environment for Android app development.
- **Java Programming Language:** The core language used for the project.
- **RecyclerView:** A powerful UI component for displaying large sets of data efficiently.
- **XML:** Used for designing layouts.

## Project Structure

### 1. Model Class - ChatMessage

The `ChatMessage` class represents a chat message and includes properties such as sender, message content, and message type.

```java
public class ChatMessage {
    private String sender;
    private String message;
    private int type;

    // Constructor, getters, and setters
}
```

### 2. ChatAdapter

The `ChatAdapter` manages the RecyclerView in both activities, handling different message types and inflating appropriate layouts.

```java
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    // Implementation details
}
```

### 3. ViewHolder Class in ChatAdapter

The `ViewHolder` class represents the views within a RecyclerView item, referencing `senderTextView`, `messageTextView`, and `messageLayout`.

```java
public class ViewHolder extends RecyclerView.ViewHolder {
    TextView senderTextView;
    TextView messageTextView;
    LinearLayout messageLayout;

    // Constructor
}
```

### 4. Activity Lifecycle Methods

Properly utilize lifecycle methods in both activities, avoiding duplicating code and handling shared functionality.

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    // Additional initialization
}
```

### 5. Layout Files

Maintain clear and consistent naming conventions for layout files, separating layouts for received and sent messages.

```xml
<!-- item_sms_received.xml -->
<!-- item_sms_sent.xml -->
<!-- item_sms_received_main2.xml -->
<!-- item_sms_sent_main2.xml -->
```

### 6. Resource Files

Utilize resource files for colors, drawables, or shared attributes, enhancing readability and allowing easy modifications.

```xml
<!-- Example color resource -->
<!-- Example drawable resource -->
```

### 7. Code Comments

Include meaningful comments to explain the purpose of the code, ensuring complex sections are well-documented.

```java
// Example comment explaining a critical section of code
```

### 8. Intent Handling

Encapsulate intent handling logic in dedicated methods, improving readability and facilitating future modifications.

```java
private void handleReceivedIntent(Intent intent) {
    // Implementation details
}
```

### 9. Separation of Concerns

Ensure each class or function has a single responsibility, following the Single Responsibility Principle for maintainability.

```java
// Example class or function with a single responsibility
```

## Conclusion

IntentApp provides a solid foundation for building more advanced chat applications on the Android platform. Its modular and well-organized structure, coupled with clear documentation, makes it an ideal starting point for developers looking to explore Android app development using Java and related technologies. The app embraces simplicity, promoting ease of understanding and extensibility for future enhancements.
